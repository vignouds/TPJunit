package dev.console;

import dev.service.CalculException;
import dev.service.CalculService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

import static org.mockito.Mockito.*;

public class AppTest {
	
	private static final Logger LOG = LoggerFactory.getLogger("titreLogger");
	
	@Rule
	public final TextFromStandardInputStream systemInMock = TextFromStandardInputStream.emptyStandardInputStream();
	
	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	private App app;
	private CalculService calculService;
	
	@Before
	public void setUp() throws Exception {
		Scanner sc = new Scanner(System.in);
		this.calculService = mock(CalculService.class);
		this.app = new App(sc, calculService);
	}
	
	@Test
	public void testEvaluer() throws Exception {
		LOG.info("Etant donn�, un service CalculService qui retourne 35 � l'�valuation de l'expression 1+34");
		String expression = "1+34";
		when(calculService.additionner(expression)).thenReturn(35);
		
		LOG.info("Lorsque la m�thode evaluer est invoqu�e");
		this.app.evaluer(expression);
		
		LOG.info("Alors le service est invoqu� avec l'expression {}", expression);
		verify(calculService).additionner(expression);
		
		LOG.info("Alors dans la console, s'affiche 1+34=35"); 
		assertThat(systemOutRule.getLog().contains("1+3=35"));
	}
	
	@Test
	public void testEvaluerExpressionInvalide() throws Exception {
		String expression = "1+34";
		when(calculService.additionner(expression)).thenThrow(CalculException.class);
		
		this.app.evaluer(expression);
		verify(calculService).additionner(expression);
		
		assertThat(systemOutRule.getLog().contains("L'expression est invalide."));
	}
	
	@Test
	public void testAfficherTitre() throws Exception {
		this.app.afficherTitre();
		
		String logConsole = systemOutRule.getLog();
		
		assertThat(logConsole).contains("**** Application Calculatrice ****");
	}
	
	@Test
	public void testDemarrerAuRevoir() throws Exception {
		systemInMock.provideLines("fin");
		this.app.demarrer();
		String logConsole = systemOutRule.getLog();
		assertThat(logConsole).contains("Au revoir :-(");
	}
	
	@Test
	public void testDemarrer12Fin() throws Exception {
		systemInMock.provideLines("1+2", "fin");
		this.app.demarrer();
		String logConsole = systemOutRule.getLog();
		assertThat(logConsole).contains("**** Application Calculatrice ****\r\nVeuillez saisir une expression:\r\n1+2=3\r\nVeuillez saisir une expression:\r\nAu revoir :-(");
	}
}
