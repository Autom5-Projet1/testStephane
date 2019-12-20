package org.seleniumProject;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Test1Jpetstore {

	WebDriver driver;
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	
	@Test
	public void test() {
		driver = OutilTechnique.choisirNavigateur(ENavigateur.firefox);

		
		//Accéder à l’application Jpetstore et se connecter en tant que j2ee/j2ee

		driver.get("http://localhost:8090/jpetstore-1.0.5-env2/");
		driver.findElement(By.name("img_signin")).click();
		WebElement champ_login = driver.findElement(By.name("username"));
		OutilTechnique.remplirChamp(champ_login, "j2ee");
		WebElement champ_pwd = driver.findElement(By.name("password"));
		OutilTechnique.remplirChamp(champ_pwd, "j2ee");
		driver.findElement(By.name("update")).click();
		
		//L’utilisateur « ABC » est bien connecté (apparition d’un message de bienvenu et du lien « Sign out »)
		assertTrue(driver.findElement(By.name("img_signout")).isEnabled());
		assertEquals("Welcome ABC!",driver.findElement(By.xpath("//font")).getText());

		
		//Sélectionner la  catégorie Fish
	
		driver.findElement(By.xpath("//img[contains(@src,'fish.gif')]")).click();

		
		//Affichage de la liste des produit disponible pour la catégorie Fish
		assertEquals("Fish",driver.findElement(By.xpath("//h2")).getText());
		
		
		//Sélectionner le produit de votre choix
		driver.findElement(By.xpath("//font[.='FI-SW-02']")).click();
		
		//Ajouter un item au panier (« add to cart »)
		driver.findElement(By.xpath("//img[contains(@src,'add_to_cart.gif')]")).click();
		
		
		//Affichage du panier
		assertEquals("Shopping Cart", driver.findElement(By.xpath("//h2")).getText());
		
		//Passer la quantité commandée à 2 et cliquer sur « update cart »
		WebElement champ_quantity = driver.findElement(By.name("EST-3"));
		OutilTechnique.remplirChamp(champ_quantity, "2");
		driver.findElement(By.name("update")).click();
		
		//Le prix total est égal au double du prix à l’unité
		String PU = driver.findElement(By.xpath("//tr[2]/td[6]")).getText();
		String PT = driver.findElement(By.xpath("//tr[2]/td[7]")).getText();
		PU = PU.substring(1);
		PU = PU.replace(",", ".");
		PT = PT.substring(1);
		PT = PT.replace(",", ".");
		System.out.println(PU+" "+PT);
		double PUtoDouble = Double.parseDouble(PU);
		double PTtoDouble = Double.parseDouble(PT);
		System.out.println(PUtoDouble + " " + PTtoDouble);
		assertEquals("Le prix total n'est pas conforme",PUtoDouble * 2, PTtoDouble, 0);
		System.out.println("Le prix total est bien égal à 2 fois le prix unitaire");
		




	}

	
}
