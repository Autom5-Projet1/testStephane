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

public class PageObject_Test {

	WebDriver driver;
	
	// JDD
	String login="j2ee";
	String pwd="j2ee";
	String idProduit ="FI-SW-02";
	String categorie ="Fish";
	String categorie_min=categorie.toLowerCase();
	String quantity="2";
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	@Before
	public void setup() {
		driver = OutilTechnique.choisirNavigateur(ENavigateur.firefox);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() {


		
		//Accéder à l’application Jpetstore et se connecter en tant que j2ee/j2ee
		driver.get("http://localhost:8090/jpetstore-1.0.5-env2/");
		
		PageIndex page_index = PageFactory.initElements(driver, PageIndex.class);
		
		PageLogin page_login = page_index.clicSignIn(driver);
		
		page_login.saisiChampslogin(login, pwd);
		PageAccueil page_accueil= page_login.submitLogin(driver);
		assertTrue(page_accueil.btn_signout.isEnabled());
		assertEquals("Welcome ABC!", page_accueil.msg_bienvenue.getText());
		
		

		
		//Sélectionner la  catégorie Fish
	
		PageCategory page_category= page_accueil.selectCat(driver, categorie_min);
		assertEquals(categorie,page_category.titreCat.getText());

		//Sélectionner le produit de votre choix
		PageProduit page_produit = page_category.selectionProduit(driver, idProduit);
		
		
		//Ajouter un item au panier (« add to cart »)
		PagePanier page_panier= page_produit.ajouterPanier(driver);
		
		
		//Affichage du panier
		assertEquals("Shopping Cart", page_panier.titre.getText());
		
		
		
		
		//Passer la quantité commandée à 2 et cliquer sur « update cart »
	
		page_panier.changementQuantite(quantity);
			
		//Le prix total est égal au double du prix à l’unité
		double PU = Double.parseDouble(page_panier.prix_unit.getText().substring(1).replace(",", "."));
		double PT = Double.parseDouble(page_panier.prix_total.getText().substring(1).replace(",", "."));
		System.out.println(PU + " " + PT);
		assertEquals("Le prix total n'est pas conforme",PU*Integer.parseInt(quantity), PT, 0);
		System.out.println("Le prix total est bien égal à 2 fois le prix unitaire");
		




	}

	
}
