package io.dmalone.abacus.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Receipt {

	private List<Product> products = new ArrayList<Product>();

	public boolean add(Product product){
		return this.products.add(product);
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public BigDecimal getTotalBeforeTax(){
		BigDecimal total = new BigDecimal("0.0");
		
		for(Product product : this.products){
			total = total.add(product.getPrice());
		}
		
		return total;
	}
	
	public BigDecimal getTotalSalesTax(){
		BigDecimal total = new BigDecimal("0.0");
		
		for(Product product : this.products){
			total = total.add(product.getTotalTax());
		}
		
		return total;
	}
	
	public BigDecimal getTotal(){
		return getTotalBeforeTax().add(getTotalSalesTax());
	}
	
}
