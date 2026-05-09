package atividade_programacao.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import atividade_programacao.model.Compra;
import atividade_programacao.model.Fornecedor;

public class CompraDAO {

    public boolean salvar(Compra compra) {
        String sql = "INSERT INTO compra (id, data_compra, valor_total, fornecedor_id) VALUES (?, ?, ?, ?)";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, compra.getId());
            // Converte LocalDate para java.sql.Date
            stmt.setDate(2, Date.valueOf(compra.getData_compra()));
            stmt.setDouble(3, compra.getValor_total());
            stmt.setInt(4, compra.getFornecedor().getId());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(Compra compra) {
        String sql = "UPDATE compra SET data_compra = ?, valor_total = ?, fornecedor_id = ? WHERE id = ?";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setDate(1, Date.valueOf(compra.getData_compra()));
            stmt.setDouble(2, compra.getValor_total());
            stmt.setInt(3, compra.getFornecedor().getId());
            stmt.setInt(4, compra.getId());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluir(int id) {
        String sql = "DELETE FROM compra WHERE id = ?";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Compra pesquisar(int id) {
        String sql = "SELECT id, data_compra, valor_total, fornecedor_id FROM compra WHERE id = ?";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Compra compra = new Compra();
                    compra.setId(rs.getInt("id"));
                    // Converte java.sql.Date de volta para LocalDate
                    compra.setData_compra(rs.getDate("data_compra").toLocalDate());
                    compra.setValor_total(rs.getDouble("valor_total"));
                    
                    // Cria um fornecedor "raso" apenas com o ID para preencher o objeto
                    Fornecedor f = new Fornecedor();
                    f.setId(rs.getInt("fornecedor_id"));
                    compra.setFornecedor(f);
                    
                    return compra;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}