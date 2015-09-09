package io.dmalone.abacus.model;

import java.math.BigDecimal;

public class TaxRate {

	private BigDecimal value;
	
	public TaxRate(){
		//default constructor necessary to adhere to the Java Beans contract
	}

	public TaxRate(double value){
		this.setValue(value);
	}
	
	public TaxRate(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal getValue() {
		return value;
	}
	
	public void setValue(double value){
		this.setValue(new BigDecimal(value));
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}
	
}
