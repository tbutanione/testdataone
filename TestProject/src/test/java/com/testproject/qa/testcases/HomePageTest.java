package com.testproject.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testproject.qa.testbase.TestBase;
import com.testproject.qa.pages.HomePage;
import com.testproject.qa.pages.LoginPage;
import com.testproject.qa.util.TestUtil;

public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	
    public HomePageTest()throws Exception {
    	super();
    }
	
    @BeforeMethod
    public void setUp()throws Exception {
    	initialization();
    	loginPage=new LoginPage();
    	testUtil=new TestUtil();
    	homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    	testUtil.testWaitFour();
    }
    
    @Test
    public void clickProductAddToCartTest()throws Exception {
    	homePage.clickSLBackpackAddToCartTest();
    	testUtil.testWaitFour();
    	homePage.clicksLBikeLightAddToCartTest();
    	testUtil.testWaitFour();
    }
    
    @AfterMethod
    public void tearDown() {
    	Driver.quit();
    }
}
