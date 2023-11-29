package com.example.hospital.Controle;

import com.example.hospital.Dados.AnamneseDaoClasse;
import com.example.hospital.Dados.AnamneseDaoInterface;
import com.example.hospital.Dados.ErroDao;
import com.example.hospital.Modelo.Anamnese;
import com.example.hospital.Modelo.Medico;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/processar_anamneses")
public class LerAnamneses extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String idParam = request.getParameter("id");
        String dataFiltro = request.getParameter("dataFiltro");
        HttpSession session = request.getSession();

        if (session.getAttribute("medico") != null) {
            if (idParam != null && !idParam.isEmpty()) {
                try {
                    int pacienteId = Integer.parseInt(idParam);
                    AnamneseDaoInterface daoAnamnese = new AnamneseDaoClasse();
                    List<Anamnese> anamneses = daoAnamnese.buscarAnamneses(pacienteId);
                    if (dataFiltro != null && !dataFiltro.isEmpty()) {
                        LocalDate data = LocalDate.parse(dataFiltro);
                        anamneses = anamneses.stream()
                                .filter(anamnese -> anamnese.getDataHora().toLocalDate().isEqual(data))
                                .collect(Collectors.toList());
                    }
                    request.setAttribute("anamneses", anamneses);
                    daoAnamnese.close();
                    request.getRequestDispatcher("anamneseReadMed.jsp").forward(request, response);
                } catch (NumberFormatException e) {
                    response.sendRedirect("homeMed.jsp?mensagem=ID do Paciente inválido!");
                } catch (ErroDao e) {
                    response.sendRedirect("homeMed.jsp?mensagem=" + e.getMessage());
                }
            } else {
                response.sendRedirect("homeMed.jsp?mensagem=ID do Paciente inexistente!");
            }
        } else if (session.getAttribute("paciente") != null) {
            if (idParam != null && !idParam.isEmpty()) {
                try {
                    int pacienteId = Integer.parseInt(idParam);
                    AnamneseDaoInterface daoAnamnese = new AnamneseDaoClasse();
                    List<Anamnese> anamneses = daoAnamnese.buscarAnamneses(pacienteId);
                    if (dataFiltro != null && !dataFiltro.isEmpty()) {
                        LocalDate data = LocalDate.parse(dataFiltro);
                        anamneses = anamneses.stream()
                                .filter(anamnese -> anamnese.getDataHora().toLocalDate().isEqual(data))
                                .collect(Collectors.toList());
                    }
                    request.setAttribute("anamneses", anamneses);
                    daoAnamnese.close();
                    request.getRequestDispatcher("homePac.jsp").forward(request, response);
                } catch (NumberFormatException e) {
                    response.sendRedirect("homePac.jsp?mensagem=ID do Paciente inválido!");
                } catch (ErroDao e) {
                    response.sendRedirect("index.jsp?mensagem=" + e.getMessage());
                }
            } else {
                response.sendRedirect("homePac.jsp?mensagem=ID do Paciente inexistente!");
            }
        } else {
            response.sendRedirect("index.jsp?mensagem=Acesso Negado!");
        }
    }
}
