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

@WebServlet("/processar_editar_conta_paciente")
public class EditarContaPaciente extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        HttpSession session = request.getSession();
        if (session.getAttribute("paciente") == null) {
            response.sendRedirect("index.jsp?mensagem=Acesso Negado!");
        } else {
            int pacienteId = Integer.parseInt(request.getParameter("id"));
            String endereco = request.getParameter("endereco");
            String senha = request.getParameter("senha");

            if (endereco != null && senha != null && !endereco.isEmpty() && !senha.isEmpty()) {
                Paciente paciente = new Paciente(pacienteId, senha, endereco);
                try {
                    UsuarioDaoInterface daoUsuario = new UsuarioDaoClasse();
                    daoUsuario.editarContaPaciente(paciente);
                    daoUsuario.close();
                    session.removeAttribute("paciente");
                    response.sendRedirect("index.jsp?mensagem=Conta editada com Sucesso! Logue-se Novamente!");
                } catch (ErroDao e) {
                    throw new RuntimeException(e);
                }
            } else {
                response.sendRedirect("contaEditPaciente.jsp?mensagem=Dados Incompletos!");
            }
        }
    }
}
