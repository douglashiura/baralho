package test.net.douglashiura.baralho.estatistica.maos;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

import net.douglashiura.baralho.Carta;
import net.douglashiura.baralho.poker.Maos;

public class TesteFlush extends TesteConfiguracaoDeCartas {
	@Test
	public void duasCartas() throws Exception {
		List<Carta> mao = Maos.FLUSH.mao(asList(asDeCopas, asDeEspadas, asDeOuro, kDeCopas, kDePaus));
		assertEquals(0, mao.size());
	}

	@Test
	public void flush() throws Exception {
		List<Carta> mao = Maos.FLUSH.mao(asList(asDeCopas, kDeCopas, qDeCopas, jDeCopas, dezDeCopas));
		assertEquals(asDeCopas, mao.get(0));
		assertEquals(kDeCopas, mao.get(1));
		assertEquals(qDeCopas, mao.get(2));
		assertEquals(jDeCopas, mao.get(3));
		assertEquals(dezDeCopas, mao.get(4));
		assertEquals(5, mao.size());
	}

	@Test
	public void flushMaior() throws Exception {
		List<Carta> mao = Maos.FLUSH.mao(asList(asDeCopas, kDeCopas, qDeCopas, jDeCopas, dezDeCopas, seteDeCopas));
		assertEquals(asDeCopas, mao.get(0));
		assertEquals(kDeCopas, mao.get(1));
		assertEquals(qDeCopas, mao.get(2));
		assertEquals(jDeCopas, mao.get(3));
		assertEquals(dezDeCopas, mao.get(4));
		assertEquals(5, mao.size());
	}

	@Test
	public void flushComGrupos() throws Exception {
		List<Carta> mao = Maos.FLUSH
				.mao(asList(asDeCopas, kDePaus, qDeCopas, jDeCopas, dezDePaus, seteDeCopas, seisDeCopas));
		assertEquals(asDeCopas, mao.get(0));
		assertEquals(qDeCopas, mao.get(1));
		assertEquals(jDeCopas, mao.get(2));
		assertEquals(seteDeCopas, mao.get(3));
		assertEquals(seisDeCopas, mao.get(4));
		assertEquals(5, mao.size());
	}

	@Test
	public void umaCarta() throws Exception {
		List<Carta> mao = Maos.FLUSH.mao(asList(asDeCopas));
		assertEquals(0, mao.size());
	}

	@Test
	public void duasCartasMasUma() throws Exception {
		List<Carta> mao = Maos.FLUSH.mao(asList(asDeCopas, asDeEspadas));
		assertEquals(0, mao.size());
	}

	@Test
	public void vazio() throws Exception {
		List<Carta> mao = Maos.FLUSH.mao(Collections.emptyList());
		assertEquals(0, mao.size());
	}
}