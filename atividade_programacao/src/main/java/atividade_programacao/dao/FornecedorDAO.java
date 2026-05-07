package atividade_programacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import atividade_programacao.model.FornecedorModel;

public class FornecedorDAO {

    public boolean salvar(FornecedorModel fornecedor) {
        String sql = "INSERT INTO fornecedor (id, nome_fantasia, razao_social, cnpj) VALUES (?, ?, ?, ?)";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, fornecedor.getId());
            stmt.setString(2, fornecedor.getNome_fantasia());
            stmt.setString(3, fornecedor.getRazao_social());
            stmt.setString(4, fornecedor.getCnpj());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(FornecedorModel fornecedor) {
        String sql = "UPDATE fornecedor SET nome_fantasia = ?, razao_social = ?, cnpj = ? WHERE id = ?";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, fornecedor.getNome_fantasia());
            stmt.setString(2, fornecedor.getRazao_social());
            stmt.setString(3, fornecedor.getCnpj());
            stmt.setInt(4, fornecedor.getId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluir(int id) {
        String sql = "DELETE FROM fornecedor WHERE id = ?";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public FornecedorModel pesquisar(int id) {
        String sql = "SELECT id, nome_fantasia, razao_social, cnpj FROM fornecedor WHERE id = ?";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    FornecedorModel fornecedor = new FornecedorModel();
                    fornecedor.setId(rs.getInt("id"));
                    fornecedor.setNome_fantasia(rs.getString("nome_fantasia"));
                    fornecedor.setRazao_social(rs.getString("razao_social"));
                    fornecedor.setCnpj(rs.getString("cnpj"));
                    return fornecedor;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}