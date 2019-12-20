package org.seleniumProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageRecherche extends PageAbstractBandeau {

	@FindBy(xpath = "//table[3]")
	WebElement tableau_Recherche;

	public int [] retournerNumeroDeLigne(String s) {
		int [] tab_cellure = {1,1};
		List<WebElement> liste_lignes = tableau_Recherche.findElements(By.xpath("tbody/tr"));
		for (WebElement ligne : liste_lignes) {
			List<WebElement> liste_colonnes = ligne.findElements(By.xpath("td"));
			for (WebElement colonne : liste_colonnes) {
				if (colonne.getText().equals(s)) {
					return tab_cellure;
				}
				tab_cellure[1]++;
			}
			tab_cellure[0]++;
		}
		tab_cellure[0] = -1;
		tab_cellure[1] = -1;
		return tab_cellure;
	}

	public WebElement getCellule(int row, int col) {
		WebElement element = tableau_Recherche.findElement(By.xpath("tbody/tr[" + row + "]/td[" + col + "]//a"));
		return element;
	}

	public PageProduit clicklien(WebDriver driver, int row) {
		getCellule(row, 2);
		return PageFactory.initElements(driver, PageProduit.class);

	}

	public PageProduit clicklienByCellule(WebDriver driver, WebElement cell) {
		cell.click();
		return PageFactory.initElements(driver, PageProduit.class);
	}
}
