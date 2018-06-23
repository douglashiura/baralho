package net.douglashiura.baralho.poker;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import net.douglashiura.baralho.Carta;

public class Classificacao {
		private Maos mao;
		private List<Carta> cartas;

		private Classificacao(Maos mao, List<Carta> cartas) {
			this.mao = mao;
			this.cartas = cartas;
		}

		public List<Carta> getCartas() {
			return cartas;
		}

		public Maos getMao() {
			return mao;
		}

		 static Classificacao resultado(List<Carta> cartas) {
			Collections.sort(cartas, new Comparator<Carta>() {
				@Override
				public int compare(Carta o1, Carta o2) {
					return Integer.compare(o2.getNumero(), o1.getNumero());
				}
			});
			Maos[] maos = Maos.values();
			for (int i = maos.length-1; i >= 0; i--) {
				List<Carta> resultado = maos[i].mao(cartas);
				if (resultado.size() == 5) {
					return new Classificacao(maos[i], resultado);
				}
			}
			throw new RuntimeException();
		}
	}