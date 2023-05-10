package br.com.conexao;

public class Main {

	public static void main(String[] args) {
		MysqlConnector.fechaConexao();
//		MysqlConnector.getConexaoMySQL();
		System.out.println(MysqlConnector.status);
	}

}
