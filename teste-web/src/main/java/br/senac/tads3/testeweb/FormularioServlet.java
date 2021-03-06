/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.testeweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author fernando.tsuda
 */
@WebServlet(name = "FormularioServlet", urlPatterns = {"/formulario-servlet"})
public class FormularioServlet extends HttpServlet {

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
     ContatoDao dao = new ContatoDao();
     
    String nome = request.getParameter("nome");
    String email = request.getParameter("email");
    String dtNascStr = request.getParameter("dataNasc");
    String Tel = request.getParameter("telefone");

    
    DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
    Date dtNasc = null;
    try {
      dtNasc = formatador.parse(dtNascStr);
    } catch (ParseException ex) {
    }
    
    if(nome!=null && email!=null && dtNascStr!=null && Tel!=null){
    dao.incluiContato(nome, dtNasc, Tel, email);
    }
 
  
  ArrayList<String> contatos = dao.carregaDados();
    
      request.setAttribute("list", contatos);
    
    // Encaminhamento para o processamento continuar no jsp.
    RequestDispatcher dispatcher =
	    request.getRequestDispatcher("resposta.jsp");
    dispatcher.forward(request, response);
    
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}
