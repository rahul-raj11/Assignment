package com.searchengine.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.searchengine.base.BaseClass;
import com.searchengine.pages.BingPage;

public class BingPageTest extends BaseClass {
	
	BingPage bingPage;
	
	public BingPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialize();
		bingPage = new BingPage();
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		//quitBrowser();
	}

}
