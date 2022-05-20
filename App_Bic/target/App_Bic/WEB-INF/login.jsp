<%--
  Created by IntelliJ IDEA.
  User: Aluno
  Date: 04/05/2022
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Fazer login</h1> <br>


<form action="login" method="post"> <label for="email"> <b>Login<b> </label>
<input type="text" placeholder="email" name="email" required> <label for="senha"><b>Senha<b></label>
<input type="password" placeholder="senha"  name="senha" required>
<input type="submit" value="Login" name="Login"> <br>

</form>

<a href="controlador?opcao=cadastro"> Fazer cadastro </a>

<c:if test="${not empty erro}">

    <h6>
        <b>${erro}</b>
    </h6>

</c:if>

</body>
</html>
