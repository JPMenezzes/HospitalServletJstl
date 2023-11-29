package com.example.hospital.Controle;

import com.example.hospital.Dados.ErroDao;
import com.example.hospital.Dados.UsuarioDaoClasse;
import com.example.hospital.Dados.UsuarioDaoInterface;
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

@WebServlet("/processar_editar_conta_paciente_med")
public class EditarContaPacienteMedico extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        HttpSession session = request.getSession();
        if (session.getAttribute("medico") == null) {
            response.sendRedirect("index.jsp?mensagem=Acesso Negado!");
        } else {
            int pacienteId = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            String dataNascimento = request.getParameter("dataNascimento");
            String sexo = request.getParameter("sexo");
            String nomeMae = request.getParameter("nomeMae");
            String naturalidadeMunicipio = request.getParameter("naturalidadeMunicipio");
            String naturalidadeEstado = request.getParameter("naturalidadeEstado");
            String endereco = request.getParameter("endereco");

            if (nome != null && senha != null && dataNascimento != null && sexo != null && nomeMae != null &&
                    naturalidadeMunicipio != null && naturalidadeEstado != null && endereco != null &&
                    !nome.isEmpty() && !senha.isEmpty() && !dataNascimento.isEmpty() && !sexo.isEmpty() &&
                    !nomeMae.isEmpty() && !naturalidadeMunicipio.isEmpty() && !naturalidadeEstado.isEmpty() &&
                    !endereco.isEmpty()) {
                Paciente paciente = new Paciente(pacienteId, nome, login, senha, LocalDate.parse(dataNascimento), sexo, nomeMae,
                        naturalidadeMunicipio, naturalidadeEstado, endereco);
                try {
                    UsuarioDaoInterface daoUsuario = new UsuarioDaoClasse();
                    daoUsuario.editarContaPacienteMedico(paciente);
                    List<Paciente> pacientes = daoUsuario.buscar();
                    session.removeAttribute("pacientes");
                    session.setAttribute("pacientes", pacientes);
                    daoUsuario.close();
                    response.sendRedirect("homeMed.jsp?mensagem=Conta do Paciente editada com Sucesso!");
                } catch (ErroDao e) {
                    throw new RuntimeException(e);
                }
            } else {
                response.sendRedirect("editarContaPacienteMedico.jsp?mensagem=Dados Incompletos!");
            }
        }
    }
}
