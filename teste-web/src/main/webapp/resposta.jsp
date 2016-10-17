<%-- 
    Document   : resposta
    Created on : 07/10/2016, 20:47:52
    Author     : fernando.tsuda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  
  <body>
    <h1>Informações dos Contatos</h1>
    <div>
       <c:forEach items="${list}" var="value">
  <li><c:out value="${value}"/></li>
 </c:forEach>
     
 
        <p>
    <a href="formulario.jsp">Voltar para a tela do TesteServlet</a>
  </p>
  
</div>
</body>
</html>
