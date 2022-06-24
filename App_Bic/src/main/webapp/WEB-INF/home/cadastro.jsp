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
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

    <title>cadastro</title>
</head>
<body >



<h1>Realizar cadastro </h1>
<div>


</div>
<form class="row g-3" action="cadastro" method="post" >
    <div class="col-12">
        <label for="inputAddress" class="form-label">Nome</label>
        <input type="text" class="form-control" id="inputAddress" name="nome" placeholder="Digite seu nome:" required>
    </div>

    <div class="col-md-6">
        <label for="inputEmail4" class="form-label">Email required </label>
        <input type="email" class="form-control" id="inputEmail4" name="email" placeholder="Digite seu email:" >
    </div>
    <div class="col-md-6">
        <label for="inputPassword4" class="form-label">Senha required </label>
        <input type="password" class="form-control" name="senha" id="inputPassword4" placeholder="Digite sua senha:">
    </div>


    <div class="col-12">
        <input type="submit" class="btn btn-primary" value="Cadastrar" name="Cadastrar" ></input>
    </div>
</form>





<c:if test="${not empty erro}">

    <h6>
        <h1>${erro}</h1>
    </h6>

</c:if>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy" crossorigin="anonymous"></script>
</body>
</html>
