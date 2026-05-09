package atividade_programacao.controller;

import atividade_programacao.dao.ClienteDAO;
import atividade_programacao.model.Cliente;

public class ClienteController {
    private ClienteDAO clienteDAO;

    public ClienteController() {
        this.clienteDAO = new ClienteDAO();
    }

    public boolean salvar(Cliente cliente) {
        return clienteDAO.salvar(cliente);
    }

    public boolean alterar(Cliente cliente) {
        return clienteDAO.alterar(cliente);
    }

    public boolean excluir(int id) {
        return clienteDAO.excluir(id);
    }

    public Cliente pesquisar(int id) {
        return clienteDAO.pesquisar(id);
    }
}