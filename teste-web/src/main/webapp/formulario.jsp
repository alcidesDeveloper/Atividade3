<%-- 
    Document   : formulario
    Created on : 07/10/2016, 20:36:36
    Author     : fernando.tsuda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Entrada</title>
    <c:url value="css/estilos.css" var="urlEstilos" />
    <link rel="stylesheet" href="${urlEstilos}" />
  </head>
  <body>
    <h1>Cadastro de pessoa</h1>
    <c:url value="formulario-servlet" var="urlFormulario" />
    <form action="${urlFormulario}" method="post" enctype="application/x-www-form-urlencoded">

        
<fieldset>

<legend>Cadastro</legend>

<Label for="nome">Nome</Label><input type="text" id="nome" name="nome" required/>
<Label for="nasc">Data de Nascimento</Label><input type="text" id="nasc" name="dataNasc" required/>
<Label for="tel">Telefone</Label><input type="text" id="tel" name="telefone" required/>
<Label for="email">Email</Label><input type="email" id="email" name="email" required/>

</fieldset>
      
      <div>
	<input type="submit" value="Enviar" />
	<input type="reset" value="Limpar" />
      </div>
    </form>
  </body>
</html>
