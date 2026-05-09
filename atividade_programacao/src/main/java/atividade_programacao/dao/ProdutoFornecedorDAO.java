package atividade_programacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import atividade_programacao.model.Fornecedor;
import atividade_programacao.model.Produto;
import atividade_programacao.model.ProdutoFornecedor;

public class ProdutoFornecedorDAO {

    public boolean salvar(ProdutoFornecedor pf) {
        String sql = "INSERT INTO produto_fornecedor (id, fornecedor_id, produto_id) VALUES (?, ?, ?)";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, pf.getId());
            stmt.setInt(2, pf.getFornecedor().getId());
            stmt.setInt(3, pf.getProduto().getId());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(ProdutoFornecedor pf) {
        String sql = "UPDATE produto_fornecedor SET fornecedor_id = ?, produto_id = ? WHERE id = ?";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, pf.getFornecedor().getId());
            stmt.setInt(2, pf.getProduto().getId());
            stmt.setInt(3, pf.getId());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluir(int id) {
        String sql = "DELETE FROM produto_fornecedor WHERE id = ?";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ProdutoFornecedor pesquisar(int id) {
        String sql = "SELECT id, fornecedor_id, produto_id FROM produto_fornecedor WHERE id = ?";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    ProdutoFornecedor pf = new ProdutoFornecedor();
                    pf.setId(rs.getInt("id"));
                    
                    // Objeto Fornecedor apenas com ID
                    Fornecedor f = new Fornecedor();
                    f.setId(rs.getInt("fornecedor_id"));
                    pf.setFornecedor(f);
                    
                    // Objeto Produto apenas com ID
                    Produto p = new Produto();
                    p.setId(rs.getInt("produto_id"));
                    pf.setProduto(p);
                    
                    return pf;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}