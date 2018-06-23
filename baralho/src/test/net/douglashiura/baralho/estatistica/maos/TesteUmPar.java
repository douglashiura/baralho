package test.net.douglashiura.baralho.estatistica.maos;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

import net.douglashiura.baralho.Carta;
import net.douglashiura.baralho.poker.Maos;

public class TesteUmPar extends TesteConfiguracaoDeCartas {

	@Test
	public void umParApenas() throws Exception {
		List<Carta> mao = Maos.UM_PAR.mao(asList(asDeCopas, asDeEspadas));
		assertEquals(asDeEspadas, mao.get(0));
		assertEquals(asDeCopas, mao.get(1));
		assertEquals(2, mao.size());
	}

	@Test
	public void doisParesEUmSete() throws Exception {
		List<Carta> mao = Maos.UM_PAR
				.mao(asList(asDeCopas, asDeEspadas, kDeEspadas, kDePaus, seteDeCopas, seisDeCopas));
		assertEquals(asDeEspadas, mao.get(0));
		assertEquals(asDeCopas, mao.get(1));
		assertEquals(kDeEspadas, mao.get(2));
		assertEquals(kDePaus, mao.get(3));
		assertEquals(seteDeCopas, mao.get(4));
		assertEquals(5, mao.size());
	}

	@Test
	public void umParEUmaFolha() throws Exception {
		List<Carta> mao = Maos.UM_PAR.mao(asList(asDeCopas, kDeEspadas, kDePaus));
		assertEquals(kDePaus, mao.get(0));
		assertEquals(kDeEspadas, mao.get(1));
		assertEquals(asDeCopas, mao.get(2));
		assertEquals(3, mao.size());
	}

	@Test
	public void umParEDuasFolha() throws Exception {
		List<Carta> mao = Maos.UM_PAR.mao(asList(asDeCopas, kDeEspadas, kDePaus, seteDeCopas));
		assertEquals(kDePaus, mao.get(0));
		assertEquals(kDeEspadas, mao.get(1));
		assertEquals(asDeCopas, mao.get(2));
		assertEquals(seteDeCopas, mao.get(3));
		assertEquals(4, mao.size());
	}

	@Test
	public void umParETresFolha() throws Exception {
		List<Carta> mao = Maos.UM_PAR.mao(asList(asDeCopas, kDeEspadas, kDePaus, seteDeCopas, doisDeCopas));
		assertEquals(kDePaus, mao.get(0));
		assertEquals(kDeEspadas, mao.get(1));
		assertEquals(asDeCopas, mao.get(2));
		assertEquals(seteDeCopas, mao.get(3));
		assertEquals(doisDeCopas, mao.get(4));
		assertEquals(5, mao.size());
	}

	@Test
	public void umParESeisFolhas() throws Exception {
		List<Carta> mao = Maos.UM_PAR.mao(asList(asDeCopas, kDeEspadas, kDePaus, seteDeCopas, doisDeCopas, doisDeOuro));
		assertEquals(kDePaus, mao.get(0));
		assertEquals(kDeEspadas, mao.get(1));
		assertEquals(asDeCopas, mao.get(2));
		assertEquals(seteDeCopas, mao.get(3));
		assertEquals(doisDeCopas, mao.get(4));
		assertEquals(5, mao.size());
	}

	@ Test
	public void nenumPar() throws Exception {
		List<Carta> mao = Maos.UM_PAR.mao(asList(asDeCopas, kDeEspadas, jDePaus, seteDeCopas, tresDeCopas, doisDeOuro));
		assertEquals(0, mao.size());
	}
	@Test
	public void vazio() throws Exception {
		List<Carta> mao = Maos.UM_PAR.mao(Collections.emptyList());
		assertEquals(0, mao.size());
	}

}
