package io.dmalone.abacus.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class SalesTransaction {

	private Set<Product> products = new HashSet<Product>();

	public boolean addProduct(Product product){
		return this.products.add(product);
	}
	
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	public BigDecimal getTotalBeforeTax(){
		return null;
	}
	
	public BigDecimal getTotalSalesTax(){
		return null;
	}
	
	public BigDecimal getTotal(){
		BigDecimal total = new BigDecimal(0.0d);
		
		return total;
	}
	
}
