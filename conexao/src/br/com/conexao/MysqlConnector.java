package br.com.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnector {
	public static String status = "Não conectou...";
	
	public MysqlConnector() {
		
	}
	
	public static Connection getConexaoMySQL() {

		Connection connection = null;
		
		try {

		String driverName = "com.mysql.cj.jdbc.Driver";
		Class.forName(driverName);
        String url = "jdbc:mysql://ip:3306/banco";
        String username = "***";
        String password = "***";
     
        connection = DriverManager.getConnection(url, username, password);

        if (connection != null) {

            status = "STATUS--->Conectado com sucesso!";

        } else {
            status = "STATUS--->Não foi possivel realizar conexão";
        }

        return connection;

        } catch (ClassNotFoundException e) {
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;
        } catch (SQLException e) {
        	e.printStackTrace();
        	System.out.println("Nao foi possivel conectar ao Banco de Dados.");
        	return null;
        }

	}
	
	public static String statusConection() {
        return status;
    }
	
	public static void fechaConexao() {
		try {
			getConexaoMySQL().close();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection reload() throws SQLException {
		getConexaoMySQL().close();
		return getConexaoMySQL();
	}
}
