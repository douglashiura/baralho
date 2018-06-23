package test.net.douglashiura.baralho.estatistica;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import net.douglashiura.baralho.Baralhos;
import net.douglashiura.baralho.Carta;
import net.douglashiura.baralho.Naipe;
import net.douglashiura.baralho.estatistica.Frequencia;

public class TesteFrequencia {

	private Carta doisCopas;
	private Frequencia frequencia;

	@Before
	public void configuracao() {
		doisCopas = Naipe.COPAS.getCartas().get(0);
		List<Carta> cartas = Baralhos.getPoker().getCartas();
		frequencia = new Frequencia(cartas);
	}

	@Test
	public void test() {
		assertEquals((Double) (1d / (13 * 4)), frequencia.obterProbabilidade(doisCopas));
		assertEquals(new Integer(52), frequencia.obterTotal());
		assertEquals(new Integer(1), frequencia.obterFrequencia(doisCopas));
	}

	@Test
	public void dinamica() {
		frequencia.novaOcorrencia(doisCopas);
		assertEquals((Double) (2d / (13 * 4 + 1)), frequencia.obterProbabilidade(doisCopas));
		assertEquals(new Integer(53), frequencia.obterTotal());
		assertEquals(new Integer(2), frequencia.obterFrequencia(doisCopas));
	}

	@Test
	public void vazio() throws Exception {
		frequencia = new Frequencia(Collections.emptyList());
		assertEquals((Double) Double.NaN, frequencia.obterProbabilidade(doisCopas));
		assertEquals(new Integer(0), frequencia.obterTotal());
		assertEquals(new Integer(0), frequencia.obterFrequencia(doisCopas));
	}

}
