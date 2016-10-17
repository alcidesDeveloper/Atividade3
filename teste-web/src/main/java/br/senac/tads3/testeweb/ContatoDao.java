/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.testeweb;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ALCIDES
 */
public class ContatoDao extends ConexaoBD {
   
    ArrayList<String> dados;
    private String nome;
    private Date dateNasc;
    private String telefone;
    private String email;
    private Date cadastro;

    private Connection conn;
    private PreparedStatement st;
    private ResultSet result;
    
    public ContatoDao() {
        dados = new ArrayList<>();
      
    }

    public ArrayList<String> carregaDados() {

        dados.clear();
        
        try {
            conn = retornaConexao();

            this.st = conn.prepareStatement("SELECT NM_CONTATO,DT_NASCIMENTO,VL_TELEFONE,VL_EMAIL,DT_CADASTRO FROM TB_CONTATO");
            result = st.executeQuery();
            
            while (result.next()) {
            this.dados.add(result.getString("NM_CONTATO"));
            this.dados.add(result.getString("DT_NASCIMENTO"));
            this.dados.add(result.getString("VL_TELEFONE"));
            this.dados.add(result.getString("VL_EMAIL"));
            this.dados.add(result.getString("DT_CADASTRO"));
            }
        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {
        }

        finally{
        fechaConexao();
        }
        return this.dados;
    }
    
    public void incluiContato(String nome, Date dataNasc, String telefone, String email){
        try {
            conn = retornaConexao();
            st = conn.prepareStatement("INSERT INTO TB_CONTATO(NM_CONTATO,DT_NASCIMENTO,VL_TELEFONE,VL_EMAIL,DT_CADASTRO)VALUES(?,?,?,?,?)");
            st.setString(1,nome );
            st.setDate(2,new java.sql.Date(dataNasc.getTime()));
            st.setString(3, telefone);
            st.setString(4, email);
            st.setDate(5, new java.sql.Date(System.currentTimeMillis()));
            
            st.executeUpdate();
            
        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {

        }
        
        finally{
        fechaConexao();
        }
    }
    
    public void fechaConexao(){
        try {
            this.st.close();
              this.conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
}
