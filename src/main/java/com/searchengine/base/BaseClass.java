package com.searchengine.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.searchengine.utility.TestUtil;
import com.searchengine.utility.WebEventListener;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

    public BaseClass() {

        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\Config\\config.properties");
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void initialize() {
        String browserName = prop.getProperty("browser");

        if(browserName.equalsIgnoreCase("chrome")) {
        	//WebDriverManager.chromedriver().setup();
        	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + prop.getProperty("chromeDriverPath"));
            driver = new ChromeDriver();
        } else if(browserName.equalsIgnoreCase("firefox")) {
            //WebDriverManager.firefoxdriver().setup();
        	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + prop.getProperty("geckoDriverPath"));
            driver = new FirefoxDriver();
        } else {
            System.out.println("browser : " + browserName + " is invalid, Launching Chrome as browser of choice..");
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + prop.getProperty("chromeDriverPath"));
            driver = new ChromeDriver();
        }
        
        e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY_WAIT_TIMEOUT, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));
    }
    
    public static void quitBrowser() {
    	driver.quit();
	}
    
}
