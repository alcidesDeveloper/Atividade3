/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.testeweb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ALCIDES
 */
public class ConexaoBD {
    
    public Connection retornaConexao() throws ClassNotFoundException, SQLException{
    Connection conn;
    Class.forName("org.apache.derby.jdbc.ClientDataSource");
    
      conn = DriverManager.getConnection(
	    "jdbc:derby://localhost:1527/agendabd;SecurityMechanism=3",
	    "app", // usuário BD
	    "app"); // senha BD
    return conn;

    }
}
