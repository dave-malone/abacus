package io.dmalone.abacus.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SalesTransaction {

	private List<Product> products = new ArrayList<Product>();

	public boolean addProduct(Product product){
		return this.products.add(product);
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
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
