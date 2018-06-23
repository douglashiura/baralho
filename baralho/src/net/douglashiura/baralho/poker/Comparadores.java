package net.douglashiura.baralho.poker;

import java.util.Arrays;
import java.util.List;

import net.douglashiura.baralho.Carta;

public class Comparadores {
	@Refatorar
	public static Resultado maos(Jogada jogada1, Jogada jogada2) {
		Maos mao = jogada1.getResultado().getMao();
		Maos mao2 = jogada2.getResultado().getMao();
		if (mao.ordinal() == mao2.ordinal()) {
			List<Carta> cartasJogada1 = jogada1.getResultado().getCartas();
			List<Carta> cartasJogada2 = jogada2.getResultado().getCartas();
			for (int i = 0; i < cartasJogada1.size(); i++) {
				if (cartasJogada1.get(i).getNumero() > cartasJogada2.get(i).getNumero()) {
					return new Resultado(Resultados.VITORIA, mao, Arrays.asList(jogada1));
				} else if (cartasJogada1.get(i).getNumero() < cartasJogada2.get(i).getNumero()) {
					return new Resultado(Resultados.VITORIA, mao2, Arrays.asList(jogada2));
				}
			}
			return new Resultado(Resultados.EMPATE, mao, Arrays.asList(jogada1, jogada2));
		} else if (mao.ordinal() > mao2.ordinal()) {
			return new Resultado(Resultados.VITORIA, mao, Arrays.asList(jogada1));
		} else {
			return new Resultado(Resultados.VITORIA, mao2, Arrays.asList(jogada2));
		}
	}

}
