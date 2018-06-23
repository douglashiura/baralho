package test.net.douglashiura.baralho.estatistica.maos.comparar;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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

public class TesteCompararAsClassificacoesParaVitoria extends TesteConfiguracaoDeCartas {

	private static Jogador douglas;
	private static Jogador patricia;
	private static Classificacao flush;
	private static Classificacao fullHouse;
	private static Classificacao quadra;
	private static Classificacao straightFlush;
	private static Classificacao royalFlush;
	private static Classificacao sequencia;
	private static Classificacao trinca;
	private static Classificacao doisPares;
	private static Classificacao umPar;
	private static Classificacao cartaAltaAs;

	@BeforeClass
	public static void configurar() throws Exception {
		douglas = new Jogador();
		patricia = new Jogador();
		royalFlush = Maos.classificar(asList(asDeCopas, kDeCopas, qDeCopas, jDeCopas, dezDeCopas));
		straightFlush = Maos.classificar(asList(kDeCopas, qDeCopas, jDeCopas, dezDeCopas, noveDeCopas));
		quadra = Maos.classificar(asList(kDeCopas, kDeEspadas, kDeOuro, kDePaus, noveDeCopas));
		fullHouse = Maos.classificar(asList(kDeCopas, kDeEspadas, kDeOuro, qDePaus, qDeOuro));
		flush = Maos.classificar(asList(kDeCopas, qDeCopas, jDeCopas, dezDeCopas, doisDeCopas));
		sequencia = Maos.classificar(asList(kDeCopas, qDeCopas, jDeCopas, dezDeCopas, noveDeOuro));
		trinca = Maos.classificar(asList(kDeCopas, kDeEspadas, kDeOuro, qDeCopas, dezDeEspadas));
		doisPares = Maos.classificar(asList(kDeCopas, kDeEspadas, qDeOuro, qDeCopas, dezDeEspadas));
		umPar = Maos.classificar(asList(asDeCopas, kDeEspadas, qDeOuro, qDeCopas, dezDeEspadas));
		cartaAltaAs = Maos.classificar(asList(asDeCopas, kDeEspadas, qDeOuro, jDeCopas, noveDeOuro));
	}

	@Test
	public void algumasCombinacoesDeMaosNuncaAconteceriamNoTexasHoldem() throws Exception {
		assertNotEquals(kDeCopas, kDeEspadas);
		assertEquals(kDeCopas, kDeCopas);
	}

	@Test
	public void royalFlushVersusStraightFlush() throws Exception {
		Jogada douglasJogou = new Jogada(douglas, royalFlush);
		Jogada patriciaJogou = new Jogada(patricia, straightFlush);
		Resultado vitoria = Comparadores.maos(patriciaJogou, douglasJogou);
		assertEquals(Resultados.VITORIA, vitoria.getTipo());
		assertEquals(Maos.ROYAL_FLUSH, vitoria.getMao());
		assertEquals(douglasJogou, vitoria.getVencedoras().get(0));
		assertEquals(1, vitoria.getVencedoras().size());
	}

	@Test
	public void straightFlushVsQuadra() throws Exception {
		Jogada douglasJogou = new Jogada(douglas, quadra);
		Jogada patriciaJogou = new Jogada(patricia, straightFlush);
		Resultado vitoria = Comparadores.maos(douglasJogou, patriciaJogou);
		assertEquals(Resultados.VITORIA, vitoria.getTipo());
		assertEquals(Maos.STRAIGHT_FLUSH, vitoria.getMao());
		assertEquals(patriciaJogou, vitoria.getVencedoras().get(0));
		assertEquals(1, vitoria.getVencedoras().size());
	}

	@Test
	public void quadraVersusFullHouse() throws Exception {
		Jogada douglasJogou = new Jogada(douglas, quadra);
		Jogada patriciaJogou = new Jogada(patricia, fullHouse);
		Resultado vitoria = Comparadores.maos(douglasJogou, patriciaJogou);
		assertEquals(Resultados.VITORIA, vitoria.getTipo());
		assertEquals(Maos.QUADRA, vitoria.getMao());
		assertEquals(douglasJogou, vitoria.getVencedoras().get(0));
		assertEquals(1, vitoria.getVencedoras().size());
	}

	@Test
	public void fullHouseVersusFlush() throws Exception {
		Jogada douglasJogou = new Jogada(douglas, fullHouse);
		Jogada patriciaJogou = new Jogada(patricia, flush);
		Resultado vitoria = Comparadores.maos(douglasJogou, patriciaJogou);
		assertEquals(Resultados.VITORIA, vitoria.getTipo());
		assertEquals(Maos.FULL_HOUSE, vitoria.getMao());
		assertEquals(douglasJogou, vitoria.getVencedoras().get(0));
		assertEquals(1, vitoria.getVencedoras().size());
	}

