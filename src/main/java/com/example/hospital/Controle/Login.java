package com.example.hospital.Controle;

import com.example.hospital.Dados.*;
import com.example.hospital.Modelo.Anamnese;
import com.example.hospital.Modelo.Medico;
import com.example.hospital.Modelo.Paciente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/processar_login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        HttpSession session = request.getSession();

        if (login != null && senha != null && login.length() > 0 && senha.length() > 0) {
            if (session.getAttribute("medico") == null && session.getAttribute("paciente") == null) {
                try {
                    UsuarioDaoInterface daoUsuario = new UsuarioDaoClasse();
                    Medico medico = daoUsuario.validarMedico(login, senha);

                    if (medico != null) {
                        session.setAttribute("medico", medico);
                        List<Paciente> pacientes = daoUsuario.buscar();
                        session.setAttribute("pacientes", pacientes);
                        daoUsuario.close();
                        response.sendRedirect("homeMed.jsp");
                    } else {
                        Paciente paciente = daoUsuario.validarPaciente(login, senha);
                        daoUsuario.close();

                        if (paciente != null) {
                            session.setAttribute("paciente", paciente);
                            AnamneseDaoInterface daoAnamnese = new AnamneseDaoClasse();
                            List<Anamnese> anamneses = daoAnamnese.buscarAnamneses(paciente.getId());
                            daoAnamnese.close();
                            session.setAttribute("anamneses", anamneses);
                            /*request.getRequestDispatcher("homePac.jsp").forward(request, response);*/
                            response.sendRedirect("homePac.jsp");
                        } else {
                            response.sendRedirect("index.jsp?mensagem=Login ou senha incorretos");
                        }
                    }
                } catch (ErroDao e) {
                    response.sendRedirect("index.jsp?mensagem=Erro ao tentar logar" + e);
                }
            } else {
                response.sendRedirect("index.jsp?mensagem=Você já estava logado! Sua sessão foi invalidada, logue-se novamente");
                session.removeAttribute("medico");
                session.removeAttribute("paciente");
            }
        } else {
            response.sendRedirect("index.jsp?mensagem=Dados incompletos");
        }
    }

}
