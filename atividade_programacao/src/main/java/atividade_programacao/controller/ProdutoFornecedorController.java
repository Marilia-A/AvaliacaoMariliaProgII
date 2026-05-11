package atividade_programacao.controller;

import atividade_programacao.dao.ProdutoFornecedorDAO;
import atividade_programacao.model.ProdutoFornecedor;

public class ProdutoFornecedorController {
    private ProdutoFornecedorDAO produtoFornecedorDAO;

    public ProdutoFornecedorController() {
        this.produtoFornecedorDAO = new ProdutoFornecedorDAO();
    }

    public boolean salvar(ProdutoFornecedor produtoFornecedor) {
        return produtoFornecedorDAO.salvar(produtoFornecedor);
    }

    public boolean alterar(ProdutoFornecedor produtoFornecedor) {
        return produtoFornecedorDAO.alterar(produtoFornecedor);
    }

    public boolean excluir(int id) {
        return produtoFornecedorDAO.excluir(id);
    }

    public ProdutoFornecedor pesquisar(int id) {
        return produtoFornecedorDAO.pesquisar(id);
    }
}