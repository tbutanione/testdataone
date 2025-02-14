package com.testproject.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testproject.qa.testbase.TestBase;

public class CartPage extends TestBase{
	
	//Pagefactory
		@FindBy(id="item_4_title_link")
		WebElement sLBackpack;
		
		@FindBy(id="item_0_title_link")
		WebElement sLBikeLight;
		
		@FindBy(id="checkout")
		WebElement checkOutBtn;
		
		//Initialization
		public CartPage()throws Exception {
			PageFactory.initElements(Driver, this);
		}
		
		//Actions
		public void validateSelectedProductOneDisplay(String product1) {
			String p1=sLBackpack.getText();
			System.out.println(p1);
			if(p1.equals(product1)) {
				System.out.println("Product1 display properly");
			}else {
				System.out.println("Product1 not display properly");
			}
		}
		
		public void validateSelectedProductTwoDisplay(String product2) {
			String p2=sLBikeLight.getText();
			System.out.println("");
			System.out.println(p2);
			if(p2.equals(product2)) {
				System.out.println("Product2 display properly");
			}else {
				System.out.println("Product2 not display properly");
			}
		}
	
		
		public void clickCheckOutBtn() {
			checkOutBtn.click();
		}
		

}
