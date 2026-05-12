package atividade_programacao.controller;

import atividade_programacao.dao.ProdutoDAO;
import atividade_programacao.dao.VendaProdutoDAO;
import atividade_programacao.model.Produto;
import atividade_programacao.model.VendaProduto;

public class VendaProdutoController {
    private VendaProdutoDAO vendaProdutoDAO;
    private ProdutoDAO produtoDAO;

    public VendaProdutoController() {
        this.vendaProdutoDAO = new VendaProdutoDAO();
        this.produtoDAO = new ProdutoDAO();
    }

    public boolean salvar(VendaProduto vendaProduto) {
        Produto produto = produtoDAO.pesquisar(vendaProduto.getProduto().getId());
        // não da pra realizar venda se não tiver produto no estoque
        if (produto == null || produto.getQtd_estoque() < vendaProduto.getQuantidade()) {
            return false;
        }

        boolean salvou = vendaProdutoDAO.salvar(vendaProduto);

        if (salvou) {
            // atualiza estoque
            produto.setQtd_estoque(produto.getQtd_estoque() - vendaProduto.getQuantidade());
            // atualiza valor da ultima venda
            produto.setValor_ultima_venda(vendaProduto.getPreco_unitario());
            // salva e altera
            produtoDAO.alterar(produto);
        }

        return salvou;
    }

    public boolean alterar(VendaProduto vendaProduto) {
        return vendaProdutoDAO.alterar(vendaProduto);
    }

    public boolean excluir(int id) {
        return vendaProdutoDAO.excluir(id);
    }

    public VendaProduto pesquisar(int id) {
        return vendaProdutoDAO.pesquisar(id);
    }
}