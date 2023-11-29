<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Dados do Paciente</title>
    <link rel="stylesheet" href="styleeditContaPacMed.css">
</head>
<body>
<%@ include file="/WEB-INF/navegadorMed.jsp"%>
<h2>Editar Dados do Paciente</h2>

<form action="processar_editar_conta_paciente_med" method="get">
    <input type="hidden" name="id" value="${param.id}">
    <br>
    <label for="nome">Nome:</label>
    <input type="text" name="nome" value="${param.nome}">
    <br>
    <label for="login">Login:</label>
    <input type="text" name="login" value="${param.login}">
    <br>
    <label for="senha">Senha:</label>
    <input type="password" name="senha" value="${param.senha}">
    <br>
    <label for="dataNascimento">Data de Nascimento:</label>
    <input type="text" name="dataNascimento" value="${param.dataNascimento}">
    <br>
    <label for="sexo">Sexo:</label>
    <input type="text" name="sexo" value="${param.sexo}">
    <br>
    <label for="nomeMae">Nome da Mãe:</label>
    <input type="text" name="nomeMae" value="${param.nomeMae}">
    <br>
    <label for="naturalidadeMunicipio">Naturalidade (Município):</label>
    <input type="text" name="naturalidadeMunicipio" value="${param.naturalidadeMunicipio}">
    <br>
    <label for="naturalidadeEstado">Naturalidade (Estado):</label>
    <input type="text" name="naturalidadeEstado" value="${param.naturalidadeEstado}">
    <br>
    <label for="endereco">Endereço:</label>
    <input type="text" name="endereco" value="${param.endereco}">
    <br>
    <input type="submit" value="Atualizar">
</form>
</body>
</html>



