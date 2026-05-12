package atividade_programacao.controller;

import atividade_programacao.dao.CompraDAO;
import atividade_programacao.dao.ProdutoDAO;
import atividade_programacao.model.Compra;
import atividade_programacao.model.CompraProduto;
import atividade_programacao.model.Produto;

public class CompraController {
    private CompraDAO compraDAO;
    private ProdutoDAO produtoDAO;

    public CompraController() {
        this.compraDAO = new CompraDAO();
        this.produtoDAO = new ProdutoDAO();
    }

    public boolean salvar(Compra compra) {
        boolean salvou = compraDAO.salvar(compra);

        if (salvou) {
            for (CompraProduto cp : compra.getProdutos()) {
                Produto produto = produtoDAO.pesquisar(cp.getProduto().getId());
                // atualiza estoque dps de compra
                produto.setQtd_estoque(produto.getQtd_estoque() + cp.getQuantidade());
                //valor da ultima compra atualizado
                produto.setValor_ultima_compra(cp.getPreco_unit());
                // preço medio é calculado denovo
                produto.setPreco_medio((produto.getPreco_medio() + cp.getPreco_unit()) / 2);
                // por fim altera e salva
                produtoDAO.alterar(produto);
            }
        }

        return salvou;
    }

    public boolean alterar(Compra compra) {
        return compraDAO.alterar(compra);
    }

    public boolean excluir(int id) {
        return compraDAO.excluir(id);
    }

    public Compra pesquisar(int id) {
        return compraDAO.pesquisar(id);
    }
}