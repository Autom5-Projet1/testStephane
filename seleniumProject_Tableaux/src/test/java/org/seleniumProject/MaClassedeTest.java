package org.seleniumProject;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class MaClassedeTest 
{
	WebDriver driver;
	
	@Test
	public void premierTest()
	{ 
	driver = OutilTechnique.choisirNavigateur(ENavigateur.chrome);
	driver.get("https://lemonde.fr") ;
	String title = driver.getTitle() ;
	System.out.println(title);
	assertEquals("Le Monde.fr - Actualités et Infos en France et dans le monde", title) ;
	
	
	}
	


	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
