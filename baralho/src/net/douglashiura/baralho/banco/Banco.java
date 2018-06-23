package net.douglashiura.baralho.banco;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Banco {
	private PrintStream out;
	private List<Coluna> colunas;

	public Banco() throws FileNotFoundException {
		out = new PrintStream(new File("/home/douglas/recorte2.txt"));
		colunas = make(new String[] { "j11", "j12", "j21", "j22", "m1", "m2", "m3", "m4", "m5" });
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		Banco banco = new Banco();
		banco.gravarCabecalho();
		banco.lerResultados(banco.recortarBanco());

	}

	private List<Coluna> make(String[] strings) {
		List<Coluna> colunas2 = new ArrayList<Banco.Coluna>();
		for (String coluna : strings) {
			colunas2.add(new Carta(coluna, coluna));
		}
		return colunas2;
	}

	private ResultSet recortarBanco() throws ClassNotFoundException, SQLException {
		Connection conexao = Conexoes.obterConexao();
		PreparedStatement pre = conexao.prepareStatement(Sqls.selecao());
		int limit = 1000000;
		int deslocar = 0;
		pre.setInt(1, deslocar);
		pre.setInt(2, limit);
		ResultSet rs = pre.executeQuery();
		return rs;
	}

	private void lerResultados(ResultSet resultados) throws SQLException {
		while (resultados.next()) {

			out.println();
			lerTupla(resultados);

		}
	}

	private void lerTupla(ResultSet resultado) throws SQLException {

		out.print("s" + colunas.get(0).ler(resultado));
		for (int i = 1; i < colunas.size(); i++) {
			out.print("\ts" + colunas.get(i).ler(resultado));
		}
	}

	private void gravarCabecalho() {
		out.print(colunas.get(0).obterNome());
		for (int i = 1; i < colunas.size(); i++) {
			out.print("\t" + colunas.get(i).obterNome());
		}
	}

	interface Coluna {
		String obterNome();

		String ler(ResultSet resultado) throws SQLException;
	}

	public static class Padrao implements Coluna {
		private String nome;
		private String coluna;

		public Padrao(String nome, String coluna) {
			this.nome = nome;
			this.coluna = coluna;

		}

		@Override
		public String obterNome() {
			return nome;
		}

		@Override
		public String ler(ResultSet resultado) throws SQLException {
			return filtrar(resultado.getObject(coluna), resultado);
		}

		protected String filtrar(Object object, ResultSet resultado) throws SQLException {
			return (String) object;
		}
	}

	class Boleanos extends Padrao {

		public Boleanos(String nome, String coluna) {
			super(nome, coluna);
		}

		@Override
		protected String filtrar(Object object, ResultSet resultado) {
			if (object == null) {
				return "NULL";
			}
			return Boolean.TRUE.equals(object) ? "Sim" : "Nao";
		}
	}

	class Floats extends Padrao {

		public Floats(String nome, String coluna) {
			super(nome, coluna);
		}

		@Override
		protected String filtrar(Object object, ResultSet resultado) {
			if (object == null) {
				return "9999";
			}
			return object.toString();
		}

	}

	class Carta extends Padrao {

		private String nipe;

		public Carta(String nome, String coluna) {
			super(nome, coluna);
			nipe = "" + coluna.substring(0, 1) + "n" + coluna.substring(1);

		}

		@Override
		protected String filtrar(Object object, ResultSet resultado) throws SQLException {
			return resultado.getShort(nipe) + "_" + object.toString();
		}
	}

}
