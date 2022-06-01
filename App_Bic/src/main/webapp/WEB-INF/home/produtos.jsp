<%--
  Created by IntelliJ IDEA.
  User: Aluno
  Date: 11/05/2022
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro de Produtos</title>
</head>
<body>
<h1>Cadastro de produtos </h1>

<form action="cadastro_produto" method="post">

    <%--@declare id="nome"--%><%--@declare id="email"--%><%--@declare id="senha"--%><%--@declare id="preco"--%>
    <%--@declare id="quantidade"--%>

    <label for="nome"> <b>Nome<b> </label>
    <input type="text" placeholder="email" name="nome" required> <br>
    <br>

    <label for="preco"> <b>Preço<b> </label>
    <input type="number" placeholder="preco" name="preco" required><br>

    <br>

    <label for="quantidade"> <b>Quantidade<b> </label>
    <input type="number" placeholder="quantidade"  name="quantidade" required><br>
    <br>



    <input type="submit" value="Cadastrar" name="Cadastrar"> <br>

</form>

<c:if test="${not empty retorno}">

    <h6>
        <h1>${retorno}</h1>
    </h6>

</c:if>

</body>
</html>

