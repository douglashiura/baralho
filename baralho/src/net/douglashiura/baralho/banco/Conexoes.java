package net.douglashiura.baralho.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexoes {
	
	public static  Connection obterConexao() throws ClassNotFoundException, SQLException {
		String url = "jdbc:postgresql://localhost:5432/saas";
		String usuario = "postgres";
		String senha = "senha";
		Class.forName("org.postgresql.Driver");
		return DriverManager.getConnection(url, usuario, senha);
	}

}
