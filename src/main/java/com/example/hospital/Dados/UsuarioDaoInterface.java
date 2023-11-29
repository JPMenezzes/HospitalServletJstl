package com.example.hospital.Dados;
import com.example.hospital.Modelo.*;

import java.util.List;

public interface UsuarioDaoInterface {
    public void inserirMedico(Medico medico) throws ErroDao;
    public void inserirPaciente(Paciente paciente) throws ErroDao;
    public Medico validarMedico(String login, String senha) throws ErroDao;
    public Paciente validarPaciente(String login, String senha) throws ErroDao;
    public List<Paciente> buscar() throws ErroDao;
    public Paciente buscarPacientePorId(int pacienteId) throws ErroDao;
    public void editarContaMedico(Medico medico) throws ErroDao;
    public void editarContaPacienteMedico(Paciente paciente) throws  ErroDao;
    public void editarContaPaciente(Paciente paciente) throws ErroDao;
    public void close() throws ErroDao;
}
