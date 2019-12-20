package org.seleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageLogin extends PageAbstractBandeau{

	
	@FindBy (name="username")
	WebElement champ_login ;

	@FindBy (name="password")
	WebElement champ_pwd ;
	
	@FindBy (name="update")
	WebElement btn_submit;
	
	public void saisiChampslogin(String username, String pwd) {
		OutilTechnique.remplirChamp(champ_login, username);
		OutilTechnique.remplirChamp(champ_pwd, pwd);
	}
	
	public PageAccueil submitLogin(WebDriver driver) {
		btn_submit.click();
		return PageFactory.initElements(driver, PageAccueil.class);
	}
}
