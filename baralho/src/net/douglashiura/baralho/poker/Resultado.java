package net.douglashiura.baralho.poker;

import java.util.List;

public class Resultado {

	private Resultados tipo;
	private Maos mao;
	private List<Jogada> vencedoras;

	public Resultado(Resultados tipo, Maos mao, List<Jogada> vencedoras) {
		this.tipo = tipo;
		this.mao = mao;
		this.vencedoras = vencedoras;
	}

	public Resultados getTipo() {
		return tipo;
	}

	public List<Jogada> getVencedoras() {
		return vencedoras;
	}

	public Maos getMao() {
		return mao;
	}

}
