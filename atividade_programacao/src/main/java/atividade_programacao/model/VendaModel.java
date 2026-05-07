package atividade_programacao.model;
import java.util.Date;

public class VendaModel {
    private int id;
    private double valor_total;
    private Date data_venda;
    private ProdutoModel produto;
    private ClienteModel cliente;

    //get e set
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getValor_total() {
        return valor_total;
    }
    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }
    public Date getData_venda() {
        return data_venda;
    }
    public void setData_venda(Date data_venda) {
        this.data_venda = data_venda;
    }
    public ProdutoModel getProduto() {
        return produto;
    }
    public void setProduto(ProdutoModel produto) {
        this.produto = produto;
    }
    public ClienteModel getCliente() {
        return cliente;
    }
    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    //construtores
    public VendaModel(int id, double valor_total, Date data_venda, ProdutoModel produto, ClienteModel cliente) {
        this.id = id;
        this.valor_total = valor_total;
        this.data_venda = data_venda;
        this.produto = produto;
        this.cliente = cliente;
    }
    public VendaModel() {
    }

    


    
}
