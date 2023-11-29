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
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/processar_pacientes")
public class LerPacientes extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Medico medico = (Medico) session.getAttribute("medico");

        if (medico != null) {
            session.setAttribute("medico", medico);
            String nomePaciente = request.getParameter("nomePaciente");

            try {
                UsuarioDaoInterface daoUsuario = new UsuarioDaoClasse();
                List<Paciente> pacientes = daoUsuario.buscar();

                if (nomePaciente != null && !nomePaciente.isEmpty()) {
                    pacientes = pacientes.stream()
                            .filter(paciente -> paciente.getNome().contains(nomePaciente))
                            .collect(Collectors.toList());
                }

                session.setAttribute("pacientes", pacientes);
                daoUsuario.close();
                request.getRequestDispatcher("homeMed.jsp").forward(request, response);
            } catch (ErroDao e) {
                response.sendRedirect("homeMed.jsp?=" + e);
            }
        } else {
            response.sendRedirect("index.jsp?mensagem=Acesso Negado!");
        }
    }
}
