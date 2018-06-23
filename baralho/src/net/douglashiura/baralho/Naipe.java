package net.douglashiura.baralho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Naipe {

	ESPADAS("Espadas", "♠", "Spades"), PAUS("Paus", "♣", "Clubs"), COPAS("Copas", "♥", "Hearts"), OUROS("Ouros", "♦",
			"Diamonds");
	private List<Carta> cartas;
	private String simbolo;

	Naipe(String escrito, String simbolo, String ingles) {
		this.simbolo = simbolo;
		cartas = Arrays.asList(new Carta(this, (short) 2, '2'), new Carta(this, (short) 3, '3'),
				new Carta(this, (short) 4, '4'), new Carta(this, (short) 5, '5'), new Carta(this, (short) 6, '6'),
				new Carta(this, (short) 7, '7'), new Carta(this, (short) 8, '8'), new Carta(this, (short) 9, '9'),
				new Carta(this, (short) 10, '1', '0'), new Carta(this, (short) 11, 'J'),
				new Carta(this, (short) 12, 'Q'), new Carta(this, (short) 13, 'K'), new Carta(this, (short) 14, 'A'));
	}

	@Override
	public String toString() {
		return simbolo;
	}


	public List<Carta> getCartas() {
		return new ArrayList<>(cartas);
	}

	public Carta obter(String simbolo) {
		for (Carta carta : cartas) {
			if (carta.getNome().equals(simbolo)) {
				return carta;
			}
		}
		throw new RuntimeException("Não encontrada");
	}

	public List<Carta> filtar(List<Carta> ordenadas) {
		List<Carta> filtras = new ArrayList<>(ordenadas.size());
		for (Carta carta : ordenadas) {
			if (this.equals(carta.getNaipe()))
				filtras.add(carta);
		}
		return filtras;
	}

	public static List<Carta> ordenar(List<Carta> cartas) {
		List<Carta> espadas = ESPADAS.filtar(cartas);
		cartas.removeAll(espadas);
		List<Carta> copas = COPAS.filtar(cartas);
		cartas.removeAll(copas);
		List<Carta> ouros = OUROS.filtar(cartas);
		cartas.removeAll(ouros);
		cartas.addAll(espadas);
		cartas.addAll(copas);
		cartas.addAll(ouros);
		return cartas;
	}
}