package com.searchengine.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.searchengine.utility.Helper;

public class GooglePage extends Helper {

	// Initializing the page objects
	public GooglePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "q")
	public WebElement searchTextBox;

	@FindBy(xpath = "(//input[@value='Google Search' and @type='submit'])[2]")
	public WebElement googleSearchBtn;

	@FindBy(linkText = "Sign in")
	WebElement signInBtn;

	String firstReturnedItem = "//div[@id='search']//a//h3[contains(text(),'%s')]";

//	@FindBy(xpath = "//div[@id='search']//a//h3[contains(text(),'Zensar: Think velocity')]")
//	public WebElement firstSearchItem;

	// Get title of Google Page
	public String validateGooglePageTitle() {
		return driver.getTitle();
	}

	// Search a value on Google page and return Google Search page
	public void searchOnGoogle(String value) {
		searchTextBox.clear();
		searchTextBox.sendKeys(value);
		searchTextBox.sendKeys(Keys.chord(Keys.ENTER));
	}

	// Getting the first searched item
	public String getFirstSearchedItem(String firstItem) {
		return convertStringToWebElement(firstReturnedItem, firstItem).getText();
	}

	// Click on SignIn button and return Google SignIn Page
	public GoogleSignInPage clickOnSignIn() {
		signInBtn.click();

		return new GoogleSignInPage();
	}

}
