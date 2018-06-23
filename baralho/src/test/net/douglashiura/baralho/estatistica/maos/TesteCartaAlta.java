package test.net.douglashiura.baralho.estatistica.maos;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

import net.douglashiura.baralho.Carta;
import net.douglashiura.baralho.poker.Maos;

public class TesteCartaAlta extends TesteConfiguracaoDeCartas {

	@Test
	public void umaCarta() throws Exception {
		List<Carta> mao = Maos.CARTA_ALTA.mao(asList(asDeCopas));
		assertEquals(asDeCopas, mao.get(0));
		assertEquals(1, mao.size());
	}
	
	@Test
	public void duas() throws Exception {
		List<Carta> mao = Maos.CARTA_ALTA.mao(asList(asDeCopas,asDeEspadas));
		assertEquals(asDeCopas, mao.get(0));
		assertEquals(asDeEspadas, mao.get(1));
		assertEquals(2, mao.size());
	}

	@Test
	public void seisCartas() throws Exception {
		List<Carta> mao = Maos.CARTA_ALTA
				.mao(asList(asDeCopas, asDeEspadas, kDeEspadas, kDePaus, seteDeCopas, seisDeCopas));
		assertEquals(asDeCopas, mao.get(0));
		assertEquals(asDeEspadas, mao.get(1));
		assertEquals(kDeEspadas, mao.get(2));
		assertEquals(kDePaus, mao.get(3));
		assertEquals(seteDeCopas, mao.get(4));
		assertEquals(5, mao.size());
	}

	@Test
	public void cincoCartas() throws Exception {
		List<Carta> mao = Maos.CARTA_ALTA.mao(asList(asDeCopas, asDeEspadas, kDeEspadas, kDePaus, seteDeCopas));
		assertEquals(asDeCopas, mao.get(0));
		assertEquals(asDeEspadas, mao.get(1));
		assertEquals(kDeEspadas, mao.get(2));
		assertEquals(kDePaus, mao.get(3));
		assertEquals(seteDeCopas, mao.get(4));
		assertEquals(5, mao.size());
	}

	@Test
	public void vazio() throws Exception {
		List<Carta> mao = Maos.CARTA_ALTA.mao(Collections.emptyList());
		assertEquals(0, mao.size());
	}

}
