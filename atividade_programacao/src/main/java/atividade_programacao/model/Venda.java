package atividade_programacao.model;
import java.util.Date;
import java.util.List;

public class Venda {
    private int id;
    private double valor_total;
    private Date data_venda;
    private Produto produto;
    private Cliente cliente;
    private List<VendaProduto> produtos;
    
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
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public List<VendaProduto> getProdutos() {
        return produtos;
    }
    public void setProdutos(List<VendaProduto> produtos) {
        this.produtos = produtos;
    }

    public Venda() {
    }
    public Venda(int id, double valor_total, Date data_venda, Produto produto, Cliente cliente,
            List<VendaProduto> produtos) {
        this.id = id;
        this.valor_total = valor_total;
        this.data_venda = data_venda;
        this.produto = produto;
        this.cliente = cliente;
        this.produtos = produtos;
    }    
}
