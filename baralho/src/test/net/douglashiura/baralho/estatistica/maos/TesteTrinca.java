package test.net.douglashiura.baralho.estatistica.maos;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

import net.douglashiura.baralho.Carta;
import net.douglashiura.baralho.poker.Maos;

public class TesteTrinca extends TesteConfiguracaoDeCartas {
	@Test
	public void asseskk() throws Exception {
		List<Carta> mao = Maos.TRINCA.mao(asList(asDeCopas, asDeEspadas, asDeOuro, kDeCopas, kDePaus));
		assertEquals(asDeEspadas, mao.get(0));
		assertEquals(asDeCopas, mao.get(1));
		assertEquals(asDeOuro, mao.get(2));
		assertEquals(kDeCopas, mao.get(3));
		assertEquals(kDePaus, mao.get(4));
		assertEquals(5, mao.size());
	}

	@Test
	public void assesUmk() throws Exception {
		List<Carta> mao = Maos.TRINCA.mao(asList(asDeCopas, asDeEspadas, asDeOuro, kDePaus));
		assertEquals(asDeEspadas, mao.get(0));
		assertEquals(asDeCopas, mao.get(1));
		assertEquals(asDeOuro, mao.get(2));
		assertEquals(kDePaus, mao.get(3));
		assertEquals(4, mao.size());
	}

	@Test
	public void asses() throws Exception {
		List<Carta> mao = Maos.TRINCA.mao(asList(asDeCopas, asDeEspadas, asDeOuro));
		assertEquals(asDeEspadas, mao.get(0));
		assertEquals(asDeCopas, mao.get(1));
		assertEquals(asDeOuro, mao.get(2));
		assertEquals(3, mao.size());
	}

	@Test
	public void asseskkk() throws Exception {
		List<Carta> mao = Maos.TRINCA
				.mao(asList(asDeCopas, asDeEspadas, asDeOuro, kDeCopas, kDeEspadas, kDeOuro, doisDeCopas));
		assertEquals(asDeEspadas, mao.get(0));
		assertEquals(asDeCopas, mao.get(1));
		assertEquals(asDeOuro, mao.get(2));
		assertEquals(kDeCopas, mao.get(3));
		assertEquals(kDeEspadas, mao.get(4));
		assertEquals(5, mao.size());
	}

	@Test
	public void kkkaa() throws Exception {
		List<Carta> mao = Maos.TRINCA
				.mao(asList(asDeCopas, asDeEspadas, kDeCopas, kDeEspadas, kDeOuro, doisDeCopas));
		assertEquals(kDeEspadas, mao.get(0));
		assertEquals(kDeCopas, mao.get(1));
		assertEquals(kDeOuro, mao.get(2));
		assertEquals(asDeCopas, mao.get(3));
		assertEquals(asDeEspadas, mao.get(4));		
		assertEquals(5, mao.size());
	}
	@Test
	public void doisAsses() throws Exception {
		List<Carta> mao = Maos.TRINCA.mao(asList(asDeCopas, asDeEspadas));
		assertEquals(0, mao.size());
	}

	@Test
	public void vazio() throws Exception {
		List<Carta> mao = Maos.TRINCA.mao(Collections.emptyList());
		assertEquals(0, mao.size());
	}

}