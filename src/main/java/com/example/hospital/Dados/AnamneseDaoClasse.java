package com.example.hospital.Dados;

import com.example.hospital.Modelo.Anamnese;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AnamneseDaoClasse implements AnamneseDaoInterface{
    Connection connection;

    public AnamneseDaoClasse() throws ErroDao {
        connection = FabricaConexao.pegaConexao();
    }

    public void inserirAnamnese(Anamnese anamnese) throws ErroDao {
        String sql = "INSERT INTO anamnese (data_hora, nomeMedico, anamnese, exame_fisico, exames_complementares, hipoteses_diagnosticas, diagnostico_definitivo, tratamento, paciente_id, medico_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setTimestamp(1, Timestamp.valueOf(anamnese.getDataHora()));
            pstm.setString(2, anamnese.getNomeMedico());
            pstm.setString(3, anamnese.getAnamnese());
            pstm.setString(4, anamnese.getExameFisico());
            pstm.setString(5, anamnese.getExamesComplementares());
            pstm.setString(6, anamnese.getHipotesesDiagnosticas());
            pstm.setString(7, anamnese.getDiagnosticoDefinitivo());
            pstm.setString(8, anamnese.getTratamento());
            pstm.setInt(9, anamnese.getPacienteId());
            pstm.setInt(10, anamnese.getMedicoId());
            pstm.executeUpdate();

            ResultSet rs = pstm.getGeneratedKeys();
            if (rs.next()) {
                anamnese.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            throw new ErroDao("Erro ao inserir a anamnese no banco de dados." + e.getMessage());
        }
    }

    @Override
    public List<Anamnese> buscarAnamneses(int idPaciente) throws ErroDao {
        String sql = "SELECT * FROM anamnese WHERE paciente_id = ?";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1, idPaciente);
            ResultSet rs = pstm.executeQuery();
            List<Anamnese> anamneses = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                LocalDateTime dataHora = rs.getTimestamp("data_hora").toLocalDateTime();
                String nomeMedico = rs.getString("nomeMedico");
                String anamnese = rs.getString("anamnese");
                String exameFisico = rs.getString("exame_fisico");
                String examesComplementares = rs.getString("exames_complementares");
                String hipotesesDiagnosticas = rs.getString("hipoteses_diagnosticas");
                String diagnosticoDefinitivo = rs.getString("diagnostico_definitivo");
                String tratamento = rs.getString("tratamento");
                int pacienteId = rs.getInt("paciente_id");
                int medicoId = rs.getInt("medico_id");

                Anamnese anamneseObj = new Anamnese(id, dataHora, nomeMedico, anamnese, exameFisico, examesComplementares,
                        hipotesesDiagnosticas, diagnosticoDefinitivo, tratamento, pacienteId, medicoId);
                anamneses.add(anamneseObj);
            }
            return anamneses;
        } catch (SQLException e) {
            throw new ErroDao("Erro ao buscar as anamneses do paciente" + e);
        }
    }

    @Override
    public void close() throws ErroDao {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }
}
