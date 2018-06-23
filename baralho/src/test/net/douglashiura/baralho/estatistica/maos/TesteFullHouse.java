package test.net.douglashiura.baralho.estatistica.maos;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

import net.douglashiura.baralho.Carta;
import net.douglashiura.baralho.poker.Maos;

public class TesteFullHouse extends TesteConfiguracaoDeCartas {

	@Test
	public void fullHouse() throws Exception {
		List<Carta> mao = Maos.FULL_HOUSE.mao(asList(asDeCopas, asDeEspadas, asDeOuro, kDeCopas, kDePaus));
		assertEquals(asDeEspadas, mao.get(0));
		assertEquals(asDeCopas, mao.get(1));
		assertEquals(asDeOuro, mao.get(2));
		assertEquals(kDePaus, mao.get(3));
		assertEquals(kDeCopas, mao.get(4));
		assertEquals(5, mao.size());
	}

	@Test
	public void fullHouseTriplakEduplaAs() throws Exception {
		List<Carta> mao = Maos.FULL_HOUSE.mao(asList(asDeCopas, asDeOuro, kDeEspadas, kDeCopas, kDePaus, doisDeCopas));
		assertEquals(kDePaus, mao.get(0));
		assertEquals(kDeEspadas, mao.get(1));
		assertEquals(kDeCopas, mao.get(2));
		assertEquals(asDeCopas, mao.get(3));
		assertEquals(asDeOuro, mao.get(4));
		assertEquals(5, mao.size());
	}

	@Test
	public void fullHouseComTriplaDeQeDuplaDeAs() throws Exception {
		List<Carta> mao = Maos.FULL_HOUSE
				.mao(asList(asDeCopas, asDeOuro, kDeCopas, qDeEspadas, qDeCopas, qDePaus, doisDeCopas));
		assertEquals(qDePaus, mao.get(0));
		assertEquals(qDeEspadas, mao.get(1));
		assertEquals(qDeCopas, mao.get(2));
		assertEquals(asDeCopas, mao.get(3));
		assertEquals(asDeOuro, mao.get(4));
		assertEquals(5, mao.size());
	}

	@Test
	public void dezEK() throws Exception {
		List<Carta> mao = Maos.FULL_HOUSE
				.mao(asList(asDeCopas, kDeCopas, kDeOuro, dezDeCopas, dezDePaus, dezDeEspadas, doisDeCopas));
		assertEquals(dezDePaus, mao.get(0));
		assertEquals(dezDeEspadas, mao.get(1));
		assertEquals(dezDeCopas, mao.get(2));
		assertEquals(kDeCopas, mao.get(3));
		assertEquals(kDeOuro, mao.get(4));
		assertEquals(5, mao.size());
	}

	@Test
	public void duasDuplas() throws Exception {
		List<Carta> mao = Maos.FULL_HOUSE.mao(asList(asDeCopas, asDeEspadas, asDeOuro, kDeCopas, qDeCopas));
		assertEquals(0, mao.size());
	}

	@Test
	public void tripaApenas() throws Exception {
		List<Carta> mao = Maos.FULL_HOUSE.mao(asList(kDeEspadas, kDeOuro, kDePaus));
		assertEquals(0, mao.size());
	}

	@Test
	public void duplaApenas() throws Exception {
		List<Carta> mao = Maos.FULL_HOUSE.mao(asList(kDeEspadas, kDeOuro, kDePaus, doisDeCopas));
		assertEquals(0, mao.size());
	}

	@Test
	public void umaCarta() throws Exception {
		List<Carta> mao = Maos.FULL_HOUSE.mao(asList(kDePaus));
		assertEquals(0, mao.size());
	}

	@Test
	public void vazio() throws Exception {
		List<Carta> mao = Maos.FULL_HOUSE.mao(Collections.emptyList());
		assertEquals(0, mao.size());
	}
}
