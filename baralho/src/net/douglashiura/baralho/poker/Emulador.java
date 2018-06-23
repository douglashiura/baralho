package net.douglashiura.baralho.poker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.douglashiura.baralho.Baralho;
import net.douglashiura.baralho.Baralhos;
import net.douglashiura.baralho.Carta;
import net.douglashiura.baralho.banco.Conexoes;
import net.douglashiura.baralho.estatistica.Sorteio;

public class Emulador {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection banco = Conexoes.obterConexao();
		banco.setAutoCommit(false);
		PreparedStatement estado = banco.prepareStatement(
				"INSERT INTO Rodada (j11,jn11,j12,jn12,j21,jn21,j22,jn22,m1,mn1,m2,mn2,m3,mn3,m4,mn4,m5,mn5) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		Baralho baralho = Baralhos.getPoker();
		for (short i = 0; i < Short.MAX_VALUE; i++) {
			for (short b = 2; b < Short.MAX_VALUE; b++) {
				Sorteio s = new Sorteio(baralho);
				Carta carta = s.retirarCarta();

				estado.setShort(1, carta.getNumero());
				estado.setShort(2, (short) carta.getNaipe().ordinal());
				carta = s.retirarCarta();
				estado.setShort(3, carta.getNumero());
				estado.setShort(4, (short) carta.getNaipe().ordinal());

				carta = s.retirarCarta();
				estado.setShort(5, carta.getNumero());
				estado.setShort(6, (short) carta.getNaipe().ordinal());

				carta = s.retirarCarta();
				estado.setShort(7, carta.getNumero());
				estado.setShort(8, (short) carta.getNaipe().ordinal());

				carta = s.retirarCarta();
				estado.setShort(9, carta.getNumero());
				estado.setShort(10, (short) carta.getNaipe().ordinal());

				carta = s.retirarCarta();
				estado.setShort(11, carta.getNumero());
				estado.setShort(12, (short) carta.getNaipe().ordinal());

				carta = s.retirarCarta();
				estado.setShort(13, carta.getNumero());
				estado.setShort(14, (short) carta.getNaipe().ordinal());

				carta = s.retirarCarta();
				estado.setShort(15, carta.getNumero());
				estado.setShort(16, (short) carta.getNaipe().ordinal());

				carta = s.retirarCarta();
				estado.setShort(17, carta.getNumero());
				estado.setShort(18, (short) carta.getNaipe().ordinal());

				estado.addBatch();
				estado.execute();
			}
			banco.commit();

		}

	}
}
