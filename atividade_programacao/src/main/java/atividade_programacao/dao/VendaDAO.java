package atividade_programacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import atividade_programacao.model.Cliente;
import atividade_programacao.model.Produto;
import atividade_programacao.model.Venda;

public class VendaDAO {

    public boolean salvar(Venda venda) {
        String sqlVenda = "INSERT INTO venda (id, valor_total, data_venda, produto_id, cliente_id) VALUES (?, ?, ?, ?, ?)";
        String sqlEstoque = "UPDATE produto SET qtd_estoque = qtd_estoque - ? WHERE id = ? AND qtd_estoque >= ?";
        String sqlVerificaEstoque = "SELECT qtd_estoque FROM produto WHERE id = ?";

        try (Connection con = Conexao.getConnection()) {
            con.setAutoCommit(false);

            // Verifica estoque
            try (PreparedStatement psEstoqueCheck = con.prepareStatement(sqlVerificaEstoque)) {
                psEstoqueCheck.setInt(1, venda.getProduto().getId());

                try (ResultSet rs = psEstoqueCheck.executeQuery()) {
                    if (rs.next()) {
                        double estoqueAtual = rs.getDouble("qtd_estoque");
                        if (estoqueAtual < 1) {
                            con.rollback();
                            return false;
                        }
                    } else {
                        con.rollback();
                        return false;
                    }
                }
            }

            // Insere venda (COM ID MANUAL)
            try (PreparedStatement stmtVenda = con.prepareStatement(sqlVenda)) {
                stmtVenda.setInt(1, venda.getId());
                stmtVenda.setDouble(2, venda.getValor_total());
                stmtVenda.setDate(3, new java.sql.Date(venda.getData_venda().getTime()));
                stmtVenda.setInt(4, venda.getProduto().getId());
                stmtVenda.setInt(5, venda.getCliente().getId());

                if (stmtVenda.executeUpdate() <= 0) {
                    con.rollback();
                    return false;
                }
            }

            // Atualiza estoque
            try (PreparedStatement stmtEstoque = con.prepareStatement(sqlEstoque)) {
                stmtEstoque.setDouble(1, 1);
                stmtEstoque.setInt(2, venda.getProduto().getId());
                stmtEstoque.setDouble(3, 1);

                if (stmtEstoque.executeUpdate() <= 0) {
                    con.rollback();
                    return false;
                }
            }

            con.commit();
            return true;

        } catch (SQLException e) { 
            e.printStackTrace();
            return false;
        }
    }

    public int contarVendasPorCliente(int clienteId) {
        String sql = "SELECT COUNT(*) FROM venda WHERE cliente_id = ?";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, clienteId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public boolean alterar(Venda venda) {
        String sql = "UPDATE venda SET valor_total = ?, data_venda = ?, produto_id = ?, cliente_id = ? WHERE id = ?";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setDouble(1, venda.getValor_total());
            stmt.setDate(2, new java.sql.Date(venda.getData_venda().getTime()));
            stmt.setInt(3, venda.getProduto().getId());
            stmt.setInt(4, venda.getCliente().getId());
            stmt.setInt(5, venda.getId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluir(int id) {
        String sql = "DELETE FROM venda WHERE id = ?";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Venda pesquisar(int id) {
        String sql = "SELECT v.id, v.valor_total, v.data_venda, " +
                "p.id AS produto_id, p.nome AS produto_nome, p.preco, p.qtd_estoque, " +
                "c.id AS cliente_id, c.nome AS cliente_nome, c.cpf, c.rg, c.endereco, c.telefone " +
                "FROM venda v " +
                "INNER JOIN produto p ON v.produto_id = p.id " +
                "INNER JOIN cliente c ON v.cliente_id = c.id " +
                "WHERE v.id = ?";

        try (Connection con = Conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Produto produto = new Produto();
                    produto.setId(rs.getInt("produto_id"));
                    produto.setNome(rs.getString("produto_nome"));
                    produto.setPreco(rs.getDouble("preco"));
                    produto.setQtd_estoque(rs.getDouble("qtd_estoque"));

                    Cliente cliente = new Cliente();
                    cliente.setId(rs.getInt("cliente_id"));
                    cliente.setNome(rs.getString("cliente_nome"));
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setRg(rs.getString("rg"));
                    cliente.setEndereco(rs.getString("endereco"));
                    cliente.setTelefone(rs.getString("telefone"));

                    Venda venda = new Venda();
                    venda.setId(rs.getInt("id"));
                    venda.setValor_total(rs.getDouble("valor_total"));
                    venda.setData_venda(rs.getDate("data_venda"));
                    venda.setProduto(produto);
                    venda.setCliente(cliente);

                    return venda;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}