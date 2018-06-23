package net.douglashiura.baralho;

public class Baralhos {

	public static Baralho getPoker() {
		return 
				new Baralho(Naipe.PAUS.getCartas(),
						Naipe.COPAS.getCartas(),
						Naipe.ESPADAS.getCartas(),
						Naipe.OUROS.getCartas());

	}

}
