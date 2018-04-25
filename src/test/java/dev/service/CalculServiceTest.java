package dev.service;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Test unitaire de la classe dev.service.CalculService
 * @author Sébastien Vignoud
 */
public class CalculServiceTest {
	private static final Logger LOG = LoggerFactory.getLogger(CalculServiceTest.class);
	
	@Test
	public void testAdditionner() throws Exception {
		LOG.info("Etant donné, une instance de la classe CalculService");
		CalculService cs = new CalculService();

		LOG.info("Lorsque j'évalue l'addition de l'expression 1+3+4"); 
		int somme = 0;
		somme = cs.additionner("1+3+4");

		LOG.info("Alors j'obtiens le résultat 8");
		assertEquals(8, somme);
	}	
	
	@Test (expected = CalculException.class)
	public void testCalculException() throws Exception {
		CalculService cs = new CalculService();
		int somme = 0;
		somme = cs.additionner("a+3+4");
	}
}
