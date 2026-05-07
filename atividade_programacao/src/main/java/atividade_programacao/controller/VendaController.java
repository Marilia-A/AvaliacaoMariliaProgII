package atividade_programacao.controller;

import atividade_programacao.dao.ClienteDAO;
import atividade_programacao.dao.ProdutoDAO;
import atividade_programacao.dao.VendaDAO;
import atividade_programacao.model.ClienteModel;
import atividade_programacao.model.ProdutoModel;
import atividade_programacao.model.VendaModel;

public class VendaController {
    private VendaDAO vendaDAO;
    private ProdutoDAO produtoDAO;
    private ClienteDAO clienteDAO;

    public VendaController() {
        this.vendaDAO = new VendaDAO();
        this.produtoDAO = new ProdutoDAO();
        this.clienteDAO = new ClienteDAO();
    }

    public boolean salvar(VendaModel venda) {
        if (venda == null || venda.getProduto() == null || venda.getCliente() == null) {
            return false;
        }

        ProdutoModel produtoBanco = produtoDAO.pesquisar(venda.getProduto().getId());
        if (produtoBanco == null || produtoBanco.getQtd_estoque() < 1) {
            return false;
        }

        ClienteModel clienteBanco = clienteDAO.pesquisar(venda.getCliente().getId());
        if (clienteBanco == null) {
            return false;
        }

        int totalVendas = vendaDAO.contarVendasPorCliente(clienteBanco.getId());
        if (totalVendas >= 3) {
            return false;
        }

        return vendaDAO.salvar(venda);
    }

    public boolean alterar(VendaModel venda) {
        return vendaDAO.alterar(venda);
    }

    public boolean excluir(int id) {
        return vendaDAO.excluir(id);
    }

    public VendaModel pesquisar(int id) {
        return vendaDAO.pesquisar(id);
    }

    public int contarVendasPorCliente(int clienteId) {
        return vendaDAO.contarVendasPorCliente(clienteId);
    }
}