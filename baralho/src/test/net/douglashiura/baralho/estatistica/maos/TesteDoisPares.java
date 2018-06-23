package test.net.douglashiura.baralho.estatistica.maos;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

import net.douglashiura.baralho.Carta;
import net.douglashiura.baralho.poker.Maos;

public class TesteDoisPares extends TesteConfiguracaoDeCartas {
	@Test
	public void doisPares() throws Exception {
		List<Carta> mao = Maos.DOIS_PARES.mao(asList(asDeCopas, asDeEspadas, kDeEspadas, kDePaus));
		assertEquals(asDeEspadas, mao.get(0));
		assertEquals(asDeCopas, mao.get(1));
		assertEquals(kDePaus, mao.get(2));
		assertEquals(kDeEspadas, mao.get(3));
		assertEquals(4, mao.size());
	}

	@Test
	public void doisParesEUmSete() throws Exception {
		List<Carta> mao = Maos.DOIS_PARES
				.mao(asList(asDeCopas, asDeEspadas, kDeEspadas, kDePaus, seteDeCopas, seisDeCopas));
		assertEquals(asDeEspadas, mao.get(0));
		assertEquals(asDeCopas, mao.get(1));
		assertEquals(kDePaus, mao.get(2));
		assertEquals(kDeEspadas, mao.get(3));
		assertEquals(seteDeCopas, mao.get(4));
		assertEquals(5, mao.size());
	}

	@Test
	public void doisParesEoAs() throws Exception {
		List<Carta> mao = Maos.DOIS_PARES
				.mao(asList(asDeCopas, kDeEspadas, kDePaus, seteDeCopas, doisDeCopas, doisDeOuro));
		assertEquals(kDePaus, mao.get(0));
		assertEquals(kDeEspadas, mao.get(1));
		assertEquals(doisDeCopas, mao.get(2));
		assertEquals(doisDeOuro, mao.get(3));
		assertEquals(asDeCopas, mao.get(4));
		assertEquals(5, mao.size());
	}

	@Test
	public void umPar() throws Exception {
		List<Carta> mao = Maos.DOIS_PARES
				.mao(asList(asDeCopas, asDeEspadas, kDePaus, seteDeCopas, seisDeCopas, doisDeCopas));
		assertEquals(0, mao.size());
	}

	@Test
	public void vazio() throws Exception {
		List<Carta> mao = Maos.DOIS_PARES.mao(Collections.emptyList());
		assertEquals(0, mao.size());
	}

}
