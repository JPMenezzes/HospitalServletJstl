<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Dados do Paciente</title>
    <link rel="stylesheet" href="styleeditPac.css">
<body>
<%@ include file="/WEB-INF/navegadorPac.jsp"%>
<c:if test="${not empty param.mensagem}">
    <div class="mensagem">
            ${param.mensagem}
    </div>
</c:if>
<h2>Editar Dados do Paciente</h2>

<form action="processar_editar_conta_paciente" method="get">
    <input type="hidden" name="id" value="${sessionScope.paciente.id}">
    <br>
    <label for="endereco">Endereço:</label>
    <input type="text" name="endereco" value="${sessionScope.paciente.endereco}">
    <br>
    <label for="senha">Nova Senha:</label>
    <input type="password" name="senha" value="${sessionScope.paciente.senha}">
    <br>
    <input type="submit" value="Atualizar">
</form>

</body>
</html>






