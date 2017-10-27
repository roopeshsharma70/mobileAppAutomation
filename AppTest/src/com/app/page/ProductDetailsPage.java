package com.app.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author roopesh.sharma
 *
 */
public class ProductDetailsPage {

	public static WebElement getProductImageFragment(WebDriver driver) {
		return driver.findElement(By.id("com.ebay.mobile:id/imageview_viewpager"));
	}
	
	public static List<WebElement> getWatchButton(WebDriver driver) {
		return driver.findElements(By.id("com.ebay.mobile:id/button_watch"));
	}
	
	public static WebElement getProductScrollView(WebDriver driver) {
		return driver.findElement(By.id("com.ebay.mobile:id/top_scrollview"));
	}
	
	public static List<WebElement> getProductVariationLayout(WebDriver driver) {
		return driver.findElements(By.id("com.ebay.mobile:id/variations_layout"));
	}
	
	public static WebElement getProductVariationSpinner(WebDriver driver) {
		return driver.findElement(By.id("com.ebay.mobile:id/spinner_selection_option"));
	}
	
	public static List<WebElement> selectProductVariation(WebDriver driver) {
		return driver.findElements(By.xpath("//android.widget.ListView/*"));
	}
	
	public static WebElement getVariationPageWatchButton(WebDriver driver) {
		return driver.findElement(By.id("com.ebay.mobile:id/button_watch_buybar"));
	}
	public static WebElement getSnapdealPincodePopup(WebDriver driver) {
		return driver.findElement(By.id("com.snapdeal.main:id/shipnearPincode"));
	}
	public static WebElement getSnapdealPincodePopupSubmit(WebDriver driver) {
		return driver.findElement(By.id("com.snapdeal.main:id/shipnearverifyBtn"));
	}
}
