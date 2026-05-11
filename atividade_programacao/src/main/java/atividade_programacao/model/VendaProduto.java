package atividade_programacao.model;
public class VendaProduto {
    private int id;
    private int quantidade;
    private double preco_unitario;
    private Venda venda;
    private Produto produto;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public double getPreco_unitario() {
        return preco_unitario;
    }
    public void setPreco_unitario(double preco_unitario) {
        this.preco_unitario = preco_unitario;
    }
    public Venda getVenda() {
        return venda;
    }
    public void setVenda(Venda venda) {
        this.venda = venda;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public VendaProduto() {
    }
    public VendaProduto(int id, int quantidade, double preco_unitario, Venda venda, Produto produto) {
        this.id = id;
        this.quantidade = quantidade;
        this.preco_unitario = preco_unitario;
        this.venda = venda;
        this.produto = produto;
    }     
}