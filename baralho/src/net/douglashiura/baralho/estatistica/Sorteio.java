package net.douglashiura.baralho.estatistica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.douglashiura.baralho.Baralho;
import net.douglashiura.baralho.Carta;

public class Sorteio {
	private List<Carta> cartas;

	public Sorteio(Baralho baralho) {
		cartas = new ArrayList<>(baralho.getCartas());
		embaralhar();
	}

	private void embaralhar() {
		Collections.shuffle(cartas);
	}

	public Carta retirarCarta() {
		Carta carta = cartas.get(0);
		cartas.remove(0);
		return carta;
	}

}
