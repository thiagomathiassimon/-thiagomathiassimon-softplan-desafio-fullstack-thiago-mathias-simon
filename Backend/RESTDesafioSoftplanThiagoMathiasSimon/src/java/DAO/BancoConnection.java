/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Thiago Mathias Simon
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BancoConnection {

    //Classe responsavel de abrir e fechar conexão do banco.
    private static final String DRIVER =   "org.postgresql.Driver";
                                          //"com.mysql.jdbc.Driver";
                                          //"org.postgresql.Driver";

    //ENDERECO:PORTA/NOME_BANCO
    // 
    //private static final String URL = "jdbc:mysql://localhost/contato";
    
  // private static final String URL ="jdbc:mysql://localhost:3306/contato?useTimezone=true&serverTimezone=UTC";
     private static final String URL = "jdbc:postgresql://localhost:5432/banco-de-dados-desafio-softplan-thiago-mathias-simon";
    // jdbc é o protocolo;
    // postgresql, o sub-protocolo;
    // localhost é o endereço do servidor (IP ou nome);
    // 5432 é a porta, que é obrigatória caso não seja a padrão e opcional caso seja, e;
    // BDbombeiro é nome do banco de dados.

    //Usuario e senha do banco que você define quando cria o banco.
    private static final String USER = "postgres";
    private static final String PASS = "2608";

    //Abre conexão com o banco.
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Erro: " + ex);
            return null;
        }
    }

    //Fecha conexão com o banco.
    public static void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println("Erro: " + ex);
            }
        }
    }

    static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

