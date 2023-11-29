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
import java.time.LocalDateTime;

@WebServlet("/processar_anamnese")
public class CriarAnamnese extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        LocalDateTime dataHoraAtual = LocalDateTime.now();
        String nomeMedico = request.getParameter("medicoResponsavel");
        String anamnese = request.getParameter("anamnese");
        String exameFisico = request.getParameter("exameFisico");
        String examesComplementares = request.getParameter("examesComplementares");
        String hipotesesDiagnosticas = request.getParameter("hipotesesDiagnosticas");
        String diagnosticoDefinitivo = request.getParameter("diagnosticoDefinitivo");
        String tratamento = request.getParameter("tratamentoEfetuado");
        String pacienteId = request.getParameter("pacienteId");
        String medicoId = request.getParameter("medicoId");

        if (anamnese == null || exameFisico == null || examesComplementares == null ||
                hipotesesDiagnosticas == null || diagnosticoDefinitivo == null || tratamento == null ||
                pacienteId == null || medicoId == null) {
            response.sendRedirect("anamneseCreate.jsp?mensagem=Dados incompletos!");
            return;
        }

        HttpSession session = request.getSession();
        Medico medico = (Medico) session.getAttribute("medico");
        if (medico == null) {
            response.sendRedirect("index.jsp?mensagem=Acesso Negado!");
            return;
        }

        Anamnese anamneseObj = new Anamnese(dataHoraAtual, nomeMedico, anamnese, exameFisico, examesComplementares,
                hipotesesDiagnosticas, diagnosticoDefinitivo, tratamento, Integer.parseInt(pacienteId), medico.getId());

        try {
            AnamneseDaoInterface anamneseDao = new AnamneseDaoClasse();
            anamneseDao.inserirAnamnese(anamneseObj);
            anamneseDao.close();
            response.sendRedirect("homeMed.jsp?mensagem=Anamnese criada com Sucesso!");
        } catch (ErroDao e) {
            response.sendRedirect("anamneseCreate.jsp?mensagem=" + e);
        }
    }
}
