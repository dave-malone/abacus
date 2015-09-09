package io.dmalone.abacus.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Product {

	private String name;
	private BigDecimal price;
	private Set<ProductCategory> productCategories = new HashSet<ProductCategory>();
	
	public Product(){
		//default constructor necessary to adhere to the Java Beans contract
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
	
	public BigDecimal getPriceAfterTax(){
		BigDecimal price = this.price;
		
		for(ProductCategory productCategory : this.productCategories){
			if(productCategory.isTaxExempt() != true){
				BigDecimal categoryTaxRate = productCategory.getTotalTaxRate();
				price.add(getPrice().multiply(categoryTaxRate));
			}
		}
		
		return price;
	}
	
}