	@Test
	public void flushVsSequencia() throws Exception {
		Jogada douglasJogou = new Jogada(douglas, flush);
		Jogada patriciaJogou = new Jogada(patricia, sequencia);
		Resultado vitoria = Comparadores.maos(douglasJogou, patriciaJogou);
		assertEquals(Resultados.VITORIA, vitoria.getTipo());
		assertEquals(Maos.FLUSH, vitoria.getMao());
		assertEquals(douglasJogou, vitoria.getVencedoras().get(0));
		assertEquals(1, vitoria.getVencedoras().size());
	}

	@Test
	public void sequenciaVersusTrinca() throws Exception {
		Jogada douglasJogou = new Jogada(douglas, sequencia);
		Jogada patriciaJogou = new Jogada(patricia, trinca);
		Resultado vitoria = Comparadores.maos(douglasJogou, patriciaJogou);
		assertEquals(Resultados.VITORIA, vitoria.getTipo());
		assertEquals(Maos.SEQUENCIA, vitoria.getMao());
		assertEquals(douglasJogou, vitoria.getVencedoras().get(0));
		assertEquals(1, vitoria.getVencedoras().size());
	}

	@Test
	public void trincaVersusDoisPares() throws Exception {
		Jogada douglasJogou = new Jogada(douglas, trinca);
		Jogada patriciaJogou = new Jogada(patricia, doisPares);
		Resultado vitoria = Comparadores.maos(douglasJogou, patriciaJogou);
		assertEquals(Resultados.VITORIA, vitoria.getTipo());
		assertEquals(Maos.TRINCA, vitoria.getMao());
		assertEquals(douglasJogou, vitoria.getVencedoras().get(0));
		assertEquals(1, vitoria.getVencedoras().size());
	}

	@Test
	public void doisParesVersusUmPar() throws Exception {
		Jogada douglasJogou = new Jogada(douglas, doisPares);
		Jogada patriciaJogou = new Jogada(patricia, umPar);
		Resultado vitoria = Comparadores.maos(douglasJogou, patriciaJogou);
		assertEquals(Resultados.VITORIA, vitoria.getTipo());
		assertEquals(Maos.DOIS_PARES, vitoria.getMao());
		assertEquals(douglasJogou, vitoria.getVencedoras().get(0));
		assertEquals(1, vitoria.getVencedoras().size());
	}

	@Test
	public void parVesusCartaAlta() throws Exception {
		Jogada douglasJogou = new Jogada(douglas, umPar);
		Jogada patriciaJogou = new Jogada(patricia, cartaAltaAs);
		Resultado vitoria = Comparadores.maos(douglasJogou, patriciaJogou);
		assertEquals(Resultados.VITORIA, vitoria.getTipo());
		assertEquals(Maos.UM_PAR, vitoria.getMao());
		assertEquals(douglasJogou, vitoria.getVencedoras().get(0));
		assertEquals(1, vitoria.getVencedoras().size());
	}

	@Test
	public void cartaAltaVersusCartaAlta() throws Exception {
		Classificacao cartaAltaK = Maos.classificar(asList(kDeEspadas, qDeOuro, jDeCopas, noveDeOuro, seteDeCopas));
		Jogada douglasJogou = new Jogada(douglas, cartaAltaAs);
		Jogada patriciaJogou = new Jogada(patricia, cartaAltaK);
		Resultado vitoria = Comparadores.maos(douglasJogou, patriciaJogou);
		assertEquals(Resultados.VITORIA, vitoria.getTipo());
		assertEquals(Maos.CARTA_ALTA, vitoria.getMao());
		assertEquals(douglasJogou, vitoria.getVencedoras().get(0));
		assertEquals(1, vitoria.getVencedoras().size());
	}
	
	@Test
	public void cartaAltaKVersusCartaAltaAs() throws Exception {
		Classificacao cartaAltaK = Maos.classificar(asList(kDeEspadas, qDeOuro, jDeCopas, noveDeOuro, seteDeCopas));
		Jogada douglasJogou = new Jogada(douglas, cartaAltaK);
		Jogada patriciaJogou = new Jogada(patricia, cartaAltaAs);
		Resultado vitoria = Comparadores.maos(douglasJogou, patriciaJogou);
		assertEquals(Resultados.VITORIA, vitoria.getTipo());
		assertEquals(Maos.CARTA_ALTA, vitoria.getMao());
		assertEquals(patriciaJogou, vitoria.getVencedoras().get(0));
		assertEquals(1, vitoria.getVencedoras().size());
	}
}