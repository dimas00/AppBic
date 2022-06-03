<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@page isELIgnored="false" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
<h2>Página inicial</h2>

<c:forEach var = "produto" items="${produtos}">

    <div>${produto.nome}</div>


    <div>${produto.preco}</div>





</c:forEach>
<li>  <a href="controlador?opcao=login">  FAZER LOGIN </a> </li>
<li>  <a href="controlador?opcao=cliente">  CADASTRAR CLIENTE </a> </li>
<li>  <a href="controlador?opcao=produto"> CADASTRAR PRODUTO  </a></li>
<li>  <a href="controlador?opcao=sair"> SAIR </a></li>

</body>
</html>
