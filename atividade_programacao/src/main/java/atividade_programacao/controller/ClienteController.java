package atividade_programacao.controller;

import atividade_programacao.dao.ClienteDAO;
import atividade_programacao.model.ClienteModel;

public class ClienteController {
    private ClienteDAO clienteDAO;

    public ClienteController() {
        this.clienteDAO = new ClienteDAO();
    }

    public boolean salvar(ClienteModel cliente) {
        return clienteDAO.salvar(cliente);
    }

    public boolean alterar(ClienteModel cliente) {
        return clienteDAO.alterar(cliente);
    }

    public boolean excluir(int id) {
        return clienteDAO.excluir(id);
    }

    public ClienteModel pesquisar(int id) {
        return clienteDAO.pesquisar(id);
    }
}