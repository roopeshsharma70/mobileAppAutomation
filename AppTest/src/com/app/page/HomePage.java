package com.app.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author roopesh.sharma
 *
 */
public class HomePage {


	public static WebElement getEbayLogo(WebDriver driver) {
		return driver.findElement(By.id("com.ebay.mobile:id/logo"));
	}
	
	public static WebElement getSearchBox(WebDriver driver) {
		return driver.findElement(By.id("com.ebay.mobile:id/search_box"));
	}
	
	public static WebElement getSnapdealLogo(WebDriver driver){
	return driver.findElement(By.className("android.widget.ImageView"));
}
	
	public static WebElement getSnapdealSearchBox(WebDriver driver) {
		return driver.findElement(By.id("com.snapdeal.main:id/search_text_view"));
	}
}