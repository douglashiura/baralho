package net.douglashiura.baralho;

public class Carta {
	private String nome;
	private Naipe naipe;
	private short numero;

	public Carta(Naipe naipe, short numero, char... letra) {
		this.naipe = naipe;
		this.numero = numero;
		this.nome = new String(letra);
	}

	public short getNumero() {
		return numero;
	}

	public Naipe getNaipe() {
		return naipe;
	}

	public String getNome() {
		return nome;
	}
	@Override
	public String toString() {
		return nome+naipe;
	}
}
