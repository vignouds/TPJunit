package dev.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CalculService {
	private static final Logger LOG = LoggerFactory.getLogger(AppService.class);
	
	public int additionner(String expression) throws CalculException {
		LOG.debug("Evaluation de l'expression ", expression);
		String [] calcul = expression.split("[+]");
		int somme = 0;
		for (int i=0;i<calcul.length;i++) {
			try {
				somme+=Integer.parseInt(calcul[i]);
			} catch (Exception e) {
				throw new CalculException();
			}
		}			
		return somme;
	}

}
