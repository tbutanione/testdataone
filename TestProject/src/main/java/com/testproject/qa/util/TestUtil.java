package com.testproject.qa.util;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testproject.qa.testbase.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICITLY_WAIT=10;
	
	public TestUtil()throws Exception {
		
	}
	
	public void testWaitTwo()throws Exception {
		Thread.sleep(2000);	
	}
	
	public void testWaitFour()throws Exception {
		Thread.sleep(4000);
	}
	
	public void testWaitEight()throws Exception {
		Thread.sleep(8000);
	}
	
	public void testWaitEleven()throws Exception {
		Thread.sleep(11000);
	}
	
	public void testWaitFourteen()throws Exception {
		Thread.sleep(14000);
	}
	
	public void waitForVisibility(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Explicit Wait: Waits until an element is clickable
    public void waitForClickability(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
