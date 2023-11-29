<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Formulário de Anamnese</title>
    <link rel="stylesheet" href="styleanamneseCreate.css">
</head>
<body>
<%@include file="WEB-INF/navegadorMed.jsp"%>
<h1>Anamnese</h1>

<form method="get" action="processar_anamnese">
    <input type="hidden" name="pacienteId" value="${param.id}">
    <table>
        <!--
        <tr>
            <td>Data e Hora:</td>
            <td><input type="datetime-local" name="dataHora" required></td>
        </tr-->
        <tr>
            <td>Médico Responsável:</td>
            <td><input type="text" name="medicoResponsavel" required></td>
        </tr>
        <tr>
            <td>Anamnese:</td>
            <td><textarea name="anamnese" rows="5" cols="50" required></textarea></td>
        </tr>
        <tr>
            <td>Exame Físico:</td>
            <td><textarea name="exameFisico" rows="5" cols="50" required></textarea></td>
        </tr>
        <tr>
            <td>Exames Complementares Solicitados e Resultados:</td>
            <td><textarea name="examesComplementares" rows="5" cols="50" required></textarea></td>
        </tr>
        <tr>
            <td>Hipóteses Diagnósticas:</td>
            <td><textarea name="hipotesesDiagnosticas" rows="5" cols="50" required></textarea></td>
        </tr>
        <tr>
            <td>Diagnóstico Definitivo:</td>
            <td><textarea name="diagnosticoDefinitivo" rows="5" cols="50" required></textarea></td>
        </tr>
        <tr>
            <td>Tratamento Efetuado:</td>
            <td><textarea name="tratamentoEfetuado" rows="5" cols="50" required></textarea></td>
        </tr>
    </table>
    <input type="hidden" name="medicoId" value="${sessionScope.medico.id}">

    <input type="submit" value="Salvar">
</form>
</body>
</html>


