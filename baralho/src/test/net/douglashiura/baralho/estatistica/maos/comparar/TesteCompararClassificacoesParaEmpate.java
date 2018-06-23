package test.net.douglashiura.baralho.estatistica.maos.comparar;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import net.douglashiura.baralho.poker.Classificacao;
import net.douglashiura.baralho.poker.Comparadores;
import net.douglashiura.baralho.poker.Jogada;
import net.douglashiura.baralho.poker.Maos;
import net.douglashiura.baralho.poker.Resultado;
import net.douglashiura.baralho.poker.Resultados;
import net.douglashiura.jogo.Jogador;
import test.net.douglashiura.baralho.estatistica.maos.TesteConfiguracaoDeCartas;

public class TesteCompararClassificacoesParaEmpate extends TesteConfiguracaoDeCartas {

	private static Jogador douglas;
	private static Jogador patricia;

	@BeforeClass
	public static void configurar() throws Exception {
		douglas = new Jogador();
		patricia = new Jogador();
	}
	
	@Test
	public void algumasCombinacoesDeMaosNuncaAconteceriamNoTexasHoldem() throws Exception {	
		assertNotEquals(kDeCopas, kDeEspadas);
		assertEquals(kDeCopas, kDeCopas);
	}

	@Test
	public void royalFlush() throws Exception {
		Classificacao resultado = Maos.classificar(asList(asDeCopas, kDeCopas, qDeCopas, jDeCopas, dezDeCopas));
		Jogada douglasJogou = new Jogada(douglas, resultado);
		Jogada patriciaJogou = new Jogada(patricia, resultado);
		Resultado empate = Comparadores.maos(douglasJogou, patriciaJogou);
		assertEquals(Resultados.EMPATE, empate.getTipo());
		assertEquals(Maos.ROYAL_FLUSH, empate.getMao());
		assertEquals(douglasJogou, empate.getVencedoras().get(0));
		assertEquals(patriciaJogou, empate.getVencedoras().get(1));
		assertEquals(2, empate.getVencedoras().size());
	}

	@Test
	public void straightFlush() throws Exception {
		Classificacao resultado = Maos.classificar(asList(kDeCopas, qDeCopas, jDeCopas, dezDeCopas, noveDeCopas));
		Classificacao resultado2 = Maos.classificar(asList(kDePaus, qDePaus, jDePaus, dezDePaus, noveDePaus));
		Jogada douglasJogou = new Jogada(douglas, resultado);
		Jogada patriciaJogou = new Jogada(patricia, resultado2);
		Resultado empate = Comparadores.maos(douglasJogou, patriciaJogou);
		assertEquals(Resultados.EMPATE, empate.getTipo());
		assertEquals(Maos.STRAIGHT_FLUSH, empate.getMao());
		assertEquals(douglasJogou, empate.getVencedoras().get(0));
		assertEquals(patriciaJogou, empate.getVencedoras().get(1));
		assertEquals(2, empate.getVencedoras().size());
	}

	@Test
	public void quadra() throws Exception {
		Classificacao resultado = Maos.classificar(asList(kDeCopas, kDeEspadas, kDeOuro, kDePaus, noveDeCopas));
		Jogada douglasJogou = new Jogada(douglas, resultado);
		Jogada patriciaJogou = new Jogada(patricia, resultado);
		Resultado empate = Comparadores.maos(douglasJogou, patriciaJogou);
		assertEquals(Resultados.EMPATE, empate.getTipo());
		assertEquals(Maos.QUADRA, empate.getMao());
		assertEquals(douglasJogou, empate.getVencedoras().get(0));
		assertEquals(patriciaJogou, empate.getVencedoras().get(1));
		assertEquals(2, empate.getVencedoras().size());
	}

	@Test
	public void fullHouse() throws Exception {
		Classificacao resultado = Maos.classificar(asList(kDeCopas, kDeEspadas, kDeOuro, qDePaus, qDeOuro));
		Jogada douglasJogou = new Jogada(douglas, resultado);
		Jogada patriciaJogou = new Jogada(patricia, resultado);
		Resultado empate = Comparadores.maos(douglasJogou, patriciaJogou);
		assertEquals(Resultados.EMPATE, empate.getTipo());
		assertEquals(Maos.FULL_HOUSE, empate.getMao());
		assertEquals(douglasJogou, empate.getVencedoras().get(0));
		assertEquals(patriciaJogou, empate.getVencedoras().get(1));
		assertEquals(2, empate.getVencedoras().size());
	}

