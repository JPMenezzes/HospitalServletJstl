package com.example.hospital.Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Paciente {
    private int id;
    private String nome, login, senha;
    private LocalDate dataNascimento;
    private String sexo;
    private String nomeMae;
    private String naturalidadeMunicipio;
    private String naturalidadeEstado;
    private String endereco;
    private List<Anamnese> anamneses;

    // getters e setters
    public Paciente() {this.anamneses = new ArrayList<>();}

    public Paciente(String nome, String login, String senha, LocalDate dataNascimento, String sexo, String nomeMae,
                    String naturalidadeMunicipio, String naturalidadeEstado, String endereco, List<Anamnese> anamneses) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.nomeMae = nomeMae;
        this.naturalidadeMunicipio = naturalidadeMunicipio;
        this.naturalidadeEstado = naturalidadeEstado;
        this.endereco = endereco;
        this.anamneses = new ArrayList<>();
    }

    public Paciente(String nome, String login, String senha, LocalDate dataNascimento, String sexo, String nomeMae, String naturalidadeMunicipio, String naturalidadeEstado, String endereco) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.nomeMae = nomeMae;
        this.naturalidadeMunicipio = naturalidadeMunicipio;
        this.naturalidadeEstado = naturalidadeEstado;
        this.endereco = endereco;
    }

    public Paciente(int id, String nome, String login, String senha, LocalDate dataNascimento, String sexo, String nomeMae, String naturalidadeMunicipio, String naturalidadeEstado, String endereco) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.nomeMae = nomeMae;
        this.naturalidadeMunicipio = naturalidadeMunicipio;
        this.naturalidadeEstado = naturalidadeEstado;
        this.endereco = endereco;
    }

    public Paciente(int id, String senha, String endereco) {
        this.id = id;
        this.senha = senha;
        this.endereco = endereco;
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNaturalidadeMunicipio() {
        return naturalidadeMunicipio;
    }

    public void setNaturalidadeMunicipio(String naturalidadeMunicipio) {
        this.naturalidadeMunicipio = naturalidadeMunicipio;
    }

    public String getNaturalidadeEstado() {
        return naturalidadeEstado;
    }

    public void setNaturalidadeEstado(String naturalidadeEstado) {
        this.naturalidadeEstado = naturalidadeEstado;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Anamnese> getAnamneses() {
        return anamneses;
    }

    public void setAnamneses(List<Anamnese> anamneses) {
        this.anamneses = anamneses;
    }
}

