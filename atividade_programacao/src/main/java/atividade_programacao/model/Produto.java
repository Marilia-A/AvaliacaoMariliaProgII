package atividade_programacao.model;

public class Produto {
    private int id;
    private String nome;
    private double preco;
    private double qtd_estoque;
    private double valor_ultima_compra;
    private double valor_ultima_venda;
    private Fornecedor fornecedor;
    private Categoria categoria;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public double getQtd_estoque() {
        return qtd_estoque;
    }
    public void setQtd_estoque(double qtd_estoque) {
        this.qtd_estoque = qtd_estoque;
    }
    public double getValor_ultima_compra() {
        return valor_ultima_compra;
    }
    public void setValor_ultima_compra(double valor_ultima_compra) {
        this.valor_ultima_compra = valor_ultima_compra;
    }
    public double getValor_ultima_venda() {
        return valor_ultima_venda;
    }
    public void setValor_ultima_venda(double valor_ultima_venda) {
        this.valor_ultima_venda = valor_ultima_venda;
    }
    public Fornecedor getFornecedor() {
        return fornecedor;
    }
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Produto() {
    }
    public Produto(int id, String nome, double preco, double qtd_estoque, double valor_ultima_compra,
            double valor_ultima_venda, Fornecedor fornecedor, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.qtd_estoque = qtd_estoque;
        this.valor_ultima_compra = valor_ultima_compra;
        this.valor_ultima_venda = valor_ultima_venda;
        this.fornecedor = fornecedor;
        this.categoria = categoria;
    }
}
