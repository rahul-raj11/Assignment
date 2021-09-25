package com.searchengine.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.searchengine.base.BaseClass;

public class Helper extends BaseClass {

	// Screenshot, alerts,frames, windows, Sync issue, javascript executor

	public static String captureScreenshot(WebDriver driver) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir") + "/Screenshots/SearchEngine_" + getCurrentDateTime()
				+ ".png";

		try {

			FileUtils.copyFile(src, new File(screenshotPath));

			System.out.println("Screenshot captured");

		} catch (IOException e) {

			System.out.println("Unable to capture screenshot " + e.getMessage());
		}

		return screenshotPath;

	}
	
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/Screenshots/SearchEngine_" + getCurrentDateTime() + ".png"));
	}

	public static String getCurrentDateTime() {
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customFormat.format(currentDate);
	}
	
	public static WebElement convertStringToWebElement(String val, String newVal) {
    	String replacedVal = val.replace("%s", newVal);
    	return driver.findElement(By.xpath(replacedVal));
    }

}
