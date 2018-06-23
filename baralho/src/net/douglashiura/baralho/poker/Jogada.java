package net.douglashiura.baralho.poker;

import net.douglashiura.jogo.Jogador;

public class Jogada {

	private Jogador jogador;
	private Classificacao resultado;

	public Jogada(Jogador jogador, Classificacao resultado) {
		this.jogador = jogador;
		this.resultado = resultado;
	}
	public Classificacao getResultado() {
		return resultado;
	}

}
