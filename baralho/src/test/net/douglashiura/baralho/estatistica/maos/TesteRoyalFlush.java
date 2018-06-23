package test.net.douglashiura.baralho.estatistica.maos;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import net.douglashiura.baralho.Carta;
import net.douglashiura.baralho.poker.Maos;

public class TesteRoyalFlush extends TesteConfiguracaoDeCartas {

	@Test
	public void completoComMaisCartas() throws Exception {
		List<Carta> mao = Maos.ROYAL_FLUSH.mao(asList(asDeCopas, kDeCopas, qDeCopas, jDeCopas, dezDeCopas));
		assertEquals(asDeCopas, mao.get(0));
		assertEquals(kDeCopas, mao.get(1));
		assertEquals(qDeCopas, mao.get(2));
		assertEquals(jDeCopas, mao.get(3));
		assertEquals(dezDeCopas, mao.get(4));
		assertEquals(5, mao.size());
	}

	@Test
	public void apenasAsCartas() throws Exception {
		List<Carta> mao = Maos.ROYAL_FLUSH.mao(asList(asDePaus, kDePaus, qDePaus, jDePaus, dezDePaus));
		assertEquals(asDePaus, mao.get(0));
		assertEquals(kDePaus, mao.get(1));
		assertEquals(qDePaus, mao.get(2));
		assertEquals(jDePaus, mao.get(3));
		assertEquals(dezDePaus, mao.get(4));
		assertEquals(5, mao.size());
	}

	@Test
	public void comVariacoesDeTrincas() throws Exception {
		List<Carta> mao = Maos.ROYAL_FLUSH
				.mao(asList(asDeOuro, asDeCopas, asDePaus, kDeCopas, qDeCopas, jDeCopas, dezDeCopas));
		assertEquals(asDeCopas, mao.get(0));
		assertEquals(kDeCopas, mao.get(1));
		assertEquals(qDeCopas, mao.get(2));
		assertEquals(jDeCopas, mao.get(3));
		assertEquals(dezDeCopas, mao.get(4));
		assertEquals(5, mao.size());
	}

	@Test
	public void comTrincas() throws Exception {

		List<Carta> mao = Maos.ROYAL_FLUSH
				.mao(asList(asDeOuro, asDeCopas, asDePaus, kDeCopas, qDeCopas, jDeCopas, dezDeCopas));
		assertEquals(asDeCopas, mao.get(0));
		assertEquals(kDeCopas, mao.get(1));
		assertEquals(qDeCopas, mao.get(2));
		assertEquals(jDeCopas, mao.get(3));
		assertEquals(dezDeCopas, mao.get(4));
		assertEquals(5, mao.size());
	}

	@Test
	public void continuandoOFlush() throws Exception {
		List<Carta> mao = Maos.ROYAL_FLUSH
				.mao(asList(asDeOuro, asDeCopas, kDeCopas, qDeCopas, jDeCopas, dezDeCopas, noveDeCopas));
		assertEquals(asDeCopas, mao.get(0));
		assertEquals(kDeCopas, mao.get(1));
		assertEquals(qDeCopas, mao.get(2));
		assertEquals(jDeCopas, mao.get(3));
		assertEquals(dezDeCopas, mao.get(4));
		assertEquals(5, mao.size());
	}

	@Test
	public void comecandoEmOutroNipe() throws Exception {
		List<Carta> mao = Maos.ROYAL_FLUSH.mao(asList(asDeOuro, asDeCopas, kDeCopas, qDeCopas, jDeCopas, dezDeCopas, noveDeCopas));
		assertEquals(asDeCopas, mao.get(0));
		assertEquals(kDeCopas, mao.get(1));
		assertEquals(qDeCopas, mao.get(2));
		assertEquals(jDeCopas, mao.get(3));
		assertEquals(dezDeCopas, mao.get(4));
		assertEquals(5, mao.size());
	}

	@Test
	public void faltandoOAsDoNipe() throws Exception {
		List<Carta> mao = Maos.ROYAL_FLUSH.mao(asList(asDePaus, kDeCopas, qDeCopas, jDeCopas, dezDeCopas));
		assertEquals(0, mao.size());
	}

	@Test
	public void faltandoODez() throws Exception {
		List<Carta> mao = Maos.ROYAL_FLUSH.mao(asList(asDeCopas, kDeCopas, qDeCopas, jDeCopas, noveDeCopas));
		assertEquals(0, mao.size());
	}

	@Test
	public void faltandoApenasODez() throws Exception {
		List<Carta> mao = Maos.ROYAL_FLUSH.mao(asList(asDeCopas, kDeCopas, qDeCopas, jDeCopas));
		assertEquals(0, mao.size());
	}

}
