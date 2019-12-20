package org.seleniumProject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PageMyAccount {
	@FindBy (xpath="//h3[.='Account Information']")
	WebElement titre2;
	
	@FindBy (name ="account.languagePreference")
	WebElement menu_langue;
	
	@FindBy (name ="account.favouriteCategoryId")
	WebElement menu_category;
	
	@FindBy(name="account.listOption")
	WebElement checkbox_mylist;
	
	@FindBy(name="account.bannerOption")
	WebElement checkbox_mybanner;

	
	public String selectLangue (String langue) {
		return OutilTechnique.selectMenu(langue, menu_langue)
				.getFirstSelectedOption()
				.getText();
		
	}
	
	public String selectCategory (String category) {
		return OutilTechnique.selectMenu(category, menu_category)
				.getFirstSelectedOption()
				.getText()
				.toUpperCase();
	}
	
	public void clickCheckbox(WebElement[] checkbox) { //public void clickCheckbox(WebElement... checkbox)
		for(int i=0; i< checkbox.length; i++) {
			checkbox[i].click();
		}
	}
	
	
}
