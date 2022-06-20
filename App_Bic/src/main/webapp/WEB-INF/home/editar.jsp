<%--
  Created by IntelliJ IDEA.
  User: Dimas
  Date: 18/06/2022
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@page isELIgnored="false" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Produto</title>
</head>
<body>

<h1>Editar Produto</h1>

<form action="editar" method="post">

    <%--@declare id="nome"--%><%--@declare id="email"--%><%--@declare id="senha"--%><%--@declare id="preco"--%>
    <%--@declare id="quantidade"--%>

    <label for="nome"> <b>Nome<b> </label>
    <input type="text" placeholder="email" name="nome" value="${produto.nome}"  required> <br>
    <br>

    <label for="preco"> <b>Preço<b> </label>
    <input type="number" placeholder="preco" name="preco" value="${produto.preco}" required><br>

    <br>

    <label for="quantidade"> <b>Quantidade<b> </label>
    <input type="number" placeholder="quantidade"  name="quantidade" value="${produto.quantidade}" required><br>
    <br>


    <input type="hidden" name="id_produto" value="${produto.id}">
    <input type="submit"  name="Editar"> <br>

</form>

<c:if test="${not empty retorno}">

    <h6>
        <h1>${retorno}</h1>
    </h6>

</c:if>

<a href="controlador?opcao=produto"> VOLTAR </a>

</body>
</html>
