<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="stylehomeMed.css">
</head>
<body>
<%@include file="WEB-INF/navegadorMed.jsp"%>

<h2>Pesquisar Paciente</h2>
<form method="GET" action="processar_pacientes">
    <input type="text" name="nomePaciente" placeholder="Digite o nome do paciente">
    <button type="submit">Pesquisar</button>
    <a href="processar_pacientes" class="btn-limpar">Limpar</a>
</form>
<c:forEach var="paciente" items="${pacientes}">
<section class="paciente">
        <h1>ID: ${paciente.id}</h1>
        <h1>Nome: ${paciente.nome}</h1>
        <p>
            <a href="processar_anamneses?id=${paciente.id}">Anamneses</a>
            <a href="contaEditPacMed.jsp?id=${paciente.id}&nome=${paciente.nome}&login=${paciente.login}&senha=${paciente.senha}&dataNascimento=${paciente.dataNascimento}&sexo=${paciente.sexo}&nomeMae=${paciente.nomeMae}&naturalidadeMunicipio=${paciente.naturalidadeMunicipio}&naturalidadeEstado=${paciente.naturalidadeEstado}&endereco=${paciente.endereco}">Editar Dados</a>
            <a href="anamneseCreate.jsp?id=${paciente.id}">Realizar Consulta</a>
        </p>
</section>
</c:forEach>
</body>
</html>
