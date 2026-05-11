package atividade_programacao.controller;

import atividade_programacao.dao.ClienteDAO;
import atividade_programacao.dao.VendaDAO;
import atividade_programacao.model.Cliente;
import atividade_programacao.model.Venda;

public class VendaController {
    private VendaDAO vendaDAO;
    private ClienteDAO clienteDAO;

    public VendaController() {
        this.vendaDAO = new VendaDAO();
        this.clienteDAO = new ClienteDAO();
    }

    public boolean salvar(Venda venda) {
        if (venda == null || venda.getCliente() == null) {
            return false;
        }

        Cliente clienteBanco = clienteDAO.pesquisar(venda.getCliente().getId());
        if (clienteBanco == null) {
            return false;
        }

        int totalVendas = vendaDAO.contarVendasPorCliente(clienteBanco.getId());
        if (totalVendas >= 3) {
            return false;
        }

        return vendaDAO.salvar(venda);
    }

    public boolean alterar(Venda venda) {
        return vendaDAO.alterar(venda);
    }

    public boolean excluir(int id) {
        return vendaDAO.excluir(id);
    }

    public Venda pesquisar(int id) {
        return vendaDAO.pesquisar(id);
    }

    public int contarVendasPorCliente(int clienteId) {
        return vendaDAO.contarVendasPorCliente(clienteId);
    }
}