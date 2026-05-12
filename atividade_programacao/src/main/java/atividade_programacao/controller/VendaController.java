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
    // venda precisa ter cliente 
    public boolean salvar(Venda venda) {
        if (venda == null || venda.getCliente() == null) {
            return false;
        }
        // cliente deve existir no banco de dados
        Cliente clienteBanco = clienteDAO.pesquisar(venda.getCliente().getId());
        if (clienteBanco == null) {
            return false;
        }
       // limite de 3 vendas
        int totalVendas = vendaDAO.contarVendasPorCliente(clienteBanco.getId());
        if (totalVendas >= 3) {
            return false;
        }
        // só deve salvar se os ifs forem atendidos em essencia
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
    // conta as vendas por cliente
    public int contarVendasPorCliente(int clienteId) {
        return vendaDAO.contarVendasPorCliente(clienteId);
    }
}