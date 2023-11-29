<!-- header.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="stylenavegadorMed.css">

<c:if test="${empty sessionScope.medico}">
    <c:redirect url="index.jsp?mensagem=Acesso Negado!" />
</c:if>

<c:if test="${not empty param.mensagem}">
    <div class="mensagem">
            ${param.mensagem}
    </div>
</c:if>

<div id="header">
    <ul>
        <li><a href="homeMed.jsp">Home</a></li>
        <li><a href="register.jsp">Registrar Usuário</a></li>
        <li><a href="contaEditMed.jsp">Editar sua Conta</a></li>
        <li><a href="sair">Sair</a></li>
        <p>Seja bem vindo ${sessionScope.medico.nome}!</p>
    </ul>
</div>
</html>

