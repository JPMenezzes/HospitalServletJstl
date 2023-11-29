<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registrar</title>
    <link rel="stylesheet" href="styleregister.css">
</head>
<body>
<%@include file="WEB-INF/navegadorMed.jsp"%>
<h1>Registrar Conta</h1>
<form method="get" action="processar_register">
    <label>
        Tipo de Conta:
        <input type="radio" name="tipoConta" value="medico" required> Médico
        <input type="radio" name="tipoConta" value="paciente" required> Paciente
    </label>
    <br><br>
    <label>
        Login:
        <input type="text" name="login" required>
    </label>
    <br><br>
    <label>
        Senha:
        <input type="password" name="password" required>
    </label>
    <br><br>

    <%-- Campos específicos para Conta de Médico --%>
    <div id="camposMedico" style="display: none;">
        <label>
            Nome:
            <input type="text" name="nomeMedico">
        </label>
        <br><br>
        <label>
            Especialização:
            <input type="text" name="especializacao">
        </label>
        <br><br>
    </div>

    <%-- Campo específico para Conta de Paciente --%>
    <div id="camposPaciente" style="display: none;">
        <label>
            Nome:
            <input type="text" name="nomePaciente">
        </label>
        <br><br>
        <label>
            Data de Nascimento:
            <input type="date" name="dataNascimentoPaciente">
        </label>
        <br><br>
        <label>
            Sexo:
            <select name="sexoPaciente">
                <option value="Masculino">Masculino</option>
                <option value="Feminino">Feminino</option>
            </select>
        </label>
        <br><br>
        <label>
            Nome da Mãe:
            <input type="text" name="nomeMaePaciente">
        </label>
        <br><br>
        <label>
            Naturalidade (Estado):
            <input type="text" name="naturalidadeEstadoPaciente">
        </label>
        <br><br>
        <label>
            Naturalidade (Município):
            <input type="text" name="naturalidadeMunicipioPaciente">
        </label>
        <br><br>
        <label>
            Endereço:
            <input type="text" name="enderecoPaciente">
        </label>
        <br><br>
    </div>

    <input type="submit" value="Criar Conta">
</form>
<script>
    function exibirCamposEspecificos() {
        var tipoConta = document.querySelector('input[name="tipoConta"]:checked').value;
        var camposMedico = document.getElementById('camposMedico');
        var camposPaciente = document.getElementById('camposPaciente');

        if (tipoConta === 'medico') {
            camposMedico.style.display = 'block';
            camposPaciente.style.display = 'none';
        } else if (tipoConta === 'paciente') {
            camposMedico.style.display = 'none';
            camposPaciente.style.display = 'block';
        } else {
            camposMedico.style.display = 'none';
            camposPaciente.style.display = 'none';
        }
    }

    document.querySelectorAll('input[name="tipoConta"]').forEach(function(radio) {
        radio.addEventListener('change', exibirCamposEspecificos);
    });

    exibirCamposEspecificos();
</script>
</body>
</html>
