package io.dmalone.abacus.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;

public class Product {

	private String name;
	private BigDecimal price;
	private Set<ProductCategory> productCategories = new HashSet<ProductCategory>();
	
	public Product(){
		//default constructor necessary to adhere to the Java Beans contract
	}

	public Product(String name, String price, ProductCategory... productCategories) {
		this(name, new BigDecimal(price), productCategories);
	}
	
	public Product(String name, BigDecimal price, ProductCategory... productCategories) {
		this.name = name;
		this.price = price;
		for(ProductCategory productCategory : productCategories){
			this.productCategories.add(productCategory);
		}
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Set<ProductCategory> getProductCategories() {
		return productCategories;
	}

	public void setProductCategories(Set<ProductCategory> productCategories) {
		this.productCategories = productCategories;
	}
	
	public BigDecimal getTotalTax(){
		BigDecimal total = new BigDecimal("0.0");
		
		for(ProductCategory productCategory : this.productCategories){
			if(productCategory.isTaxExempt() != true){
				BigDecimal categoryTaxRate = productCategory.getTotalTaxRate();
				total = total.add(this.price.multiply(categoryTaxRate));
			}
		}
		
		return applyRoundingRules(total);
	}
	
	/*
	 * TODO - externalize this rounding algorithm into something like a Groovy
	 * file which can be reloaded and picked up automatically at runtime
	 */
	private BigDecimal applyRoundingRules(BigDecimal value){
		final BigDecimal multiple = new BigDecimal("0.05");
		return value.divide(multiple, 0, RoundingMode.UP).multiply(multiple);
	}
	
	public BigDecimal getPriceAfterTax(){
		BigDecimal price = this.price.add(getTotalTax());
		
		return price;
	}

	public void addCategory(ProductCategory productCategory) {
		this.productCategories.add(productCategory);
	}
	
}
