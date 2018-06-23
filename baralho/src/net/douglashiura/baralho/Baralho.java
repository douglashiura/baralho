package net.douglashiura.baralho;

import java.util.ArrayList;
import java.util.List;

public class Baralho {
	private List<Carta> cartas;

	public Baralho(List<Carta> paus, List<Carta> copas, List<Carta> espadas, List<Carta> ouros) {
		cartas = new ArrayList<>(52);
		cartas.addAll(paus);
		cartas.addAll(copas);
		cartas.addAll(espadas);
		cartas.addAll(ouros);
	}

	public List<Carta> getCartas() {
		return cartas;
	}
}
