package com.searchengine.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.searchengine.base.BaseClass;

public class BingPage extends BaseClass {

	// Initializing the page objects
	public BingPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "q")
	public WebElement searchTextBox;

	@FindBy(linkText = "Sign in")
	WebElement signInBtn;

	// Get title of Bing Page
	public String validateBingPageTitle() {
		return driver.getTitle();
	}

	// Search a value on Bing page and return Bing Search page
	public void searchOnBing(String value) {
		searchTextBox.clear();
		searchTextBox.sendKeys(value);
		searchTextBox.sendKeys(Keys.chord(Keys.ENTER));
	}

}
