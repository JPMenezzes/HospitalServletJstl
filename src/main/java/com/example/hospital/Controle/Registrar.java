package com.example.hospital.Controle;

import com.example.hospital.Dados.ErroDao;
import com.example.hospital.Dados.UsuarioDaoClasse;
import com.example.hospital.Dados.UsuarioDaoInterface;
import com.example.hospital.Modelo.Medico;
import com.example.hospital.Modelo.Paciente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/processar_register")
public class Registrar extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        String tipoConta = request.getParameter("tipoConta");
        String login = request.getParameter("login");
        String senha = request.getParameter("password");
        if (login != null && login.length() > 0 && senha != null && senha.length() > 0) {
            if (tipoConta.equals("medico")) {
                String nomeMedico = request.getParameter("nomeMedico");
                String especializacao = request.getParameter("especializacao");
                if (nomeMedico != null && especializacao != null &&
                        !nomeMedico.isEmpty() && !especializacao.isEmpty()) {
                    Medico medico = new Medico(nomeMedico, login, senha, especializacao);
                    try {
                        UsuarioDaoInterface daoUsuario = new UsuarioDaoClasse();
                        daoUsuario.inserirMedico(medico);
                        int idMedico = medico.getId();
                        daoUsuario.close();
                        response.sendRedirect("homeMed.jsp?mensagem=Medico cadastrado com sucesso! O id Medico gerado foi = " + idMedico);
                    } catch (ErroDao e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    response.sendRedirect("homeMed.jsp?mensagem=Dados incompletos!");
                }
            } else if (tipoConta.equals("paciente")) {
                String nomePaciente = request.getParameter("nomePaciente");
                String dataNascimentoPaciente = request.getParameter("dataNascimentoPaciente");
                String sexoPaciente = request.getParameter("sexoPaciente");
                String nomeMae = request.getParameter("nomeMaePaciente");
                String naturalidadeMunicipio = request.getParameter("naturalidadeMunicipioPaciente");
                String naturalidadeEstado = request.getParameter("naturalidadeEstadoPaciente");
                String endereco = request.getParameter("enderecoPaciente");
                if (nomePaciente != null && dataNascimentoPaciente != null && sexoPaciente != null &&
                        nomeMae != null && naturalidadeMunicipio != null && naturalidadeEstado != null &&
                        endereco != null && !nomePaciente.isEmpty() && !dataNascimentoPaciente.isEmpty() &&
                        !sexoPaciente.isEmpty() && !nomeMae.isEmpty() && !naturalidadeMunicipio.isEmpty() &&
                        !naturalidadeEstado.isEmpty() && !endereco.isEmpty()) {
                    Paciente paciente = new Paciente(nomePaciente, login, senha, LocalDate.parse(dataNascimentoPaciente),
                            sexoPaciente, nomeMae, naturalidadeMunicipio, naturalidadeEstado, endereco);
                    try {
                        UsuarioDaoInterface daoInterface = new UsuarioDaoClasse();
                        daoInterface.inserirPaciente(paciente);
                        int idPaciente = paciente.getId();
                        List<Paciente> pacientes = daoInterface.buscar();
                        session.setAttribute("pacientes", pacientes);
                        daoInterface.close();
                        response.sendRedirect("homeMed.jsp?mensagem=Paciente cadastrado com sucesso! O id Paciente gerado foi = " + idPaciente);
                    } catch (ErroDao e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    response.sendRedirect("homeMed.jsp?mensagem=Dados incompletos!");
                }
            }
        } else {
            response.sendRedirect("homeMed.jsp?mensagem=Dados incompletos!");
        }
    }
}
