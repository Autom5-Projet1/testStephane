package org.seleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageCategory extends PageAbstractBandeau{
	
	@FindBy (xpath="//h2")
	WebElement titreCat;
	
	public PageProduit selectionProduit(WebDriver driver, String idProduit) {
		driver.findElement(By.xpath("//font[.='"+idProduit+"']")).click();
		return PageFactory.initElements(driver, PageProduit.class);
	}

}
