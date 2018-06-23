package net.douglashiura.baralho.poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import net.douglashiura.baralho.Carta;
import net.douglashiura.baralho.Naipe;

public enum Maos {
	CARTA_ALTA("High Card") {
		@Override
		public List<Carta> mao(List<Carta> ordenadas) {
			if (ordenadas.size() > 5)
				return ordenadas.subList(0, 5);
			return new ArrayList<>(ordenadas);
		}
	},
	UM_PAR("One Pair") {
		@Override
		public List<Carta> mao(List<Carta> ordenadas) {
			ordenadas = new ArrayList<>(ordenadas);
			List<Carta> par = mesmoNumero(ordenadas, 2);
			ordenadas.removeAll(par);
			List<Carta> resultado = new ArrayList<>(5);
			resultado.addAll(par);
			for (int i = 0; i < ordenadas.size() && i < 3; i++) {
				resultado.add(ordenadas.get(i));
			}
			if (!par.isEmpty())
				return resultado;
			return Collections.emptyList();
		}
	},
	DOIS_PARES("Two pair") {
		@Override
		public List<Carta> mao(List<Carta> ordenadas) {
			ordenadas = new ArrayList<>(ordenadas);
			List<Carta> par = mesmoNumero(ordenadas, 2);
			ordenadas.removeAll(par);
			List<Carta> parDois = mesmoNumero(ordenadas, 2);
			List<Carta> resultado = new ArrayList<>(5);
			ordenadas.removeAll(parDois);
			resultado.addAll(par);
			resultado.addAll(parDois);
			if (!ordenadas.isEmpty())
				resultado.add(ordenadas.get(0));
			if (!(par.isEmpty() || parDois.isEmpty()))
				return resultado;
			return Collections.emptyList();
		}
	},
	TRINCA("Three of a Kind") {
		@Override
		public List<Carta> mao(List<Carta> ordenadas) {
			ordenadas = new ArrayList<>(ordenadas);
			List<Carta> trinca = mesmoNumero(ordenadas, 3);
			ordenadas.removeAll(trinca);
			List<Carta> resultado = new ArrayList<>(5);
			resultado.addAll(trinca);
			for (int i = 0; i < ordenadas.size() && i < 2; i++) {
				resultado.add(ordenadas.get(i));
			}
			if (!trinca.isEmpty())
				return resultado;
			return Collections.emptyList();
		}
	},
	SEQUENCIA("Straight") {
		@Override
		public List<Carta> mao(List<Carta> ordenadas) {
			List<Carta> maiorSequencia = Collections.emptyList();
			List<Carta> emOrdem = agrupadasPorNumero(ordenadas);
			while (!emOrdem.isEmpty()) {
				List<Carta> sequencia = obterProximaSequencia(emOrdem);
				emOrdem.removeAll(sequencia);
				if (maiorSequencia.size() < sequencia.size()) {
					maiorSequencia = sequencia;
				}
			}
			if (maiorSequencia.size() < 5) {
				return Collections.emptyList();
			}
			if (maiorSequencia.size() > 5) {
				return maiorSequencia.subList(0, 5);
			}
			return maiorSequencia;
		}

		private List<Carta> obterProximaSequencia(List<Carta> emOrdem) {
			List<Carta> sequencia = new ArrayList<>(emOrdem.size());
			Carta carta = emOrdem.get(0);
			sequencia.add(carta);
			for (int i = 1; i < emOrdem.size(); i++) {
				if (carta.getNumero() == (emOrdem.get(i).getNumero() + 1)) {
					carta = emOrdem.get(i);
					sequencia.add(carta);
				}
			}
			return sequencia;
		}

		private List<Carta> agrupadasPorNumero(List<Carta> ordenadas) {
			List<Carta> semRepitirNumero = new ArrayList<>(ordenadas);
			if (!ordenadas.isEmpty()) {
				Carta ultima = ordenadas.get(0);
				semRepitirNumero.add(ultima);
				for (Carta carta : ordenadas) {
					if (ultima.getNumero() != carta.getNumero()) {
						ultima = carta;
						semRepitirNumero.add(ultima);
					}
				}
			}
			return semRepitirNumero;
		}
	},
	FLUSH("Flush") {
		@Override
		public List<Carta> mao(List<Carta> ordenadas) {
			List<List<Carta>> lista = Arrays.asList(Naipe.PAUS.filtar(ordenadas), Naipe.ESPADAS.filtar(ordenadas),
					Naipe.COPAS.filtar(ordenadas), Naipe.OUROS.filtar(ordenadas));
			Collections.sort(lista, new Comparator<List<Carta>>() {
				@Override
				public int compare(List<Carta> o1, List<Carta> o2) {
					return Integer.compare(o2.size(), o1.size());
				}
			});
			List<Carta> maior = lista.get(0);
			if (maior.size() < 5) {
				return Collections.emptyList();
			} else if (maior.size() > 5)
				return maior.subList(0, 5);
			return maior;
		}
	},
	FULL_HOUSE("Full House") {
		@Override
		public List<Carta> mao(List<Carta> ordenadas) {
			ordenadas = new ArrayList<>(ordenadas);
			List<Carta> trinca = mesmoNumero(ordenadas, 3);
			ordenadas.removeAll(trinca);
			List<Carta> dupla = mesmoNumero(ordenadas, 2);
			if (!(trinca.isEmpty() || dupla.isEmpty())) {
				trinca.addAll(dupla);
				return trinca;
			}
			return Collections.emptyList();
		}
	},
	QUADRA("Four of a Kind") {
		@Override
		public List<Carta> mao(List<Carta> ordenadas) {
			ordenadas = new ArrayList<>(ordenadas);
			List<Carta> quadra = mesmoNumero(ordenadas, 4);
			ordenadas.removeAll(quadra);
			if (!(ordenadas.isEmpty() || quadra.isEmpty())) {
				Carta alta = ordenadas.get(0);
				ordenadas.clear();
				ordenadas.addAll(quadra);
				ordenadas.add(alta);
				return ordenadas;
			}
			return quadra;
		}
	},
	STRAIGHT_FLUSH("Straight Flush") {
		@Override
		public List<Carta> mao(List<Carta> ordenadas) {
			for (Naipe naipe : Naipe.values()) {
				List<Carta> cartasDoNipe = naipe.filtar(ordenadas);
				while (cartasDoNipe.size() >= 5) {
					Carta maior = cartasDoNipe.get(0);
					Carta menor = cartasDoNipe.get(4);
					if (maior.getNumero() - menor.getNumero() == 4)
						return cartasDoNipe.subList(0, 5);
					cartasDoNipe.remove(0);
				}
			}
			return Collections.emptyList();
		}
	},
	ROYAL_FLUSH("Royal Flush") {
		@Override
		public List<Carta> mao(List<Carta> ordenadas) {
			List<Carta> mao = STRAIGHT_FLUSH.mao(ordenadas);
			if (mao.size() == 5 && mao.get(0).getNome().equals("A"))
				return mao;
			return Collections.emptyList();
		}
	};
	Maos(String ingles) {
	}

	public abstract List<Carta> mao(List<Carta> ordenadas);

	private static List<Carta> mesmoNumero(List<Carta> ordenadas, int i) {
		ordenadas = new ArrayList<>(ordenadas);
		while (ordenadas.size() >= i) {
			Carta maior = ordenadas.get(0);
			Carta menor = ordenadas.get(i - 1);
			if (maior.getNumero() == menor.getNumero())
				return Naipe.ordenar(ordenadas.subList(0, i));
			ordenadas.remove(0);
		}
		return Collections.emptyList();
	}

	public static Classificacao classificar(List<Carta> cartas) {
		return Classificacao.resultado(cartas);
	}

}