	@Test
	public void flush() throws Exception {
		Classificacao resultado = Maos.classificar(asList(kDeCopas, qDeCopas, jDeCopas, dezDeCopas, doisDeCopas));
		Jogada douglasJogou = new Jogada(douglas, resultado);
		Jogada patriciaJogou = new Jogada(patricia, resultado);
		Resultado empate = Comparadores.maos(douglasJogou, patriciaJogou);
		assertEquals(Resultados.EMPATE, empate.getTipo());
		assertEquals(Maos.FLUSH, empate.getMao());
		assertEquals(douglasJogou, empate.getVencedoras().get(0));
		assertEquals(patriciaJogou, empate.getVencedoras().get(1));
		assertEquals(2, empate.getVencedoras().size());
	}

	@Test
	public void sequencia() throws Exception {
		Classificacao resultado = Maos.classificar(asList(kDeCopas, qDeCopas, jDeCopas, dezDeCopas, noveDeOuro));
		Jogada douglasJogou = new Jogada(douglas, resultado);
		Jogada patriciaJogou = new Jogada(patricia, resultado);
		Resultado empate = Comparadores.maos(douglasJogou, patriciaJogou);
		assertEquals(Resultados.EMPATE, empate.getTipo());
		assertEquals(Maos.SEQUENCIA, empate.getMao());
		assertEquals(douglasJogou, empate.getVencedoras().get(0));
		assertEquals(patriciaJogou, empate.getVencedoras().get(1));
		assertEquals(2, empate.getVencedoras().size());
	}

	@Test
	public void trinca() throws Exception {
		Classificacao resultado = Maos.classificar(asList(kDeCopas, kDeEspadas, kDeOuro, qDeCopas, dezDeEspadas));
		Jogada douglasJogou = new Jogada(douglas, resultado);
		Jogada patriciaJogou = new Jogada(patricia, resultado);
		Resultado empate = Comparadores.maos(douglasJogou, patriciaJogou);
		assertEquals(Resultados.EMPATE, empate.getTipo());
		assertEquals(Maos.TRINCA, empate.getMao());
		assertEquals(douglasJogou, empate.getVencedoras().get(0));
		assertEquals(patriciaJogou, empate.getVencedoras().get(1));
		assertEquals(2, empate.getVencedoras().size());
	}

	@Test
	public void doisPares() throws Exception {
		Classificacao resultado = Maos.classificar(asList(kDeCopas, kDeEspadas, qDeOuro, qDeCopas, dezDeEspadas));
		Jogada douglasJogou = new Jogada(douglas, resultado);
		Jogada patriciaJogou = new Jogada(patricia, resultado);
		Resultado empate = Comparadores.maos(douglasJogou, patriciaJogou);
		assertEquals(Resultados.EMPATE, empate.getTipo());
		assertEquals(Maos.DOIS_PARES, empate.getMao());
		assertEquals(douglasJogou, empate.getVencedoras().get(0));
		assertEquals(patriciaJogou, empate.getVencedoras().get(1));
		assertEquals(2, empate.getVencedoras().size());
	}

	@Test
	public void par() throws Exception {
		Classificacao resultado = Maos.classificar(asList(asDeCopas, kDeEspadas, qDeOuro, qDeCopas, dezDeEspadas));
		Jogada douglasJogou = new Jogada(douglas, resultado);
		Jogada patriciaJogou = new Jogada(patricia, resultado);
		Resultado empate = Comparadores.maos(douglasJogou, patriciaJogou);
		assertEquals(Resultados.EMPATE, empate.getTipo());
		assertEquals(Maos.UM_PAR, empate.getMao());
		assertEquals(douglasJogou, empate.getVencedoras().get(0));
		assertEquals(patriciaJogou, empate.getVencedoras().get(1));
		assertEquals(2, empate.getVencedoras().size());
	}

	@Test
	public void cartaAlta() throws Exception {
		Classificacao resultado = Maos.classificar(asList(asDeCopas, kDeEspadas, qDeOuro, jDeCopas, noveDeOuro));
		Jogada douglasJogou = new Jogada(douglas, resultado);
		Jogada patriciaJogou = new Jogada(patricia, resultado);
		Resultado empate = Comparadores.maos(douglasJogou, patriciaJogou);
		assertEquals(Resultados.EMPATE, empate.getTipo());
		assertEquals(Maos.CARTA_ALTA, empate.getMao());
		assertEquals(douglasJogou, empate.getVencedoras().get(0));
		assertEquals(patriciaJogou, empate.getVencedoras().get(1));
		assertEquals(2, empate.getVencedoras().size());

	}

}
