package com.testproject.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testproject.qa.testbase.TestBase;

public class LoginPage extends TestBase {
	
	//Page factory or object 
			@FindBy(id="user-name")
			WebElement username;
			
			@FindBy(id="password")
			WebElement password;
			
			@FindBy(id="login-button")
			WebElement loginBtn;
			
			@FindBy(xpath="//div[@class='login_logo']")
			WebElement imageLogo;
			
			//Initialization
			public LoginPage()throws Exception {
				PageFactory.initElements(Driver, this);
				
		    }
			
			//Actions
			public String validateLoginPageTitle() {
				return Driver.getTitle();
			}
			
			public boolean validateLogo() {
				return imageLogo.isDisplayed();
			}
			
			public HomePage login(String un, String pwd)throws Exception {
				username.sendKeys(un);
				password.sendKeys(pwd);
				loginBtn.click();
				return new HomePage();
			}

}
