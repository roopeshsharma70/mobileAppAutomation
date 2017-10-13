package com.app.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;

/**
 * @author roopesh.sharma
 *
 */
public class SearchPage {

	public static WebElement getSearchEditBox(WebDriver driver) {
		return driver.findElement(By.id("com.ebay.mobile:id/search_src_text"));
	}
	
	public static Boolean clickSearchBtnViaDimension(WebDriver driver) {
		Dimension dimensions = driver.manage().window().getSize();
		float screenWidth = dimensions.getWidth();
		float screenHeight = dimensions.getHeight();
		Boolean flag = true;
		try {
			new TouchAction((PerformsTouchActions) driver).tap((int) screenWidth-100, (int) screenHeight-70).perform();
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
}
