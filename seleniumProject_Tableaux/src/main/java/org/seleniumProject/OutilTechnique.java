package org.seleniumProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class OutilTechnique {
	
static WebDriver driver ;


	
	static WebDriver choisirNavigateur(ENavigateur nav) {
		switch(nav) {
		case firefox:
			System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe") ;
			driver = new FirefoxDriver() ;
			return driver;
		case chrome:
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
			driver = new ChromeDriver();
			return driver;
		case ie:
			System.setProperty("webdriver.ie.driver", "src/test/resources/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			return driver;
		default: return null;
			
		}
		
	}
	public static void remplirChamp(WebElement e, String s) {
		e.clear();
		e.sendKeys(s);
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		OutilTechnique.driver = driver;
	}

	public static Select selectMenu(String option, WebElement menu) {
		Select select= new Select(menu);
		select.selectByValue(option);
		return select;
	}
}
