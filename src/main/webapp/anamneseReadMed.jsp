<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Anamneses do Paciente</title>
    <link rel="stylesheet" href="styleanamneseReadMed.css">
</head>
<body>
<%@ include file="/WEB-INF/navegadorMed.jsp"%>
<h2>Anamneses do Paciente</h2>

<h2>Filtrar Anamneses</h2>
<form method="GET" action="processar_anamneses">
    <input type="hidden" name="id" value="${param.id}">
    <input type="date" name="dataFiltro">
    <button type="submit">Filtrar</button>
    <a href="processar_anamneses?id=${param.id}" class="btn-limpar">Limpar</a>
</form>

<table>
    <tr>
        <th>Data e Hora</th>
        <th>Médico Responsável</th>
        <th>Anamnese</th>
        <th>Exame Físico</th>
        <th>Exames Complementares</th>
        <th>Hipóteses Diagnósticas</th>
        <th>Diagnóstico Definitivo</th>
        <th>Tratamento Efetuado</th>
    </tr>
    <c:forEach var="anamnese" items="${anamneses}">
        <tr>
            <td>${anamnese.dataHora}</td>
            <td>${anamnese.nomeMedico}</td>
            <td>${anamnese.anamnese}</td>
            <td>${anamnese.exameFisico}</td>
            <td>${anamnese.examesComplementares}</td>
            <td>${anamnese.hipotesesDiagnosticas}</td>
            <td>${anamnese.diagnosticoDefinitivo}</td>
            <td>${anamnese.tratamento}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>

