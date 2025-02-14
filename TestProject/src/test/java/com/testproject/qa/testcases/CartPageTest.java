package com.testproject.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testproject.qa.testbase.TestBase;
import com.testproject.qa.pages.CartPage;
import com.testproject.qa.pages.HomePage;
import com.testproject.qa.pages.LoginPage;
import com.testproject.qa.util.TestUtil;

public class CartPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	TestUtil testUtil;
	
	public CartPageTest()throws Exception {
		super();
	}
	
	@BeforeMethod
	public void setUp()throws Exception {
		initialization();
		loginPage=new LoginPage();
		cartPage=new CartPage();
		testUtil=new TestUtil();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.clickSLBackpackAddToCartTest();
		testUtil.testWaitTwo();
		homePage.clicksLBikeLightAddToCartTest();
		testUtil.testWaitTwo();
		homePage.clickAddToCartSymbol();
		testUtil.testWaitTwo();
	
	}
	
	@Test
	public void validateSelectedProductsDisplayTest()throws Exception {
		cartPage.validateSelectedProductOneDisplay("Sauce Labs Backpack");
		testUtil.testWaitFour();
		cartPage.validateSelectedProductTwoDisplay("Sauce Labs Bike Light");
		testUtil.testWaitFour();
		cartPage.clickCheckOutBtn();
		testUtil.testWaitFour();
	}
	
	@AfterMethod
	public void tearDown() {
		Driver.quit();
	}

}
