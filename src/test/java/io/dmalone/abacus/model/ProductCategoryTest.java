package io.dmalone.abacus.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProductCategoryTest {

	private ProductCategory taxExemptProductCategory;
	private ProductCategory nonExemptProductCategory;
	
	@Before
	public void setup(){
		this.taxExemptProductCategory = new ProductCategory("Music");
		this.nonExemptProductCategory = new ProductCategory("Alcohol", new TaxRate(0.10d));
	}
	
	@Test
	public void testIsTaxExemptReturnsWhenTaxesCollectionIsEmpty() {
		assertTrue(this.taxExemptProductCategory.isTaxExempt());
		assertTrue(this.taxExemptProductCategory.getTaxes().isEmpty());
	}

	@Test
	public void testIsTaxExemptReturnsFalseWhenTaxesCollectionContainsValues() {
		assertFalse(this.nonExemptProductCategory.isTaxExempt());
		assertFalse(this.nonExemptProductCategory.getTaxes().isEmpty());
	}
	
	@Test
	public void testGetTotalTaxRateReturnsNullWhenIsTaxExemptReturnsTrue() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetTotalTaxRateReturnsCorrectValidAccordingToTaxesCollectionValues() {
		fail("Not yet implemented");
	}

}
