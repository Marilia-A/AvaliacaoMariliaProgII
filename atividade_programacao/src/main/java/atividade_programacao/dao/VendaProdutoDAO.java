package atividade_programacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import atividade_programacao.model.Produto;
import atividade_programacao.model.Venda;
import atividade_programacao.model.VendaProduto;

public class VendaProdutoDAO {

    public boolean salvar(VendaProduto vp) {
        String sql = "INSERT INTO venda_produto (quantidade, preco_unit, venda_id, produto_id) VALUES (?, ?, ?, ?)";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, vp.getQuantidade());
            stmt.setDouble(2, vp.getPreco_unitario());
            stmt.setInt(3, vp.getVenda().getId());
            stmt.setInt(4, vp.getProduto().getId());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(VendaProduto vp) {
        String sql = "UPDATE venda_produto SET quantidade = ?, preco_unit = ?, venda_id = ?, produto_id = ? WHERE id = ?";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, vp.getQuantidade());
            stmt.setDouble(2, vp.getPreco_unitario());
            stmt.setInt(3, vp.getVenda().getId());
            stmt.setInt(4, vp.getProduto().getId());
            stmt.setInt(5, vp.getId());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluir(int id) {
        String sql = "DELETE FROM venda_produto WHERE id = ?";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public VendaProduto pesquisar(int id) {
        String sql = "SELECT id, quantidade, preco_unit, venda_id, produto_id FROM venda_produto WHERE id = ?";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    VendaProduto vp = new VendaProduto();
                    vp.setId(rs.getInt("id"));
                    vp.setQuantidade(rs.getInt("quantidade"));
                    vp.setPreco_unitario(rs.getDouble("preco_unit"));
                    
                    Venda v = new Venda();
                    v.setId(rs.getInt("venda_id"));
                    vp.setVenda(v);
                    
                    Produto p = new Produto();
                    p.setId(rs.getInt("produto_id"));
                    vp.setProduto(p);
                    
                    return vp;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}