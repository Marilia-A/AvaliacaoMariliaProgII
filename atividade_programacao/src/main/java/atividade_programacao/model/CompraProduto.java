package atividade_programacao.model;

public class CompraProduto {
    private int id_item;
    private Produto produto;
    private Compra compra;
    private int quantidade;
    private double preco_unitario;
    
    public int getId_item() {
        return id_item;
    }
    public void setId_item(int id_item) {
        this.id_item = id_item;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public Compra getCompra() {
        return compra;
    }
    public void setCompra(Compra compra) {
        this.compra = compra;
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

    public CompraProduto() {
    }
    public CompraProduto(int id_item, Produto produto, Compra compra, int quantidade, double preco_unitario) {
        this.id_item = id_item;
        this.produto = produto;
        this.compra = compra;
        this.quantidade = quantidade;
        this.preco_unitario = preco_unitario;
    }
    

}