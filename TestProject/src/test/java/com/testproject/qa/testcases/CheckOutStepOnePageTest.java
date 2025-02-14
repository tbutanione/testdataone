package com.testproject.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testproject.qa.testbase.TestBase;
import com.testproject.qa.pages.CartPage;
import com.testproject.qa.pages.CheckOutStepOnePage;
import com.testproject.qa.pages.HomePage;
import com.testproject.qa.pages.LoginPage;
import com.testproject.qa.util.TestUtil;

public class CheckOutStepOnePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	CheckOutStepOnePage checkOutStepOnePage;
	TestUtil testUtil;
	
	public CheckOutStepOnePageTest()throws Exception {
		super();
	}
	
	@BeforeMethod
	public void setUp()throws Exception {
		initialization();
		loginPage=new LoginPage();
		cartPage=new CartPage();
		checkOutStepOnePage=new CheckOutStepOnePage();
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
	}
	
	@Test
	public void test()throws Exception {
		checkOutStepOnePage.enterFirstName("Vijay");
		testUtil.testWaitTwo();
		checkOutStepOnePage.enterLastName("Patel");
		testUtil.testWaitTwo();
		checkOutStepOnePage.enterPostalCode("382350");
		testUtil.testWaitTwo();
		checkOutStepOnePage.clickContinueBtn();
		testUtil.testWaitFour();
	}
	
	@AfterMethod
	public void tearDown() {
		Driver.quit();
	} 

}
