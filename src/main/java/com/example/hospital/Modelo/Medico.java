package com.example.hospital.Modelo;

import java.util.ArrayList;
import java.util.List;

public class Medico {
    private int id;
    private String nome, login, senha;
    private String especializacao;
    private List<Anamnese> anamneses;
    private List<Paciente> pacientes;

    // getters e setters

    public Medico() {this.anamneses = new ArrayList<>();}

    public Medico(int id, String nome, String login, String senha, String especializacao) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.especializacao = especializacao;
    }

    public Medico(String nome, String login, String senha, String especializacao) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.especializacao = especializacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public List<Anamnese> getAnamneses() {
        return anamneses;
    }

    public void setAnamneses(List<Anamnese> anamneses) {
        this.anamneses = anamneses;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
}

