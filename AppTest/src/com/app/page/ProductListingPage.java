/**
 * 
 */
package com.app.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.app.utils.Product;

/**
 * @author roopesh.sharma
 *
 */
public class ProductListingPage {

	public static WebElement getSearchList(WebDriver driver) {
		return driver.findElement(By.id("com.ebay.mobile:id/search_result_fragment"));
	}
	
	public static WebElement getSortButton(WebDriver driver) {
		return driver.findElement(By.id("com.ebay.mobile:id/button_sort"));
	}
	
	public static WebElement getSortOption(WebDriver driver, String sortType) {
		return driver.findElement(By.xpath("//android.widget.CheckedTextView[contains(@text, '" + sortType + "')]/.."));
	}
	
	public static List<WebElement> getProductCell(WebElement ele) {
		return ele.findElements(By.id("com.ebay.mobile:id/cell_collection_item"));
	}
	
	public static Product getProduct(WebElement ele) {
		Product p = new Product();
		WebElement prodName = ele.findElement(By.id("com.ebay.mobile:id/textview_item_title"));
		WebElement prodPrice = ele.findElement(By.id("com.ebay.mobile:id/textview_item_price"));
		if(prodName != null && prodPrice != null) {
			p.setProductName(prodName.getText());
			p.setPrice(prodPrice.getText());
		}
		return p;
	}
	
	public static WebElement getFirstProduct(WebDriver driver) {
		return driver.findElement(By.id("com.ebay.mobile:id/cell_collection_item"));
	}

	public static WebElement getSnapdealFirstProduct(WebDriver driver) {
		return driver.findElement(By.id("com.snapdeal.main:id/product_grid_mainLayout"));
	}
}
