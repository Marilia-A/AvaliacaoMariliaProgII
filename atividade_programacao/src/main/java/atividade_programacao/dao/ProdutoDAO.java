package atividade_programacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import atividade_programacao.model.CategoriaModel;
import atividade_programacao.model.ProdutoModel;

public class ProdutoDAO {

    public boolean salvar(ProdutoModel produto) {
        String sql = "INSERT INTO produto (id, nome, preco, qtd_estoque, categoria_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, produto.getId());
            stmt.setString(2, produto.getNome());
            stmt.setDouble(3, produto.getPreco());
            stmt.setDouble(4, produto.getQtd_estoque());
            stmt.setInt(5, produto.getCategoria().getId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(ProdutoModel produto) {
        String sql = "UPDATE produto SET nome = ?, preco = ?, qtd_estoque = ?, categoria_id = ? WHERE id = ?";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setDouble(3, produto.getQtd_estoque());
            stmt.setInt(4, produto.getCategoria().getId());
            stmt.setInt(5, produto.getId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluir(int id) {
        String sql = "DELETE FROM produto WHERE id = ?";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ProdutoModel pesquisar(int id) {
        String sql = "SELECT p.id, p.nome, p.preco, p.qtd_estoque, c.id AS categoria_id, c.nome AS categoria_nome " +
                     "FROM produto p INNER JOIN categoria c ON p.categoria_id = c.id WHERE p.id = ?";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    CategoriaModel categoria = new CategoriaModel();
                    categoria.setId(rs.getInt("categoria_id"));
                    categoria.setNome(rs.getString("categoria_nome"));

                    ProdutoModel produto = new ProdutoModel();
                    produto.setId(rs.getInt("id"));
                    produto.setNome(rs.getString("nome"));
                    produto.setPreco(rs.getDouble("preco"));
                    produto.setQtd_estoque(rs.getDouble("qtd_estoque"));
                    produto.setCategoria(categoria);
                    return produto;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}