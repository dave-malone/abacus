package io.dmalone.abacus.model;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class ProductTest {

	private Product taxExemptProduct;
	private Product taxableProduct;
	private ProductCategory taxExemptProductCategory;
	private ProductCategory taxableProductCategory;
	private ProductCategory anotherTaxableProductCategory;
	
	@Before
	public void setup(){
		taxExemptProductCategory = new ProductCategory("Tax Exempt");
		taxableProductCategory = new ProductCategory("Taxable", new TaxRate(new BigDecimal("0.10")));
		anotherTaxableProductCategory = new ProductCategory("I'm taxable, too!", new TaxRate(new BigDecimal("0.05")));
		taxExemptProduct = new Product("Tax Exempt Product", new BigDecimal("9.99"), taxExemptProductCategory);
		taxableProduct = new Product("Taxable Product", new BigDecimal("4.99"), taxableProductCategory);
	}
	
	@Test
	public void testGetPriceAfterTaxReturnsSameValueAsGetPriceWhenProductCategoryIsTaxExemptOnly() {
		assertNotNull(taxExemptProduct.getPriceAfterTax());
		assertEquals(taxExemptProduct.getPrice(), taxExemptProduct.getPriceAfterTax());
	}
	
	@Test
	public void testGetPriceAfterTaxReturnsCorrectValueBasedOnTaxRateReturnedFromOneProductCategory() {
		assertNotNull(taxableProduct.getPriceAfterTax());
		assertNotEquals(taxableProduct.getPrice(), taxableProduct.getPriceAfterTax());
		
		//tax with price = price + price * total 
		BigDecimal expectedPriceWithTax = new BigDecimal("5.49");
		assertEquals(expectedPriceWithTax, taxableProduct.getPriceAfterTax());
	}
	
	@Test
	public void testGetPriceAfterTaxReturnsCorrectValueBasedOnTaxRateReturnedFromMultipleProductCategories() {
		taxableProduct.addCategory(anotherTaxableProductCategory);
		assertNotNull(taxableProduct.getPriceAfterTax());
		assertNotEquals(taxableProduct.getPrice(), taxableProduct.getPriceAfterTax());

		BigDecimal expectedPriceWithTax = new BigDecimal("5.74");
		assertEquals(expectedPriceWithTax, taxableProduct.getPriceAfterTax());
	}

}
