package com.testproject.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testproject.qa.pages.HomePage;
import com.testproject.qa.pages.LoginPage;
import com.testproject.qa.testbase.TestBase;
import com.testproject.qa.util.TestUtil;

public class LoginPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	
	public LoginPageTest()throws Exception {
		super();
		
	}
	@BeforeMethod
	public void setUp()throws Exception {
		initialization();
		loginPage=new LoginPage();
		testUtil=new TestUtil();
		
	}
	
	@Test(priority=1)
	public void verifyTitleTest() {
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Swag Labs");
	}
	
	@Test(priority=2)
	public void verifyLogoImageTest() {
		boolean flag=loginPage.validateLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest()throws Exception {
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.testWaitTwo();;
	} 
	
	@AfterMethod
	public void tearDown() {
		Driver.quit();
	}
}
