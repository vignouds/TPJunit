package dev.console;

import dev.service.CalculService;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
	
	private Scanner scanner;
	private CalculService calculatrice;
	private static final Logger LOG = LoggerFactory.getLogger("titreLogger");
	private int resultat;
	
	public App(Scanner scanner, CalculService calculatrice) {
		this.scanner=scanner;
		this.calculatrice = calculatrice;
	}
	
	protected void afficherTitre() {
		LOG.info("**** Application Calculatrice ****");
	}
	
	public void demarrer() {
		afficherTitre();
		
		if(scanner.nextLine().equals("fin")) {
			LOG.info("Au revoir :-(");
		}
	}
	
	protected void evaluer(String expression) {
		
		try {
			resultat = calculatrice.additionner(expression);
		} catch (Exception e) {
			LOG.info("L'expression {} est invalide", expression);
		}
		
		LOG.info("{}={}", expression, resultat);
	}
}
