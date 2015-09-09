package io.dmalone.abacus.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


public class ProductCategory {

	private String name;
	private Set<TaxRate> taxes = new HashSet<TaxRate>();
	
	public ProductCategory(){
		//default constructor necessary to adhere to the Java Beans contract
	}
	
	public ProductCategory(String name) {
		this.name = name;
	}
	
	public ProductCategory(String name, TaxRate... taxes) {
		this.name = name;
		for(TaxRate tax : taxes){
			this.taxes.add(tax);
		}
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void addTax(TaxRate tax){
		this.taxes.add(tax);
	}

	public Set<TaxRate> getTaxes() {
		return taxes;
	}

	public void setTaxes(Set<TaxRate> taxes) {
		this.taxes = taxes;
	}
	
	public boolean isTaxExempt(){
		return this.taxes.isEmpty();
	}
	
	/**
	 * If this product category is tax exempt, returns null; otherwise, returns
	 * total tax rate based on all of the taxes associated with this product category
	 * @return
	 */
	public BigDecimal getTotalTaxRate(){
		if(isTaxExempt()){
			return null;
		}
		
		BigDecimal totalTaxRate = new BigDecimal(0.0d);
		
		for(TaxRate tax : this.taxes){
			totalTaxRate = totalTaxRate.add(tax.getValue());
		}
		
		return totalTaxRate;
	}
	
}
