package test.net.douglashiura.baralho.estatistica.maos;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

import net.douglashiura.baralho.Carta;
import net.douglashiura.baralho.poker.Maos;

public class TesteSequencia extends TesteConfiguracaoDeCartas {

	@Test
	public void sequencia() throws Exception {
		List<Carta> mao = Maos.SEQUENCIA.mao(asList(asDeCopas, kDePaus, qDeOuro, jDeCopas, dezDeCopas));
		assertEquals(asDeCopas, mao.get(0));
		assertEquals(kDePaus.getNumero(), mao.get(1).getNumero());
		assertEquals(qDeOuro, mao.get(2));
		assertEquals(jDeCopas, mao.get(3));
		assertEquals(dezDeCopas, mao.get(4));
		assertEquals(5, mao.size());
	}

	@Test
	public void sequenciaAlta() {
		List<Carta> mao = Maos.SEQUENCIA.mao(asList(asDeCopas, kDePaus, qDeOuro, jDeCopas, dezDeCopas, noveDeOuro));
		assertEquals(asDeCopas, mao.get(0));
		assertEquals(kDePaus, mao.get(1));
		assertEquals(qDeOuro, mao.get(2));
		assertEquals(jDeCopas, mao.get(3));
		assertEquals(dezDeCopas, mao.get(4));
		assertEquals(5, mao.size());
	}

	@Test
	public void sequenciaDiferentesNipes() {
		List<Carta> mao = Maos.SEQUENCIA.mao(asList(asDeCopas, kDePaus, qDeOuro, jDeCopas, noveDeOuro));
		assertEquals(0, mao.size());
	}

	@Test
	public void sequenciaCompleta() {
		List<Carta> mao = Maos.SEQUENCIA.mao(asList(asDeCopas, kDePaus, qDeOuro, jDeCopas, noveDeOuro, oitoDePaus,
				seteDeCopas, seisDeCopas, cincoDeCopas, quatroDeCopas));
		assertEquals(noveDeOuro, mao.get(0));
		assertEquals(oitoDePaus, mao.get(1));
		assertEquals(seteDeCopas, mao.get(2));
		assertEquals(seisDeCopas, mao.get(3));
		assertEquals(cincoDeCopas, mao.get(4));
		assertEquals(5, mao.size());
	}

	@Test
	public void duasDeTres() {
		List<Carta> mao = Maos.SEQUENCIA.mao(asList(asDeCopas, kDeCopas, dezDeCopas));
		assertEquals(0, mao.size());
	}

	@Test
	public void umaCarta() {
		List<Carta> mao = Maos.SEQUENCIA.mao(asList(asDeCopas));
		assertEquals(0, mao.size());
	}

	@Test
	public void umaDeDuas() {
		List<Carta> mao = Maos.SEQUENCIA.mao(asList(asDeCopas, asDeEspadas));
		assertEquals(0, mao.size());
	}

	@Test
	public void vazia() {
		List<Carta> mao = Maos.SEQUENCIA.mao(Collections.emptyList());
		assertEquals(0, mao.size());
	}
}
