package test.net.douglashiura.baralho.estatistica.maos;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import net.douglashiura.baralho.Carta;
import net.douglashiura.baralho.poker.Classificacao;
import net.douglashiura.baralho.poker.Maos;

public class TesteClassificacao extends TesteConfiguracaoDeCartas {

	@Test
	public void royalFlush() throws Exception {
		Classificacao resultado = Maos.classificar(asList(asDeCopas, kDeCopas, qDeCopas, jDeCopas, dezDeCopas));
		List<Carta> cartas = resultado.getCartas();
		assertEquals(asDeCopas, cartas.get(0));
		assertEquals(kDeCopas, cartas.get(1));
		assertEquals(qDeCopas, cartas.get(2));
		assertEquals(jDeCopas, cartas.get(3));
		assertEquals(dezDeCopas, cartas.get(4));
		assertEquals(5, cartas.size());
		assertEquals(Maos.ROYAL_FLUSH, resultado.getMao());
	}

	@Test
	public void straightFlush() throws Exception {
		Classificacao resultado = Maos.classificar(asList(kDeCopas, qDeCopas, jDeCopas, dezDeCopas, noveDeCopas));
		assertEquals(Maos.STRAIGHT_FLUSH, resultado.getMao());
	}

	@Test
	public void quadra() throws Exception {
		Classificacao resultado = Maos.classificar(asList(kDeCopas, kDeEspadas, kDeOuro, kDePaus, noveDeCopas));
		assertEquals(Maos.QUADRA, resultado.getMao());
	}

	@Test
	public void fullHouse() throws Exception {
		Classificacao resultado = Maos.classificar(asList(kDeCopas, kDeEspadas, kDeOuro, qDePaus, qDeOuro));
		assertEquals(Maos.FULL_HOUSE, resultado.getMao());
	}

	@Test
	public void flush() throws Exception {
		Classificacao resultado = Maos.classificar(asList(kDeCopas, qDeCopas, jDeCopas, dezDeCopas, doisDeCopas));
		assertEquals(Maos.FLUSH, resultado.getMao());
	}

	@Test
	public void sequencia() throws Exception {
		Classificacao resultado = Maos.classificar(asList(kDeCopas, qDeCopas, jDeCopas, dezDeCopas, noveDeOuro));
		assertEquals(Maos.SEQUENCIA, resultado.getMao());
	}

	@Test
	public void trinca() throws Exception {
		Classificacao resultado = Maos.classificar(asList(kDeCopas, kDeEspadas, kDeOuro, qDeCopas, dezDeEspadas));
		assertEquals(Maos.TRINCA, resultado.getMao());
	}

	@Test
	public void doisPares() throws Exception {
		Classificacao resultado = Maos.classificar(asList(kDeCopas, kDeEspadas, qDeOuro, qDeCopas, dezDeEspadas));
		assertEquals(Maos.DOIS_PARES, resultado.getMao());
	}

	@Test
	public void par() throws Exception {
		Classificacao resultado = Maos.classificar(asList(asDeCopas, kDeEspadas, qDeOuro, qDeCopas, dezDeEspadas));
		assertEquals(Maos.UM_PAR, resultado.getMao());
	}

	@Test
	public void cartaAlta() throws Exception {
		Classificacao resultado = Maos.classificar(asList(asDeCopas, kDeEspadas, qDeOuro, jDeCopas, noveDeOuro));
		assertEquals(Maos.CARTA_ALTA, resultado.getMao());
	}
}
