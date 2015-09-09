package io.dmalone.abacus.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class ProductCategoryTest {

	private ProductCategory taxExemptProductCategory;
	private ProductCategory nonExemptProductCategory;
	private final TaxRate taxRate = new TaxRate(new BigDecimal("0.10"));
	
	@Before
	public void setup(){
		this.taxExemptProductCategory = new ProductCategory("Music");
		this.nonExemptProductCategory = new ProductCategory("Alcohol", taxRate);
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
		assertNull(this.taxExemptProductCategory.getTotalTaxRate());
		assertTrue(this.taxExemptProductCategory.isTaxExempt());
		assertTrue(this.taxExemptProductCategory.getTaxes().isEmpty());
	}
	
	@Test
	public void testGetTotalTaxRateReturnsCorrectValidAccordingToTaxesCollectionValues() {
		assertNotNull(this.nonExemptProductCategory.getTotalTaxRate());
		assertEquals(this.taxRate.getValue(), this.nonExemptProductCategory.getTotalTaxRate());
		assertFalse(this.nonExemptProductCategory.isTaxExempt());
		assertFalse(this.nonExemptProductCategory.getTaxes().isEmpty());
	}

}
