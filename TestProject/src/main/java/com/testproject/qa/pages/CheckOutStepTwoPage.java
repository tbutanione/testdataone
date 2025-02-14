package com.testproject.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testproject.qa.testbase.TestBase;

public class CheckOutStepTwoPage extends TestBase{

	//Pagefactory
		@FindBy(xpath="//button[@id='finish']")
		WebElement finishBtn;
		
		@FindBy(xpath="//h2[normalize-space()='Thank you for your order!']")
		WebElement completedMessage;
		
		@FindBy(xpath="//button[normalize-space()='Open Menu']")
		WebElement openMenu;
		
		@FindBy(xpath="//a[@id='logout_sidebar_link']")
		WebElement logOut;
	
      //Initialization
      	public CheckOutStepTwoPage()throws Exception {
      		PageFactory.initElements(Driver, this);
      	}

		//Actions
		public void clickFinishBtn() {
			finishBtn.click();
		}
		
		public boolean validateMessage() {
			return completedMessage.isDisplayed();
		}
		
		public void clickOpenMenu() {
			openMenu.click();
		}
		
		public void clickLogOut() {
			logOut.click();
		}
}
