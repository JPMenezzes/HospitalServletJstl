package com.example.hospital.Dados;

import com.example.hospital.Modelo.Anamnese;

import java.util.List;

public interface AnamneseDaoInterface {
    public void inserirAnamnese(Anamnese anamnese) throws ErroDao;
    public List<Anamnese> buscarAnamneses(int idPaciente) throws ErroDao;

    /*public List<Anamnese> buscarMedico(Usuario medico) throws ErroDao;
    public List<Anamnese> buscarPaciente(Usuario paciente) throws ErroDao;*/
    public void close() throws ErroDao;
}
