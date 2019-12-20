package org.seleniumProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageProduit extends PageAbstractBandeau {
	
	@FindBy (xpath ="//img[contains(@src, \"add_to_cart.gif\")]")
	WebElement ajoutPanier;
	
	public PagePanier ajouterPanier(WebDriver driver) {
		ajoutPanier.click();
		return PageFactory.initElements(driver, PagePanier.class);
	}
}
