package br.com.kaio.apache.poi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.sql.ResultSet;

public class ExcelLoadDb {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		
        String url="jdbc:mysql://ip:3306/banco?user=?&password=?";
        Connection connection = DriverManager.getConnection(url);
        
        if(connection != null) {
        	System.out.println("Conectado...");
        }else {
        	System.out.println("Não Conectado...");
        }
        
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = sheet.iterator();

        int r = 0;
        
        
        int categoriaID = 1; // partner
        String nome = "TESTE 2904 2";
        String raizCnpj = "00009090 2";
        String endereco = "TESTETSE 2";
        
        Statement stmt = connection.createStatement();
        stmt.executeLargeUpdate("INSERT INTO Grupo(ativo, categoria_categoriaID, dataAlteracao, dataCadastro, nome, raizCnpj, enderecoMatriz)" + 
        		"VALUES(1,"+categoriaID+", NOW(), NOW(), '"+nome+"', '"+raizCnpj+"', '"+endereco+"')" + 
        		"", Statement.RETURN_GENERATED_KEYS);
        
        int id = 0;
        ResultSet rs = stmt.getGeneratedKeys();

        if (rs.next()) {
            id = rs.getInt(1);
            
            String bairro = "";
            String cep = "";
            String cidade = "";
            String cnpj = "";
            
            String insert = "INSERT INTO Empresa(ativo, bairro, cep, cidade, cnpj, dataAlteracao, "
            		+ "dataCadastro, endereco, nomeFantasia, "
            		+ "razaoSocial, telefone1, grupo_grupoID, estado, emailGerente)" + 
            							"VALUES(1, 'N/D', '13015-310', 'SÃO PAULO', '01.214.583/0001-16', NOW()";
        } 

        System.out.println("ID GERADO:"
            + id);
        
        rs.close();
        connection.close();
        
        System.out.println("Desconectado...");
	}
}
