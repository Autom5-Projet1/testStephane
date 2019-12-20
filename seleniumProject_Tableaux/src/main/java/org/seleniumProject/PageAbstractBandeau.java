package org.seleniumProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class PageAbstractBandeau {

	@FindBy (xpath = "//img[@name='img_signin']")
	private WebElement btn_signin;
	
	@FindBy (xpath = "//img[@name='img_signout']")
	WebElement btn_signout;
	
	@FindBy (name="img_myaccount")
	WebElement btn_myaccount;
	
	@FindBy (xpath="//input[contains(@src,'search.gif')]")
	WebElement btn_chercher;
	
	@FindBy (name="keyword")
	WebElement champ_recherche;
	
	public PageLogin clicSignIn(WebDriver driver) {
		btn_signin.click();
		return PageFactory.initElements(driver, PageLogin.class) ;
	}
	
	public PageMyAccount clicMyAccount(WebDriver driver) {
		btn_myaccount.click();
		return PageFactory.initElements(driver, PageMyAccount.class) ;
	}
	
	public PageRecherche rechercher(WebDriver driver, String nom_animal) {
		OutilTechnique.remplirChamp(champ_recherche,nom_animal);
		btn_chercher.click();
		return PageFactory.initElements(driver, PageRecherche.class) ;
		
		
	}
	
}
