package com.example.hospital.Controle;

import com.example.hospital.Dados.ErroDao;
import com.example.hospital.Dados.UsuarioDaoClasse;
import com.example.hospital.Dados.UsuarioDaoInterface;
import com.example.hospital.Modelo.Medico;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/processar_editar_conta_med")
public class EditarContaMedico extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        HttpSession session = request.getSession();
        if (session.getAttribute("medico") == null) {
            response.sendRedirect("index.jsp?mensagem=Acesso Negado!");
        } else {
            int medicoId = Integer.parseInt(request.getParameter("id"));
            String login = request.getParameter("login");
            String nome = request.getParameter("nome");
            String senha = request.getParameter("senha");
            String especializacao = request.getParameter("especializacao");

            if (nome != null && senha != null && especializacao != null &&
                    !nome.isEmpty() && !senha.isEmpty() && !especializacao.isEmpty()) {
                Medico medico = new Medico(medicoId, nome, login, senha, especializacao);
                try {
                    UsuarioDaoInterface daoInterface = new UsuarioDaoClasse();
                    daoInterface.editarContaMedico(medico);
                    daoInterface.close();
                    session.removeAttribute("medico");
                    response.sendRedirect("index.jsp?mensagem=Conta editada com Sucesso! Logue-se Novamente!");
                } catch (ErroDao e) {
                    throw new RuntimeException(e);
                }
            } else {
                response.sendRedirect("contaEditMed.jsp?mensagem=Dados Incompletos!");
            }
        }
    }
}
