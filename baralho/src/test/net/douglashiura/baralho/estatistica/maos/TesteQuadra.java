package test.net.douglashiura.baralho.estatistica.maos;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

import net.douglashiura.baralho.Carta;
import net.douglashiura.baralho.poker.Maos;

public class TesteQuadra extends TesteConfiguracaoDeCartas {
	@Test
	public void quadra() throws Exception {
		List<Carta> mao = Maos.QUADRA.mao(asList(asDeCopas, asDeEspadas, asDeOuro, asDePaus));
		assertEquals(asDePaus, mao.get(0));
		assertEquals(asDeEspadas, mao.get(1));
		assertEquals(asDeCopas, mao.get(2));
		assertEquals(asDeOuro, mao.get(3));
		assertEquals(4, mao.size());
	}

	@Test
	public void comDupla() throws Exception {
		List<Carta> mao = Maos.QUADRA.mao(asList(asDeCopas, asDeEspadas, asDeOuro, asDePaus, doisDeCopas, doisDeOuro));
		assertEquals(asDePaus, mao.get(0));
		assertEquals(asDeEspadas, mao.get(1));
		assertEquals(asDeCopas, mao.get(2));
		assertEquals(asDeOuro, mao.get(3));
		assertEquals(doisDeCopas, mao.get(4));
		assertEquals(5, mao.size());
	}

	@Test
	public void quadraComCartaAlta() throws Exception {
		List<Carta> mao = Maos.QUADRA.mao(asList(asDeCopas, asDeEspadas, asDeOuro, asDePaus, kDeCopas));
		assertEquals(asDePaus, mao.get(0));
		assertEquals(asDeEspadas, mao.get(1));
		assertEquals(asDeCopas, mao.get(2));
		assertEquals(asDeOuro, mao.get(3));
		assertEquals(kDeCopas, mao.get(4));
		assertEquals(5, mao.size());
	}

	@Test
	public void quadraComK() throws Exception {
		List<Carta> mao = Maos.QUADRA
				.mao(asList(asDeCopas, asDeEspadas, kDeEspadas, kDeOuro, kDePaus, kDeCopas, qDeCopas, qDeEspadas));
		assertEquals(kDePaus, mao.get(0));
		assertEquals(kDeEspadas, mao.get(1));
		assertEquals(kDeCopas, mao.get(2));
		assertEquals(kDeOuro, mao.get(3));
		assertEquals(asDeCopas, mao.get(4));
		assertEquals(5, mao.size());
	}

	@Test
	public void quadraComAs() throws Exception {
		List<Carta> mao = Maos.QUADRA.mao(asList(asDeCopas, asDeEspadas, kDeEspadas, kDeOuro, kDePaus, kDeCopas));
		assertEquals(kDePaus, mao.get(0));
		assertEquals(kDeEspadas, mao.get(1));
		assertEquals(kDeCopas, mao.get(2));
		assertEquals(kDeOuro, mao.get(3));
		assertEquals(asDeCopas, mao.get(4));
		assertEquals(5, mao.size());
	}

	@Test
	public void semQuadra() throws Exception {

		List<Carta> mao = Maos.QUADRA.mao(asList(asDeCopas, asDeEspadas, kDeEspadas, kDeOuro, kDePaus, doisDeCopas));
		assertEquals(0, mao.size());
	}

	@Test
	public void tripla() throws Exception {
		List<Carta> mao = Maos.QUADRA.mao(asList(kDeEspadas, kDeOuro, kDePaus));
		assertEquals(0, mao.size());
	}

	@Test
	public void apenasUmaCarta() throws Exception {
		List<Carta> mao = Maos.QUADRA.mao(asList(kDePaus));
		assertEquals(0, mao.size());
	}

	@Test
	public void vazio() throws Exception {
		List<Carta> mao = Maos.QUADRA.mao(Collections.emptyList());
		assertEquals(0, mao.size());
	}

}
