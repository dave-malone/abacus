package io.dmalone.abacus.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SalesTransactionTest {

	private SalesTransaction salesTransaction;
	private Product product;
	private ProductCategory productCategoryBooks;
	private ProductCategory productCategoryMedical;
	private ProductCategory productCategoryFood;
	private ProductCategory productCategoryClothes;
	private ProductCategory productCategoryMusic;
	
	@Before
	public void setup(){
		productCategoryBooks = new ProductCategory("Books");
		productCategoryMedical = new ProductCategory("Medical");
		productCategoryFood = new ProductCategory("Food");
		productCategoryClothes = new ProductCategory("Clothing");
		productCategoryMusic = new ProductCategory("Music");
		
		salesTransaction = new SalesTransaction();
	}
	
	
	@Test
	public void testAddProduct() {
		
	}

	@Test
	public void testGetTotalBeforeTax() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTotalSalesTax() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTotal() {
		fail("Not yet implemented");
	}

}
