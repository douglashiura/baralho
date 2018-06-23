package test.net.douglashiura.baralho.estatistica.maos;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

import net.douglashiura.baralho.Carta;
import net.douglashiura.baralho.poker.Maos;

public class TesteStrainghtFlush extends TesteConfiguracaoDeCartas {

	@Test
	public void royalFlush() throws Exception {
		List<Carta> mao = Maos.STRAIGHT_FLUSH.mao(asList(asDeCopas, kDeCopas, qDeCopas, jDeCopas, dezDeCopas));
		assertEquals(asDeCopas, mao.get(0));
		assertEquals(kDeCopas, mao.get(1));
		assertEquals(qDeCopas, mao.get(2));
		assertEquals(jDeCopas, mao.get(3));
		assertEquals(dezDeCopas, mao.get(4));
		assertEquals(5, mao.size());
	}

	@Test
	public void umaCarta() throws Exception {
		List<Carta> mao = Maos.STRAIGHT_FLUSH.mao(asList(asDePaus));
		assertEquals(0, mao.size());
	}

	@Test
	public void vazio() throws Exception {

		List<Carta> mao = Maos.STRAIGHT_FLUSH.mao(Collections.emptyList());
		assertEquals(0, mao.size());
	}

	@Test
	public void nipeDePaus() throws Exception {

		List<Carta> mao = Maos.STRAIGHT_FLUSH.mao(asList(asDePaus, kDePaus, qDePaus, jDePaus, dezDePaus));
		assertEquals(asDePaus, mao.get(0));
		assertEquals(kDePaus, mao.get(1));
		assertEquals(qDePaus, mao.get(2));
		assertEquals(jDePaus, mao.get(3));
		assertEquals(dezDePaus, mao.get(4));
		assertEquals(5, mao.size());
	}

	@Test
	public void copasComecandEmOuros() throws Exception {

		List<Carta> mao = Maos.STRAIGHT_FLUSH
				.mao(asList(asDeOuro, asDeCopas, asDePaus, kDeCopas, qDeCopas, jDeCopas, dezDeCopas));
		assertEquals(asDeCopas, mao.get(0));
		assertEquals(kDeCopas, mao.get(1));
		assertEquals(qDeCopas, mao.get(2));
		assertEquals(jDeCopas, mao.get(3));
		assertEquals(dezDeCopas, mao.get(4));
		assertEquals(5, mao.size());
	}

	@Test
	public void comTrincaDeAsses() throws Exception {

		List<Carta> mao = Maos.STRAIGHT_FLUSH
				.mao(asList(asDeOuro, asDeCopas, asDePaus, kDeCopas, qDeCopas, jDeCopas, dezDeCopas));
		assertEquals(asDeCopas, mao.get(0));
		assertEquals(kDeCopas, mao.get(1));
		assertEquals(qDeCopas, mao.get(2));
		assertEquals(jDeCopas, mao.get(3));
		assertEquals(dezDeCopas, mao.get(4));
		assertEquals(5, mao.size());
	}

	@Test
	public void passaAteUmaMenor() throws Exception {

		List<Carta> mao = Maos.STRAIGHT_FLUSH
				.mao(asList(asDeOuro, asDeCopas, kDeCopas, qDeCopas, jDeCopas, dezDeCopas, noveDeCopas));
		assertEquals(asDeCopas, mao.get(0));
		assertEquals(kDeCopas, mao.get(1));
		assertEquals(qDeCopas, mao.get(2));
		assertEquals(jDeCopas, mao.get(3));
		assertEquals(dezDeCopas, mao.get(4));
		assertEquals(5, mao.size());
	}

	@Test
	public void duplaEMenorSequencia() throws Exception {

		List<Carta> mao = Maos.STRAIGHT_FLUSH
				.mao(asList(asDeOuro, asDeCopas, kDeCopas, qDeCopas, jDeCopas, dezDeCopas, noveDeCopas));
		assertEquals(asDeCopas, mao.get(0));
		assertEquals(kDeCopas, mao.get(1));
		assertEquals(qDeCopas, mao.get(2));
		assertEquals(jDeCopas, mao.get(3));
		assertEquals(dezDeCopas, mao.get(4));
		assertEquals(5, mao.size());
	}

	@Test
	public void comQuatroCartasDeCinco() throws Exception {

		List<Carta> mao = Maos.STRAIGHT_FLUSH.mao(asList(asDePaus, kDeCopas, qDeCopas, jDeCopas, dezDeCopas));
		assertEquals(0, mao.size());
	}

	@Test
	public void faltaODez() throws Exception {

		List<Carta> mao = Maos.STRAIGHT_FLUSH.mao(asList(asDeCopas, kDeCopas, qDeCopas, jDeCopas, noveDeCopas));
		assertEquals(0, mao.size());
	}

	@Test
	public void faltaODezComUmDex() throws Exception {

		List<Carta> mao = Maos.STRAIGHT_FLUSH.mao(asList(asDeCopas, kDeCopas, qDeCopas, jDeCopas, dezDeEspadas));
		assertEquals(0, mao.size());
	}

	@Test
	public void temUmNove() throws Exception {
		List<Carta> mao = Maos.STRAIGHT_FLUSH.mao(asList(kDeCopas, qDeCopas, jDeCopas, dezDeCopas, noveDeCopas));
		assertEquals(kDeCopas, mao.get(0));
		assertEquals(qDeCopas, mao.get(1));
		assertEquals(jDeCopas, mao.get(2));
		assertEquals(dezDeCopas, mao.get(3));
		assertEquals(noveDeCopas, mao.get(4));
		assertEquals(5, mao.size());
	}

	@Test
	public void temUmaSubSequencia() throws Exception {
		List<Carta> mao = Maos.STRAIGHT_FLUSH.mao(asList(asDeCopas, jDeCopas, seteDeCopas, seisDeCopas, cincoDePaus,
				cincoDeCopas, quatroDeCopas, tresDeCopas, doisDeCopas));
		assertEquals(seteDeCopas, mao.get(0));
		assertEquals(seisDeCopas, mao.get(1));
		assertEquals(cincoDeCopas, mao.get(2));
		assertEquals(quatroDeCopas, mao.get(3));
		assertEquals(tresDeCopas, mao.get(4));
		assertEquals(5, mao.size());
	}
}
