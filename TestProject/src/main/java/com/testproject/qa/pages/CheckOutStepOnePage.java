package com.testproject.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testproject.qa.testbase.TestBase;

public class CheckOutStepOnePage extends TestBase{
	
	//Pagefactory
		@FindBy(id="first-name")
		WebElement firstName;
		
		@FindBy(id="last-name")
		WebElement lastName;
		
		@FindBy(id="postal-code")
		WebElement postalCode;
		
		@FindBy(id="continue")
		WebElement continueBtn;
		
		//Initialization
		public CheckOutStepOnePage()throws Exception {
			PageFactory.initElements(Driver, this);
		}
		
		//Actions
		public void enterFirstName(String fname) {
			firstName.sendKeys(fname);
		}
		
		public void enterLastName(String lname) {
			lastName.sendKeys(lname);
		}
		
		public void enterPostalCode(String pcode) {
			postalCode.sendKeys(pcode);
		}
		
		public void clickContinueBtn() {
			continueBtn.click();
		}

}
