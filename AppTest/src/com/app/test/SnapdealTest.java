package com.app.test;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.app.base.AppAttributes;
import com.app.base.TestBase;
import com.app.page.HomePage;
import com.app.page.LoginPage;
import com.app.page.ProductDetailsPage;
import com.app.page.ProductListingPage;
import com.app.page.SearchPage;
import com.app.utils.LogReporter;
import com.app.utils.Product;

/**
 * @author aman.agrawal
 *
 */
public class SnapdealTest extends TestBase {
	
	static WebElement ele = null;
	
	@Test
	public void snapdeal_Product_Search_Sort_PDP_Watch_Login_Test() throws Exception {
		//Check for Home Page is shown
		ele = HomePage.getSnapdealLogo(getDriver());
	//ele.click();
		Assert.assertNotNull(ele, "Home page is not shown.");
		if(ele.isDisplayed())
			LogReporter.stepReporting(getDriver(),"Home page is shown.",true);
		else
			LogReporter.stepReporting(getDriver(),"Home page is not shown.",true);//stepReporting method is used to step report with or without screenshot  
		
		//Search box is visibility on Home Page 
		ele = HomePage.getSnapdealSearchBox(getDriver());
		if(ele.isDisplayed())
			LogReporter.stepReporting(getDriver(),"Search box is shown on Home page.",true);
		else
			LogReporter.stepReporting(getDriver(),"Search box is not shown on Home page.",true);
		//Click on Search box	
		ele.click();
		
		//Search for keyword
		searchKeyword(AppAttributes.SEARCH_KEYWORD);
		
		//Check for Product listing page
		/*ele = getElementWhenReady(ProductListingPage.getSearchList(getDriver()), 60);
		Assert.assertNotNull(ele, "Product Listing is not shown.");
		
		//Click on Sort Button
		getElementWhenReady(ProductListingPage.getSortButton(getDriver()), 30).click();
		//Sort by Lowest price
		ele = ProductListingPage.getSortOption(getDriver(), "Lowest Price");
		if(ele.isDisplayed())
			LogReporter.stepReporting(getDriver(),"Sort by Lowest Price is shown on Product Listing page.",true);
		else
			LogReporter.stepReporting(getDriver(),"Sort by Lowest Price is not shown on Product Listing page.",true);
		ele.click();
		
		//Get first 10 Products list
		List<Product> productList = getListOfProduct(10);
		for (Product product : productList) {
			LogReporter.stepReporting(getDriver(),product.getProductName()+" --->  "+product.getPrice(),false);
		}
		
		scrollToTop(ProductListingPage.getSearchList(getDriver()));
		// Click on Sort Button
		ProductListingPage.getSortButton(getDriver()).click();
		// Sort by Best Match
		ProductListingPage.getSortOption(getDriver(), "Best Match").click();
		
		//Click on First item
		ele = getElementWhenReady(ProductListingPage.getFirstProduct(getDriver()),30);
		Assert.assertNotNull(ele, "Product Tile is not shown.");
		ele.click();
		
		*/
		ele=getElementWhenReady(ProductListingPage.getSnapdealFirstProduct(getDriver()), 30);
		Assert.assertNotNull(ele, "Product tile not shown");
		ele.click();
		//Check for Product Details Page
		/*
		ele = getElementWhenReady(ProductDetailsPage.getProductImageFragment(getDriver()), 30);
		Assert.assertNotNull(ele, "Product Details Page is not shown.");
		LogReporter.stepReporting(getDriver(),"Product Details Page is shown.",true);
		
		//Click on Watch Button
		List<WebElement> WatchBtn = ProductDetailsPage.getWatchButton(getDriver());
		if(WatchBtn.size() == 0) {
			scrollToBottom(ProductDetailsPage.getProductScrollView(getDriver()));
			ProductDetailsPage.getWatchButton(getDriver()).get(0).click();
		}else
			WatchBtn.get(0).click();
		if(ProductDetailsPage.getProductVariationLayout(getDriver()).size() != 0) {
			ProductDetailsPage.getProductVariationSpinner(getDriver()).click();
			ProductDetailsPage.selectProductVariation(getDriver()).get(1).click();
			try {
				ProductDetailsPage.getVariationPageWatchButton(getDriver()).click();
			} catch (Exception e) {
				ProductDetailsPage.getWatchButton(getDriver()).get(0).click();
			}
		}
		
		//Check for login page
		ele = LoginPage.getLoginPageTitle(getDriver());
		assertTrue(ele.isDisplayed(), "Login Page is not shown.");
		
		//Write user name in text box
		ele =  LoginPage.getUserName(getDriver());
		ele.clear();
		ele.sendKeys("roopeshsharma70@yahoo.com");
		
		//Click on Close button
		LoginPage.getCloseBtn(getDriver()).click();
		*/
		
		//inserting pincode on PDP
		ele=getElementWhenReady(ProductDetailsPage.getSnapdealPincodePopup(getDriver()), 30);
		Assert.assertNotNull(ele, "Popup Not Shown");
		if(ele.isDisplayed()){
			LogReporter.stepReporting(getDriver(), "element shown", true);
		ele.sendKeys("110101");
		
		ele=getElementWhenReady(ProductDetailsPage.getSnapdealPincodePopupSubmit(getDriver()), 30);
		ele.click();
		}
		else{
			LogReporter.stepReporting(getDriver(), "element not shown", true);
		}
	}
	
	/**
	 * Method will return the Product list
	 * @param n number of product
	 */
	private List<Product> getListOfProduct(int n){
		ele = ProductListingPage.getSearchList(getDriver());
		
		Set<Product> product = new LinkedHashSet<Product>();
		while(product.size()<n) {
			List<WebElement> pList = ProductListingPage.getProductCell(ele);
			for (WebElement e : pList) {
				try {
					product.add(ProductListingPage.getProduct(e));
					if(!(product.size()<n))
						break;
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			scrollToBottom(ele);
		}
		ArrayList<Product> prodList = new ArrayList<Product>(product);
		return prodList;
	}
	
	/**
	 * Method will search for keyword
	 * @param keyword String to be search
	 */
	private void searchKeyword(String keyword) throws Exception {
		// Search Edit Text Box Visibility on Search Page
		ele = SearchPage.getSnapdealSearchEditBox(getDriver());
		if (ele.isDisplayed())
			LogReporter.stepReporting(getDriver(), "Search edit text box is shown.", true);
		else
			LogReporter.stepReporting(getDriver(), "Search edit text box is not shown.", true);
		// Search for keyword 'watch'
		ele.sendKeys(keyword);
		// Android Serach button click from Key board
		Assert.assertTrue(SearchPage.clickSearchBtnViaDimension(getDriver()), "Search Button is not clicked.");
		
		ele=getElementWhenReady(SearchPage.denyLocationPopup(getDriver()),30);
		if(ele.isDisplayed()){
		ele.click();
		}
		else{
			LogReporter.stepReporting(getDriver(), "Location Pop up Not shown.", true);
			
		}
	}

}
