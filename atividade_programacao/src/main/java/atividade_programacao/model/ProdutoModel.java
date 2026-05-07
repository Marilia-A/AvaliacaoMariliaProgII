package atividade_programacao.model;

public class ProdutoModel {
    private int id;
    private String nome;
    private double preco;
    private double qtd_estoque;
    private FornecedorModel fornecedor;
    private CategoriaModel categoria;

    //get e set
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
    public void setQtd_estoque(double qtde_estoque) {
        this.qtd_estoque = qtde_estoque;
    }
    public FornecedorModel getFornecedor() {
        return fornecedor;
    }
    public void setFornecedor(FornecedorModel fornecedor) {
        this.fornecedor = fornecedor;
    }
    public CategoriaModel getCategoria() {
        return categoria;
    }
    public void setCategoria(CategoriaModel categoria) {
        this.categoria = categoria;
    }

    //construtores
    public ProdutoModel() {
    }
    public ProdutoModel(int id, String nome, double preco, double qtde_estoque, FornecedorModel fornecedor, CategoriaModel categoria) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.qtd_estoque = qtde_estoque;
        this.fornecedor = fornecedor;
        this.categoria = categoria;
    }

    
}
