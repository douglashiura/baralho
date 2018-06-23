package net.douglashiura.baralho.estatistica;

import java.util.HashMap;
import java.util.List;

import net.douglashiura.baralho.Carta;

public class Frequencia {
	private HashMap<Carta, Integer> frequencias;
	private Integer total = 0;

	public Frequencia(List<Carta> cartas) {
		frequencias = new HashMap<>();
		for (Carta carta : cartas)
			contar(carta);
	}

	private void contar(Carta carta) {
		Integer quantidade = obterFrequencia(carta);
		frequencias.put(carta, ++quantidade);
		total++;
	}

	public Double obterProbabilidade(Carta carta) {
		return (double) frequencias.getOrDefault(carta, 0) / total;
	}

	public Integer obterTotal() {
		return total;
	}

	public Integer obterFrequencia(Carta carta) {
		return frequencias.getOrDefault(carta, 0);
	}

	public void novaOcorrencia(Carta carta) {
		contar(carta);
	}
}
