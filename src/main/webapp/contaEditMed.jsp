<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Conta Médico</title>
    <link rel="stylesheet" href="styleeditContaMed.css">
</head>
<body>
<%@include file="WEB-INF/navegadorMed.jsp"%>
<c:if test="${not empty param.mensagem}">
    <div class="mensagem">
            ${param.mensagem}
    </div>
</c:if>
    <h1>Editar Conta Médico</h1>
<form action="processar_editar_conta_med" method="get">
    <input type="hidden" name="id" value="${sessionScope.medico.id}">
    <input type="hidden" name="login" value="${sessionScope.medico.login}">
    <br>
    <br>
    <label>Novo Nome:</label>
    <input type="text" name="nome" value="${sessionScope.medico.nome}"><br><br>
    <label>Nova Senha:</label>
    <input type="password" name="senha" value="${sessionScope.medico.senha}"><br><br>
    <label>Nova Especializacao:</label>
    <input type="text" name="especializacao" value="${sessionScope.medico.especializacao}"><br><br>
    <input type="submit" value="Atualizar">
</form>
</body>
</html>
