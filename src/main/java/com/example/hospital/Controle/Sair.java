package com.example.hospital.Controle;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/sair")
public class Sair extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        HttpSession session = request.getSession();
        if(session.getAttribute("medico") != null || session.getAttribute("paciente")!= null){
            session.removeAttribute("medico");
            session.removeAttribute("paciente");
        }
        response.sendRedirect("index.jsp?mensagem=Deslogado!");
    }
}
