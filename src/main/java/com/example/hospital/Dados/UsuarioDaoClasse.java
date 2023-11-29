package com.example.hospital.Dados;
import com.example.hospital.Modelo.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoClasse implements UsuarioDaoInterface{
    Connection connection;

    public UsuarioDaoClasse() throws ErroDao {
        connection = FabricaConexao.pegaConexao();
    }
    @Override
    public void inserirMedico(Medico medico) throws ErroDao {
        String sql = "insert into medico(nome,login,senha, especializacao) values (?,?,?,?)";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setString(1, medico.getNome());
            pstm.setString(2, medico.getLogin());
            pstm.setString(3, medico.getSenha());
            pstm.setString(4, medico.getEspecializacao());
            pstm.executeUpdate();
            ResultSet rs = pstm.getGeneratedKeys();
            if(rs.next())
            {
                medico.setId(rs.getInt(1));
            }
        }catch (SQLException e)
        {
            throw new ErroDao(e);
        }
    }

    public void inserirPaciente(Paciente paciente) throws ErroDao {
        String sql = "INSERT INTO paciente (nome, login, senha, data_nascimento, sexo, nome_mae, naturalidade_municipio, naturalidade_estado, endereco) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setString(1, paciente.getNome());
            pstm.setString(2, paciente.getLogin());
            pstm.setString(3, paciente.getSenha());
            pstm.setDate(4, Date.valueOf(paciente.getDataNascimento()));
            pstm.setString(5, paciente.getSexo());
            pstm.setString(6, paciente.getNomeMae());
            pstm.setString(7, paciente.getNaturalidadeMunicipio());
            pstm.setString(8, paciente.getNaturalidadeEstado());
            pstm.setString(9, paciente.getEndereco());

            pstm.executeUpdate();
            ResultSet rs = pstm.getGeneratedKeys();
            if (rs.next()) {
                paciente.setId(rs.getInt(1));

            }
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    public Medico validarMedico(String login, String senha) throws ErroDao {
        String sql="SELECT * FROM medico WHERE login=? AND senha=?";
        try(PreparedStatement pstm=connection.prepareStatement(sql)) {
            pstm.setString(1, login);
            pstm.setString(2, senha);
            ResultSet rs=pstm.executeQuery();
            if(rs.next())
            {
                Medico medico = new Medico();
                medico.setId(rs.getInt("id"));
                medico.setNome(rs.getString("nome"));
                medico.setLogin(rs.getString("login"));
                medico.setSenha(rs.getString("senha"));
                medico.setEspecializacao(rs.getString("especializacao"));
                return medico;
            }
            else
                return null;
        }catch (SQLException e)
        {
            throw new ErroDao(e);
        }
    }

    public Paciente validarPaciente(String login, String senha) throws ErroDao {
        String sql="SELECT * FROM paciente WHERE login=? AND senha=?";
        try(PreparedStatement pstm=connection.prepareStatement(sql)) {
            pstm.setString(1, login);
            pstm.setString(2, senha);
            ResultSet rs=pstm.executeQuery();
            if(rs.next())
            {
                Paciente paciente = new Paciente();
                paciente.setId(rs.getInt("id"));
                paciente.setNome(rs.getString("nome"));
                paciente.setLogin(rs.getString("login"));
                paciente.setSenha(rs.getString("senha"));
                paciente.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
                paciente.setSexo(rs.getString("sexo"));
                paciente.setNomeMae(rs.getString("nome_mae"));
                paciente.setNaturalidadeMunicipio(rs.getString("naturalidade_municipio"));
                paciente.setNaturalidadeEstado(rs.getString("naturalidade_estado"));
                paciente.setEndereco(rs.getString("endereco"));
                return paciente;
            }
            else
                return null;
        }catch (SQLException e)
        {
            throw new ErroDao(e);
        }
    }

    @Override
    public List<Paciente> buscar() throws ErroDao {
        String sql = "SELECT * FROM paciente";
        try(PreparedStatement pstm=connection.prepareStatement(sql)) {
            ResultSet rs=pstm.executeQuery();
            List<Paciente> pacientes=new ArrayList();
            while (rs.next())
            {
                Paciente paciente = new Paciente();
                paciente.setId(rs.getInt("id"));
                paciente.setNome(rs.getString("nome"));
                paciente.setLogin(rs.getString("login"));
                paciente.setSenha(rs.getString("senha"));
                paciente.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
                paciente.setSexo(rs.getString("sexo"));
                paciente.setNomeMae(rs.getString("nome_mae"));
                paciente.setNaturalidadeMunicipio(rs.getString("naturalidade_municipio"));
                paciente.setNaturalidadeEstado(rs.getString("naturalidade_estado"));
                paciente.setEndereco(rs.getString("endereco"));
                pacientes.add(paciente);
            }
            return pacientes;
        }catch (SQLException e)
        {
            throw new ErroDao(e);
        }
    }

    @Override
    public Paciente buscarPacientePorId(int pacienteId) throws ErroDao {
        String sql = "SELECT * FROM paciente WHERE id = ?";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, pacienteId);
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setId(rs.getInt("id"));
                paciente.setNome(rs.getString("nome"));
                paciente.setLogin(rs.getString("login"));
                paciente.setSenha(rs.getString("senha"));
                paciente.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
                paciente.setSexo(rs.getString("sexo"));
                paciente.setNomeMae(rs.getString("nome_mae"));
                paciente.setNaturalidadeMunicipio(rs.getString("naturalidade_municipio"));
                paciente.setNaturalidadeEstado(rs.getString("naturalidade_estado"));
                paciente.setEndereco(rs.getString("endereco"));
                return paciente;
            }
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
        return null;
    }

    @Override
    public void editarContaMedico(Medico medico) throws ErroDao {
        String sql = "UPDATE medico SET nome = ?, login = ?, senha = ?, especializacao = ? WHERE id = ?";
        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setString(1, medico.getNome());
            pstm.setString(2, medico.getLogin());
            pstm.setString(3, medico.getSenha());
            pstm.setString(4, medico.getEspecializacao());
            pstm.setInt(5, medico.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new ErroDao("Erro ao editar conta do médico: " + e.getMessage());
        }
    }

    @Override
    public void editarContaPacienteMedico(Paciente paciente) throws ErroDao {
        String sql = "UPDATE paciente SET nome = ?, login = ?, senha = ?, data_nascimento = ?, sexo = ?, nome_mae = ?, naturalidade_municipio = ?, naturalidade_estado = ?, endereco = ? WHERE id = ?";
        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setString(1, paciente.getNome());
            pstm.setString(2, paciente.getLogin());
            pstm.setString(3, paciente.getSenha());
            pstm.setString(4, String.valueOf(paciente.getDataNascimento()));
            pstm.setString(5, paciente.getSexo());
            pstm.setString(6, paciente.getNomeMae());
            pstm.setString(7, paciente.getNaturalidadeMunicipio());
            pstm.setString(8, paciente.getNaturalidadeEstado());
            pstm.setString(9, paciente.getEndereco());
            pstm.setInt(10, paciente.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new ErroDao("Erro ao editar conta do paciente: " + e.getMessage());
        }
    }

    @Override
    public void editarContaPaciente(Paciente paciente) throws ErroDao {
        String sql = "UPDATE paciente SET endereco = ?, senha = ? WHERE id = ?";
        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setString(1, paciente.getEndereco());
            pstm.setString(2, paciente.getSenha());
            pstm.setInt(3, paciente.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new ErroDao("Erro ao editar conta do paciente: " + e.getMessage());
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
