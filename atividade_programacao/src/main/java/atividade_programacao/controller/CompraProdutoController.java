package atividade_programacao.controller;

import atividade_programacao.dao.CompraProdutoDAO;
import atividade_programacao.model.CompraProduto;

public class CompraProdutoController {
    private CompraProdutoDAO compraProdutoDAO;

    public CompraProdutoController() {
        this.compraProdutoDAO = new CompraProdutoDAO();
    }

    public boolean salvar(CompraProduto compraProduto) {
        return compraProdutoDAO.salvar(compraProduto);
    }

    public boolean alterar(CompraProduto compraProduto) {
        return compraProdutoDAO.alterar(compraProduto);
    }

    public boolean excluir(int id) {
        return compraProdutoDAO.excluir(id);
    }

    public CompraProduto pesquisar(int id) {
        return compraProdutoDAO.pesquisar(id);
    }
}