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

public class Test_Search {

	WebDriver driver;

	// JDD
	String username = "j2ee";
	String pwd = "j2ee";
	String nom_animal = "dog";
	String recherche_chien = "Dalmation";


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
		
		PageRecherche page_recherche = page_accueil.rechercher(driver,nom_animal);
		
//		INT LIGNE = PAGE_RECHERCHE.RETOURNERNUMERODELIGNE(RECHERCHE_CHIEN);
//		SYSTEM.OUT.PRINTLN(LIGNE);
//	
//		PAGEPRODUIT PAGE_PRODUIT = PAGE_RECHERCHE.CLICKLIEN(DRIVER, LIGNE);

	}
}
