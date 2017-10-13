package com.app.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author roopesh.sharma
 *
 */
public class LoginPage {

	public static WebElement getLoginPageTitle(WebDriver driver) {
		return driver.findElement(By.id("com.ebay.mobile:id/sign_in_title"));
	}
	
	public static WebElement getUserName(WebDriver driver) {
		return driver.findElement(By.id("com.ebay.mobile:id/edit_text_username"));
	}
	
	public static WebElement getCloseBtn(WebDriver driver) {
		return driver.findElement(By.id("com.ebay.mobile:id/button_close"));
	}
	
}
