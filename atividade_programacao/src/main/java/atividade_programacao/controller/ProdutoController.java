package atividade_programacao.controller;

import atividade_programacao.dao.ProdutoDAO;
import atividade_programacao.model.ProdutoModel;

public class ProdutoController {
    private ProdutoDAO produtoDAO;

    public ProdutoController() {
        this.produtoDAO = new ProdutoDAO();
    }

    public boolean salvar(ProdutoModel produto) {
        return produtoDAO.salvar(produto);
    }

    public boolean alterar(ProdutoModel produto) {
        return produtoDAO.alterar(produto);
    }

    public boolean excluir(int id) {
        return produtoDAO.excluir(id);
    }

    public ProdutoModel pesquisar(int id) {
        return produtoDAO.pesquisar(id);
    }
}