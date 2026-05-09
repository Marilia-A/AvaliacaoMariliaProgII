package atividade_programacao.controller;

import atividade_programacao.dao.CategoriaDAO;
import atividade_programacao.model.Categoria;

public class CategoriaController {
    private CategoriaDAO categoriaDAO;

    public CategoriaController() {
        this.categoriaDAO = new CategoriaDAO();
    }

    public boolean salvar(Categoria categoria) {
        return categoriaDAO.salvar(categoria);
    }

    public boolean alterar(Categoria categoria) {
        return categoriaDAO.alterar(categoria);
    }

    public boolean excluir(int id) {
        return categoriaDAO.excluir(id);
    }

    public Categoria pesquisar(int id) {
        return categoriaDAO.pesquisar(id);
    }
}