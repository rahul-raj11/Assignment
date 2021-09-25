package com.searchengine.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.searchengine.base.BaseClass;
import com.searchengine.pages.GooglePage;
import com.searchengine.utility.TestUtil;

public class GooglePageTest extends BaseClass{
	
	GooglePage googlePage;
	
	String sheetName = "googlePage";
	
	public GooglePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUpMethod() {
		initialize();
		googlePage = new GooglePage();
	}
	
	@Test(priority = 1, dataProvider = "getGoogleTestData")
	public void searchItemOnGoogleAndVerify(String valueToSearch, String searchedItem) {
		String title = googlePage.validateGooglePageTitle();
		Assert.assertEquals(title, prop.getProperty("googlePageTitle"), "Title of search engine is not matched");
		googlePage.searchOnGoogle(valueToSearch);
		String firstSearchedItem = googlePage.getFirstSearchedItem(searchedItem);
		Assert.assertEquals(firstSearchedItem, searchedItem, "First returned item not matched");
	}
	
	@DataProvider
	public Object[][] getGoogleTestData() {
		Object[][] data = TestUtil.getTestData(sheetName);;
		return data;
	}
	
	@AfterMethod
	public void tearDownMethod() {
		quitBrowser();
	}
	
	

}
