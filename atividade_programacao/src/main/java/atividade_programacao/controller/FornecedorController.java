package atividade_programacao.controller;

import atividade_programacao.dao.FornecedorDAO;
import atividade_programacao.model.FornecedorModel;

public class FornecedorController {
    private FornecedorDAO fornecedorDAO;

    public FornecedorController() {
        this.fornecedorDAO = new FornecedorDAO();
    }

    public boolean salvar(FornecedorModel fornecedor) {
        return fornecedorDAO.salvar(fornecedor);
    }

    public boolean alterar(FornecedorModel fornecedor) {
        return fornecedorDAO.alterar(fornecedor);
    }

    public boolean excluir(int id) {
        return fornecedorDAO.excluir(id);
    }

    public FornecedorModel pesquisar(int id) {
        return fornecedorDAO.pesquisar(id);
    }
}