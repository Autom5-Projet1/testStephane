package org.seleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PagePanier extends PageAbstractBandeau{

	@FindBy (xpath="//h2")
	WebElement titre ;
	
	@FindBy (xpath="//input[contains(@name,'EST-')]")
	WebElement champ_quantity;
	
	@FindBy (name="update")
	WebElement btn_update;
	
	@FindBy (xpath="//tr[2]/td[6]")
	WebElement prix_unit;
	
	@FindBy (xpath="//tr[2]/td[7]")
	WebElement prix_total;

	public void changementQuantite(String q) {
		OutilTechnique.remplirChamp(champ_quantity, q);
		btn_update.click();
	}
	
	
	
	
}
