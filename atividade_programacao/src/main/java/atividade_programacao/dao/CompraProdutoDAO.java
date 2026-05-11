package atividade_programacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import atividade_programacao.model.Compra;
import atividade_programacao.model.CompraProduto;
import atividade_programacao.model.Produto;

public class CompraProdutoDAO {

    public boolean salvar(CompraProduto cp) {
        String sql = "INSERT INTO compra_produto (produto_id, compra_id, quantidade, preco_unit) VALUES (?, ?, ?, ?)";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, cp.getProduto().getId());
            stmt.setInt(2, cp.getCompra().getId());
            stmt.setInt(3, cp.getQuantidade());
            stmt.setDouble(4, cp.getPreco_unit());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(CompraProduto cp) {
        String sql = "UPDATE compra_produto SET produto_id = ?, compra_id = ?, quantidade = ?, preco_unit = ? WHERE id = ?";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, cp.getProduto().getId());
            stmt.setInt(2, cp.getCompra().getId());
            stmt.setInt(3, cp.getQuantidade());
            stmt.setDouble(4, cp.getPreco_unit());
            stmt.setInt(5, cp.getId());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluir(int id) {
        String sql = "DELETE FROM compra_produto WHERE id = ?";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public CompraProduto pesquisar(int id) {
        String sql = "SELECT id, produto_id, compra_id, quantidade, preco_unit FROM compra_produto WHERE id = ?";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    CompraProduto cp = new CompraProduto();
                    cp.setId(rs.getInt("id"));
                    cp.setQuantidade(rs.getInt("quantidade"));
                    cp.setPreco_unit(rs.getDouble("preco_unit"));
                    
                    Produto p = new Produto();
                    p.setId(rs.getInt("produto_id"));
                    cp.setProduto(p);
                    
                    Compra c = new Compra();
                    c.setId(rs.getInt("compra_id"));
                    cp.setCompra(c);
                    
                    return cp;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}