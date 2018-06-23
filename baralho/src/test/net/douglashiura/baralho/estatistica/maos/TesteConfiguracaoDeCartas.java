package test.net.douglashiura.baralho.estatistica.maos;

import static net.douglashiura.baralho.Naipe.COPAS;
import static net.douglashiura.baralho.Naipe.ESPADAS;
import static net.douglashiura.baralho.Naipe.OUROS;
import static net.douglashiura.baralho.Naipe.PAUS;

import org.junit.BeforeClass;

import net.douglashiura.baralho.Carta;

public class TesteConfiguracaoDeCartas {
	 protected static Carta asDeEspadas;
	 protected static Carta kDePaus;
	 protected static Carta seisDeCopas;
	 protected static Carta quatroDeCopas;
	 protected static Carta asDePaus;
	 protected static Carta asDeCopas;
	 protected static Carta asDeOuro;
	 protected static Carta kDeEspadas;
	 protected static Carta kDeCopas;
	 protected static Carta kDeOuro;
	 protected static Carta qDeEspadas;
	 protected static Carta qDePaus;
	 protected static Carta qDeCopas;
	 protected static Carta qDeOuro;
	 protected static Carta jDePaus;
	 protected static Carta jDeCopas;
	 protected static Carta dezDeEspadas;
	 protected static Carta dezDePaus;
	 protected static Carta dezDeCopas;
	 protected static Carta noveDeCopas;
	 protected static Carta noveDePaus;
	 protected static Carta noveDeOuro;
	 protected static Carta doisDeCopas;
	 protected static Carta doisDeOuro;
	 protected static Carta tresDeCopas;
	 protected static Carta cincoDePaus;
	 protected static Carta cincoDeCopas;
	 protected static Carta seteDeCopas;
	 protected static Carta oitoDePaus;

	@BeforeClass
	public static void configuracao() {
		asDeEspadas = ESPADAS.obter("A");
		asDePaus = PAUS.obter("A");
		asDeCopas = COPAS.obter("A");
		asDeOuro = OUROS.obter("A");

		kDeEspadas = ESPADAS.obter("K");
		kDePaus = PAUS.obter("K");
		kDeCopas = COPAS.obter("K");
		kDeOuro = OUROS.obter("K");

		qDeEspadas = ESPADAS.obter("Q");
		qDePaus = PAUS.obter("Q");
		qDeCopas = COPAS.obter("Q");
		qDeOuro = OUROS.obter("Q");

		jDePaus = PAUS.obter("J");
		jDeCopas = COPAS.obter("J");

		dezDeEspadas = ESPADAS.obter("10");
		dezDePaus = PAUS.obter("10");
		dezDeCopas = COPAS.obter("10");

		noveDeCopas = COPAS.obter("9");
		noveDeOuro = OUROS.obter("9");
		noveDePaus = PAUS.obter("9");
		
		oitoDePaus = PAUS.obter("8");
		kDePaus = PAUS.obter("K");
		seisDeCopas = COPAS.obter("6");
		quatroDeCopas = COPAS.obter("4");

		tresDeCopas = COPAS.obter("3");

		doisDeCopas = COPAS.obter("2");
		doisDeOuro = OUROS.obter("2");
		
		cincoDePaus = PAUS.obter("5");
		cincoDeCopas = COPAS.obter("5");
		seteDeCopas = COPAS.obter("7");
	}
}
