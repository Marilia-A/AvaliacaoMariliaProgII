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
        String sql = "INSERT INTO compra_produto (id_item, produto_id, compra_id, quantidade, preco_unitario) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, cp.getId_item());
            stmt.setInt(2, cp.getProduto().getId());
            stmt.setInt(3, cp.getCompra().getId());
            stmt.setInt(4, cp.getQuantidade());
            stmt.setDouble(5, cp.getPreco_unitario());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(CompraProduto cp) {
        String sql = "UPDATE compra_produto SET produto_id = ?, compra_id = ?, quantidade = ?, preco_unitario = ? WHERE id_item = ?";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, cp.getProduto().getId());
            stmt.setInt(2, cp.getCompra().getId());
            stmt.setInt(3, cp.getQuantidade());
            stmt.setDouble(4, cp.getPreco_unitario());
            stmt.setInt(5, cp.getId_item());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluir(int id_item) {
        String sql = "DELETE FROM compra_produto WHERE id_item = ?";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id_item);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public CompraProduto pesquisar(int id_item) {
        String sql = "SELECT id_item, produto_id, compra_id, quantidade, preco_unitario FROM compra_produto WHERE id_item = ?";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id_item);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    CompraProduto cp = new CompraProduto();
                    cp.setId_item(rs.getInt("id_item"));
                    cp.setQuantidade(rs.getInt("quantidade"));
                    cp.setPreco_unitario(rs.getDouble("preco_unitario"));
                    
                    // Populando Produto com ID
                    Produto p = new Produto();
                    p.setId(rs.getInt("produto_id"));
                    cp.setProduto(p);
                    
                    // Populando Compra com ID
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