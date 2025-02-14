package com.testproject.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testproject.qa.testbase.TestBase;

public class HomePage extends TestBase{
	
	//Page factory or object repository
		@FindBy(xpath="//img[@alt='LIC Logo']")
		WebElement imageLogo;
		
		@FindBy(xpath="//div[normalize-space()='Sauce Labs Backpack']")
		WebElement sLBackpack;
		
		@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")
		WebElement sLBackpackAddToCart;
		
		@FindBy(xpath="//div[normalize-space()='Sauce Labs Bike Light']")
		WebElement sLBikeLight;
		
		@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bike-light']")
		WebElement sLBikeLightAddToCart;
		
		@FindBy(xpath="//a[@class='shopping_cart_link']")
		WebElement clickAddToCartSymbol;
		
		@FindBy(xpath="//div[@class='inventory_item_price']")
		WebElement p1Price;
		
		@FindBy(xpath="//div[@class='inventory_item_price' and @data-test='inventory-item-price']")
		WebElement p2Price;
		
		//Initialization
		public HomePage()throws Exception {
			PageFactory.initElements(Driver, this);
		} 
			
		//Actions
		public void clickSLBackpackAddToCartTest() {
			sLBackpackAddToCart.click();
		}
		
		public void clicksLBikeLightAddToCartTest() {
			sLBikeLightAddToCart.click();
		}
		
		public void clickAddToCartSymbol() {
			clickAddToCartSymbol.click();
		}
		
		public String getP1Price() {
			return p1Price.getText();
		}
		
		public String getP2Price() {
			return p2Price.getText();
		}

}
