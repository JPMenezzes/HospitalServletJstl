package com.example.hospital.Modelo;

import java.time.LocalDateTime;

public class Anamnese {
    private int id;
    private LocalDateTime dataHora;
    private String nomeMedico;
    private String anamnese;
    private String exameFisico;
    private String examesComplementares;
    private String hipotesesDiagnosticas;
    private String diagnosticoDefinitivo;
    private String tratamento;
    private int pacienteId;
    private int medicoId;

    public Anamnese(LocalDateTime dataHora, String nomeMedico, String anamnese, String exameFisico, String examesComplementares, String hipotesesDiagnosticas, String diagnosticoDefinitivo, String tratamento, int pacienteId, int medicoId) {
        this.dataHora = dataHora;
        this.nomeMedico = nomeMedico;
        this.anamnese = anamnese;
        this.exameFisico = exameFisico;
        this.examesComplementares = examesComplementares;
        this.hipotesesDiagnosticas = hipotesesDiagnosticas;
        this.diagnosticoDefinitivo = diagnosticoDefinitivo;
        this.tratamento = tratamento;
        this.pacienteId = pacienteId;
        this.medicoId = medicoId;
    }

    public Anamnese(int id, LocalDateTime dataHora, String nomeMedico, String anamnese, String exameFisico, String examesComplementares, String hipotesesDiagnosticas, String diagnosticoDefinitivo, String tratamento, int pacienteId, int medicoId) {
        this.id = id;
        this.dataHora = dataHora;
        this.nomeMedico = nomeMedico;
        this.anamnese = anamnese;
        this.exameFisico = exameFisico;
        this.examesComplementares = examesComplementares;
        this.hipotesesDiagnosticas = hipotesesDiagnosticas;
        this.diagnosticoDefinitivo = diagnosticoDefinitivo;
        this.tratamento = tratamento;
        this.pacienteId = pacienteId;
        this.medicoId = medicoId;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getAnamnese() {
        return anamnese;
    }

    public void setAnamnese(String anamnese) {
        this.anamnese = anamnese;
    }

    public String getExameFisico() {
        return exameFisico;
    }

    public void setExameFisico(String exameFisico) {
        this.exameFisico = exameFisico;
    }

    public String getExamesComplementares() {
        return examesComplementares;
    }

    public void setExamesComplementares(String examesComplementares) {
        this.examesComplementares = examesComplementares;
    }

    public String getHipotesesDiagnosticas() {
        return hipotesesDiagnosticas;
    }

    public void setHipotesesDiagnosticas(String hipotesesDiagnosticas) {
        this.hipotesesDiagnosticas = hipotesesDiagnosticas;
    }

    public String getDiagnosticoDefinitivo() {
        return diagnosticoDefinitivo;
    }

    public void setDiagnosticoDefinitivo(String diagnosticoDefinitivo) {
        this.diagnosticoDefinitivo = diagnosticoDefinitivo;
    }

    public String getTratamento() {
        return tratamento;
    }

    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }

    public int getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(int pacienteId) {
        this.pacienteId = pacienteId;
    }

    public int getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(int medicoId) {
        this.medicoId = medicoId;
    }
}

