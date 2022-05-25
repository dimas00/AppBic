<%--
  Created by IntelliJ IDEA.
  User: aluno
  Date: 20/05/2022
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cadastro</title>
</head>
<body>
<h1>Fala aí pae, bora fazer teu cadastro! </h1>

<form action="cadastro" method="post">

    <label for="nome"> <b>Nome<b> </label>
    <input type="text" placeholder="email" name="nome" required> <br>
    <br>
    <label for="email"> <b>Email<b> </label>
    <input type="text" placeholder="email" name="email" required><br>

    <br>

        <label for="senha"><b>Senha<b></label>
    <input type="password" placeholder="senha"  name="senha" required><br>
    <br>



    <input type="submit" value="Login" name="Cadastrar"> <br>

</form>
</body>
</html>
