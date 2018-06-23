package net.douglashiura.baralho.banco;

public class Sqls {

	public static String selecao() {

		return "SELECT "
				+ "*"
				+ " FROM Rodada order by id OFFSET ?  LIMIT ?";
	}
}
