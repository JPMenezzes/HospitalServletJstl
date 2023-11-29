<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="styleindex.css">
</head>
<body>
<c:if test="${not empty param.mensagem}">
    <div class="mensagem">
            ${param.mensagem}
    </div>
</c:if>
<form method="get" action="processar_login">
    <h1>Formulário de Login</h1>
    <label>
        Login
        <input type="text" name="login" placeholder="Nome">
    </label>
    <label>
        Senha
        <input type="password" name="senha" placeholder="Senha">
    </label>
    <input type="submit" value="Login">
</form>
<br>
<p>
    Ainda não é cadastrado?
    <a href="notRegister.jsp">Clique Aqui</a>
</p>
</body>
</html>