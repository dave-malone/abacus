package io.dmalone.abacus.model;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

/**
 * This class would be better represented in a BDD test framework, but time will not currently permit
 * integrating a framework such as FitNesse at this point
 * 
 * @author dmalone
 *
 */
public class ReceiptTest {

	private TaxRate basicSalesTax;
	private TaxRate importTax;
	
	private ProductCategory books;
	private ProductCategory food;
	private ProductCategory medical;
	private ProductCategory music;
	private ProductCategory perfume;
	private ProductCategory importedGoods;
	
	@Before
	public void setup(){
		basicSalesTax = new TaxRate("0.10");
		importTax = new TaxRate("0.05");
		
		books = new ProductCategory("Books");
		medical = new ProductCategory("Medical");
		food = new ProductCategory("Food");
		perfume = new ProductCategory("Perfume", basicSalesTax);
		music = new ProductCategory("Music", basicSalesTax);
		importedGoods = new ProductCategory("Imported Goods", importTax);
	}

	@Test
	public void testInput1ProducesOutput1() {
		Product book = new Product("Book", "12.49", books);
		Product cd = new Product("Music CD", "14.99", music);
		Product chocolateBar = new Product("Chocolate Bar", "0.85", food);
		
		assertEquals(new BigDecimal("12.49"), book.getPriceAfterTax());
		assertEquals(new BigDecimal("16.49"), cd.getPriceAfterTax());
		assertEquals(new BigDecimal("0.85"), chocolateBar.getPriceAfterTax());
		
		Receipt receipt = new Receipt();
		receipt.add(book);
		receipt.add(cd);
		receipt.add(chocolateBar);
		
		assertEquals(new BigDecimal("1.50"), receipt.getTotalSalesTax());
		assertEquals(new BigDecimal("29.83"), receipt.getTotal());
	}

	@Test
	public void testInput2ProducesOutput2() {
		Product importedBoxOfChocolates = new Product("Imported Box of Chocolates", "10.00", food, importedGoods);
		Product importedBottleOfPerfume = new Product("Imported Bottle of Perfume", "47.50", perfume, importedGoods);
		
		assertEquals(new BigDecimal("10.50"), importedBoxOfChocolates.getPriceAfterTax());
		assertEquals(new BigDecimal("54.65"), importedBottleOfPerfume.getPriceAfterTax());
		
		Receipt receipt = new Receipt();
		receipt.add(importedBottleOfPerfume);
		receipt.add(importedBoxOfChocolates);
		
		assertEquals(new BigDecimal("7.65"), receipt.getTotalSalesTax());
		assertEquals(new BigDecimal("65.15"), receipt.getTotal());
	}

	@Test
	public void testInput3ProducesOutput3() {
		Product importedBottleOfPerfume = new Product("Imported Bottle of Perfume", "27.99", perfume, importedGoods);
		Product bottleOfPerfume = new Product("Bottle of Perfume", "18.99", perfume);
		Product packetOfHeadachePills = new Product("Packet of Headache Pills", "9.75", medical);
		Product importedBoxOfChocolates = new Product("Imported Box of Chocolates", "11.25", food, importedGoods);
		
		assertEquals(new BigDecimal("32.19"), importedBottleOfPerfume.getPriceAfterTax());
		assertEquals(new BigDecimal("20.89"), bottleOfPerfume.getPriceAfterTax());
		assertEquals(new BigDecimal("9.75"), packetOfHeadachePills.getPriceAfterTax());
		assertEquals(new BigDecimal("11.85"), importedBoxOfChocolates.getPriceAfterTax());
		
		Receipt receipt = new Receipt();
		receipt.add(importedBottleOfPerfume);
		receipt.add(bottleOfPerfume);
		receipt.add(packetOfHeadachePills);
		receipt.add(importedBoxOfChocolates);
		
		assertEquals(new BigDecimal("6.70"), receipt.getTotalSalesTax());
		assertEquals(new BigDecimal("74.68"), receipt.getTotal());
	}

}
