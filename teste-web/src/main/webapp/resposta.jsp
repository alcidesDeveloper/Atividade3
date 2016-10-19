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
    <c:url value="css/estilos.css" var="urlEstilos" />
    <link rel="stylesheet" href="${urlEstilos}" />
    <title>JSP Page</title>
  </head>
  
  <body>
    <h1>Informações dos Contatos</h1>
    
        <table>
            <thead>
            <th>Nome</th>
            <th>Data de Nascimento</th>
            <th>Email</th>
            <th>Telefone</th>
            <th>Data de Cadastro</th>
            </thead>
            <tbody>
                <%int i = 1;%>
                <tr>
                <c:forEach items="${list}" var="value">
                    <td><c:out value="${value}"/></td>
                    <%if(i % 5 == 0){%>
                        </tr>
                    <%}
                    i++;%>               
                </c:forEach>                
            </tbody>
        </table>
            
 
        <p>
    <a href="formulario.jsp">Voltar para a tela do TesteServlet</a>
  </p>


</body>
</html>
