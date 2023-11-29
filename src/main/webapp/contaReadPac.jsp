<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sua Conta</title>
    <link rel="stylesheet" href="stylereadPac.css">
</head>
<body>
<%@ include file="/WEB-INF/navegadorPac.jsp"%>
<h2>Identificação do Paciente</h2>

<table>
    <tr>
        <td>ID:</td>
        <td>${sessionScope.paciente.id}</td>
    </tr>
    <tr>
        <td>Nome:</td>
        <td>${sessionScope.paciente.nome}</td>
    </tr>
    <tr>
        <td>Login:</td>
        <td>${sessionScope.paciente.login}</td>
    </tr>
    <tr>
        <td>Data de Nascimento:</td>
        <td>${sessionScope.paciente.dataNascimento}</td>
    </tr>
    <tr>
        <td>Sexo:</td>
        <td>${sessionScope.paciente.sexo}</td>
    </tr>
    <tr>
        <td>Nome da Mãe:</td>
        <td>${sessionScope.paciente.nomeMae}</td>
    </tr>
    <tr>
        <td>Naturalidade (Município):</td>
        <td>${sessionScope.paciente.naturalidadeMunicipio}</td>
    </tr>
    <tr>
        <td>Naturalidade (Estado):</td>
        <td>${sessionScope.paciente.naturalidadeEstado}</td>
    </tr>
    <tr>
        <td>Endereço:</td>
        <td>${sessionScope.paciente.endereco}</td>
    </tr>
</table>

</body>
</html>
