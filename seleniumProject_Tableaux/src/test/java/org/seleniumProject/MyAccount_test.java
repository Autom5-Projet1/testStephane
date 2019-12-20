package org.seleniumProject;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MyAccount_test {

	WebDriver driver;

	// JDD
	String username = "j2ee";
	String pwd = "j2ee";
	String langue = "japanese";
	String category = "REPTILES";

	@After
	public void tearDown() {
		driver.quit();
	}

	@Before
	public void setup() {
		driver = OutilTechnique.choisirNavigateur(ENavigateur.firefox);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void myAccountTest() {

		// Accéder à l’application Jpetstore et se connecter en tant que j2ee/j2ee
		driver.get("http://localhost:8090/jpetstore-1.0.5-env2/");

		PageIndex page_index = PageFactory.initElements(driver, PageIndex.class);

		PageLogin page_login = page_index.clicSignIn(driver);
		page_login.saisiChampslogin(username, pwd);
		PageAccueil page_accueil = page_login.submitLogin(driver);

		PageMyAccount page_myaccount = page_accueil.clicMyAccount(driver);
		assertTrue("Problème de page", page_myaccount.titre2.isDisplayed());

		// Choisir la langue et la catégorie préférées
		String langue_fav = page_myaccount.selectLangue(langue);
		String category_fav = page_myaccount.selectCategory(category);

		// Contrôle
		assertEquals(langue, langue_fav);
		assertEquals(category, category_fav);

		// Vérifier les checkboxes
		assertTrue("MyList n'est pas coché", page_myaccount.checkbox_mylist.isSelected());
		assertTrue("MyBanner n'est pas coché", page_myaccount.checkbox_mybanner.isSelected());
		
		WebElement[] checkboxes = {page_myaccount.checkbox_mybanner, page_myaccount.checkbox_mylist};
		page_myaccount.clickCheckbox(checkboxes);
		assertFalse("MyList est coché", page_myaccount.checkbox_mylist.isSelected());
		assertFalse("MyBanner est coché", page_myaccount.checkbox_mybanner.isSelected());

	}
}
