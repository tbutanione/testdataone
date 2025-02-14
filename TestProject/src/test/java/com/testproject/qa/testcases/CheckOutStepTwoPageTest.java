package com.testproject.qa.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testproject.qa.testbase.TestBase;
import com.testproject.qa.pages.CartPage;
import com.testproject.qa.pages.CheckOutStepOnePage;
import com.testproject.qa.pages.CheckOutStepTwoPage;
import com.testproject.qa.pages.HomePage;
import com.testproject.qa.pages.LoginPage;
import com.testproject.qa.util.TestUtil;

public class CheckOutStepTwoPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	CheckOutStepOnePage checkOutStepOnePage;
	CheckOutStepTwoPage CheckOutStepTwoPage;
	TestUtil testUtil;
	
	public CheckOutStepTwoPageTest()throws Exception{
		super();
	}
	
	@BeforeMethod
	public void setUp()throws Exception {
		initialization();
		loginPage=new LoginPage();
		cartPage=new CartPage();
		checkOutStepOnePage=new CheckOutStepOnePage();
		CheckOutStepTwoPage=new CheckOutStepTwoPage();
		testUtil=new TestUtil();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.clickSLBackpackAddToCartTest();
		testUtil.testWaitTwo();
		homePage.clicksLBikeLightAddToCartTest();
		testUtil.testWaitTwo();
		homePage.clickAddToCartSymbol();
		testUtil.testWaitTwo();
		cartPage.validateSelectedProductOneDisplay("Sauce Labs Backpack");
		testUtil.testWaitTwo();
		cartPage.validateSelectedProductTwoDisplay("Sauce Labs Bike Light");
		testUtil.testWaitTwo();
		cartPage.clickCheckOutBtn();
		testUtil.testWaitTwo();
		checkOutStepOnePage.enterFirstName("Vijay");
		testUtil.testWaitTwo();
		checkOutStepOnePage.enterLastName("Patel");
		testUtil.testWaitTwo();
		checkOutStepOnePage.enterPostalCode("382350");
		testUtil.testWaitTwo();
		checkOutStepOnePage.clickContinueBtn();
		testUtil.testWaitFour();
	}
	
	@Test
	public void test()throws Exception {
		
		// Get product prices from the webpage
		List<WebElement> priceElements = Driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		if (priceElements.size() >= 2) {
		     String product1Price = priceElements.get(0).getText();
		     String product2Price = priceElements.get(1).getText();

		     System.out.println("Product1 Price: " + product1Price);
		     System.out.println("Product2 Price: " + product2Price);
		 } else {
		     System.out.println("Price elements not found!");
		 }
				
		 WebElement product1PriceElement = Driver.findElement(By.xpath("//div[@class='inventory_item_price']"));
		 WebElement product2PriceElement = Driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[4]/div[2]/div[2]/div"));
		 WebElement itemTotalElement = Driver.findElement(By.xpath("//div[@class='summary_subtotal_label']"));
		 WebElement taxElement = Driver.findElement(By.xpath("//div[@class='summary_tax_label']"));
		 WebElement totalElement = Driver.findElement(By.xpath("//div[@class='summary_total_label']"));

		 // Convert prices to double
		 double product1Price = Double.parseDouble(product1PriceElement.getText().replace("$", ""));
		 double product2Price = Double.parseDouble(product2PriceElement.getText().replace("$", ""));
		        
		 String itemTotalText = "Item total: 39.98";
		 String numericValue = itemTotalText.replaceAll("[^0-9.]", "");

		 double itemTotal = Double.parseDouble(numericValue);
		 System.out.println("Converted Item Total: " + itemTotal);
		        
		 String taxText = taxElement.getText();
		 String numericValuea = taxText.replaceAll("[^0-9.]", "");
		 double tax = Double.parseDouble(numericValuea);
		 System.out.println("Tax: " + tax);
		        
		 String totalText = totalElement.getText();
		 String numericValueb = totalText.replaceAll("[^0-9.]", "");
		 double total = Double.parseDouble(numericValueb);
		 System.out.println("Total: " + total);
		        
		 // Calculate expected values
		 double expectedItemTotal = product1Price + product2Price;
		 double expectedTotal = expectedItemTotal + tax;
		        
		 Assert.assertEquals(itemTotal, expectedItemTotal, "Item total mismatch!");
		 Assert.assertEquals(total, expectedTotal, "Total price mismatch!");
		        
		 CheckOutStepTwoPage.clickFinishBtn();
		 testUtil.testWaitTwo();
		 boolean message=CheckOutStepTwoPage.validateMessage();
		 testUtil.testWaitTwo();
		 Assert.assertTrue(message);
		 testUtil.testWaitFour();
		 JavascriptExecutor jsx=(JavascriptExecutor)Driver;
		 jsx.executeScript("window.scrollBy(0,-450)");
		 testUtil.testWaitTwo();
		 CheckOutStepTwoPage.clickOpenMenu();
		 testUtil.testWaitTwo();
		 CheckOutStepTwoPage.clickLogOut();
		 testUtil.testWaitTwo();
		 boolean flag=loginPage.validateLogo();
		 Assert.assertTrue(flag);
		 testUtil.testWaitTwo();
		        
	}
	
	@AfterMethod
	public void tearDown() {
		 Driver.quit();
	} 

}
