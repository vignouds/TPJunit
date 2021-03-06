package dev.service;

import static org.junit.Assert.assertEquals;
import static org.assertj.core.api.Assertions.*;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Test unitaire de la classe dev.service.CalculService
 * @author S�bastien Vignoud
 */
public class CalculServiceTest {
	private static final Logger LOG = LoggerFactory.getLogger(CalculServiceTest.class);
	
	@Test
	public void testAdditionner() throws Exception {
		LOG.info("Etant donn�, une instance de la classe CalculService");
		CalculService cs = new CalculService();

		LOG.info("Lorsque j'�value l'addition de l'expression 1+3+4"); 
		int somme = 0;
		somme = cs.additionner("1+3+4");

		LOG.info("Alors j'obtiens le r�sultat 8");
		assertThat(somme).isEqualTo(8);
	}	
	
	@Test (expected = CalculException.class)
	public void testCalculException() throws Exception {
		CalculService cs = new CalculService();
		int somme = 0;
		somme = cs.additionner("a+3+4");
	}
}
