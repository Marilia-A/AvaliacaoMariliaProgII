package atividade_programacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import atividade_programacao.model.Categoria;
import atividade_programacao.model.Produto;

public class ProdutoDAO {

    public boolean salvar(Produto produto) {
        String sql = "INSERT INTO produto (nome, preco_medio, qtde_estoque, valor_ultima_compra, valor_ultima_venda, categoria_id) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco_medio());
            stmt.setDouble(3, produto.getQtd_estoque());
            stmt.setDouble(4, produto.getValor_ultima_compra());
            stmt.setDouble(5, produto.getValor_ultima_venda());
            stmt.setInt(6, produto.getCategoria().getId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(Produto produto) {
        String sql = "UPDATE produto SET nome = ?, preco_medio = ?, qtde_estoque = ?, valor_ultima_compra = ?, valor_ultima_venda = ?, categoria_id = ? WHERE id = ?";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco_medio());
            stmt.setDouble(3, produto.getQtd_estoque());
            stmt.setDouble(4, produto.getValor_ultima_compra());
            stmt.setDouble(5, produto.getValor_ultima_venda());
            stmt.setInt(6, produto.getCategoria().getId());
            stmt.setInt(7, produto.getId());

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

    public Produto pesquisar(int id) {
        String sql = "SELECT p.id, p.nome, p.preco_medio, p.qtde_estoque, p.valor_ultima_compra, p.valor_ultima_venda, c.id AS categoria_id, c.nome AS categoria_nome " +
                     "FROM produto p INNER JOIN categoria c ON p.categoria_id = c.id WHERE p.id = ?";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Categoria categoria = new Categoria();
                    categoria.setId(rs.getInt("categoria_id"));
                    categoria.setNome(rs.getString("categoria_nome"));

                    Produto produto = new Produto();
                    produto.setId(rs.getInt("id"));
                    produto.setNome(rs.getString("nome"));
                    produto.setPreco_medio(rs.getDouble("preco_medio"));
                    produto.setQtd_estoque(rs.getDouble("qtde_estoque"));
                    produto.setValor_ultima_compra(rs.getDouble("valor_ultima_compra"));
                    produto.setValor_ultima_venda(rs.getDouble("valor_ultima_venda"));
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