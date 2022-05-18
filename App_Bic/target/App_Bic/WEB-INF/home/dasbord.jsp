<%--
  Created by IntelliJ IDEA.
  User: Aluno
  Date: 04/05/2022
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Olá ${usuario.nome}</h1>

<h2>${pageContext.session.id}</h2>
<h2>${pageContext.session.lastAccessedTime}</h2>

<ul>
    <li>  <a href="controlador?opcao=cliente">  CADASTRAR CLIENTE </a> </li>
    <li>  <a href="controlador?opcao=produto"> CADASTRAR PRODUTO  </a></li>
    <li>  <a href="controlador?opcao=sair"> SAIR </a></li>

</ul>

</body>
</html>
