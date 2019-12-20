package org.seleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageAccueil extends PageAbstractBandeau {
	
	@FindBy (xpath = "//font")
	WebElement msg_bienvenue;

/*	@FindBy (xpath="//img[contains(@src, 'fish.gif')]")
	static WebElement lien_fish;
	
	@FindBy (xpath="//img[contains(@src, 'dogs.gif')]")
	static WebElement lien_dog;
	*/
	
	public PageCategory selectCat(WebDriver driver, String lien) {
		driver.findElement(By.xpath("//img[contains(@src, '"+lien+"')]")).click();
		return PageFactory.initElements(driver, PageCategory.class);
	}
}
