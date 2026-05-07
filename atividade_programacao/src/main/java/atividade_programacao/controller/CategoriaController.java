package atividade_programacao.controller;

import atividade_programacao.dao.CategoriaDAO;
import atividade_programacao.model.CategoriaModel;

public class CategoriaController {
    private CategoriaDAO categoriaDAO;

    public CategoriaController() {
        this.categoriaDAO = new CategoriaDAO();
    }

    public boolean salvar(CategoriaModel categoria) {
        return categoriaDAO.salvar(categoria);
    }

    public boolean alterar(CategoriaModel categoria) {
        return categoriaDAO.alterar(categoria);
    }

    public boolean excluir(int id) {
        return categoriaDAO.excluir(id);
    }

    public CategoriaModel pesquisar(int id) {
        return categoriaDAO.pesquisar(id);
    }
}