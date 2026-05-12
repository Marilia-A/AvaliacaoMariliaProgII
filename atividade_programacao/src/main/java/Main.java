import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import atividade_programacao.controller.CategoriaController;
import atividade_programacao.controller.ClienteController;
import atividade_programacao.controller.CompraController;
import atividade_programacao.controller.FornecedorController;
import atividade_programacao.controller.ProdutoController;
import atividade_programacao.controller.VendaController;
import atividade_programacao.model.Categoria;
import atividade_programacao.model.Cliente;
import atividade_programacao.model.Compra;
import atividade_programacao.model.CompraProduto;
import atividade_programacao.model.Fornecedor;
import atividade_programacao.model.Produto;
import atividade_programacao.model.Venda;
import atividade_programacao.model.VendaProduto;

public class Main {

    public static void main(String[] args) {

        // =========================
        // CONTROLLERS
        // =========================
        CategoriaController categoriaController = new CategoriaController();
        ClienteController clienteController = new ClienteController();
        FornecedorController fornecedorController = new FornecedorController();
        ProdutoController produtoController = new ProdutoController();
        CompraController compraController = new CompraController();
        VendaController vendaController = new VendaController();

        // =========================
        // CATEGORIA
        // =========================
        Categoria categoria1 = new Categoria();
        categoria1.setId(1);
        categoria1.setNome("Bebidas");

        System.out.println("Categoria: " + categoriaController.salvar(categoria1));

        // =========================
        // CLIENTE
        // =========================
        Cliente cliente1 = new Cliente();
        cliente1.setId(1);
        cliente1.setNome("Maria Silva");
        cliente1.setCpf("123.456.789-00");
        cliente1.setRg("MG123456");
        cliente1.setEndereco("Rua A");
        cliente1.setTelefone("62999990001");

        System.out.println("Cliente: " + clienteController.salvar(cliente1));

        // =========================
        // FORNECEDOR
        // =========================
        Fornecedor fornecedor1 = new Fornecedor();
        fornecedor1.setId(1);
        fornecedor1.setNome_fantasia("Distribuidora Alfa");
        fornecedor1.setRazao_social("Alfa Comercio LTDA");
        fornecedor1.setCnpj("12.345.678/0001-90");

        System.out.println("Fornecedor: " + fornecedorController.salvar(fornecedor1));

        // =========================
        // PRODUTOS
        // =========================
        Produto produto1 = new Produto();
        produto1.setId(1);
        produto1.setNome("Coca-Cola 2L");
        produto1.setPreco_medio(8.50);
        produto1.setQtd_estoque(50);
        produto1.setValor_ultima_compra(7.00);
        produto1.setValor_ultima_venda(9.00);
        produto1.setCategoria(categoria1);

        System.out.println("Produto1: " + produtoController.salvar(produto1));

        Produto produto2 = new Produto();
        produto2.setId(2);
        produto2.setNome("Arroz 5kg");
        produto2.setPreco_medio(22.00);
        produto2.setQtd_estoque(30);
        produto2.setValor_ultima_compra(20.00);
        produto2.setValor_ultima_venda(25.00);
        produto2.setCategoria(categoria1);

        System.out.println("Produto2: " + produtoController.salvar(produto2));

        // =========================
        // COMPRA 1
        // =========================
        Compra compra1 = new Compra();
        compra1.setId(1);
        compra1.setData_compra(LocalDate.now());
        compra1.setValor_total(100.00);
        compra1.setFornecedor(fornecedor1);

        List<CompraProduto> listaCompra1 = new ArrayList<>();

        CompraProduto cp1 = new CompraProduto();
        cp1.setId(1);
        cp1.setProduto(produto1);
        cp1.setCompra(compra1);
        cp1.setQuantidade(10);
        cp1.setPreco_unit(7.00);

        listaCompra1.add(cp1);

        compra1.setProdutos(listaCompra1);

        System.out.println("Compra1: " + compraController.salvar(compra1));

        // =========================
        // COMPRA 2
        // =========================
        Compra compra2 = new Compra();
        compra2.setId(2);
        compra2.setData_compra(LocalDate.now());
        compra2.setValor_total(200.00);
        compra2.setFornecedor(fornecedor1);

        List<CompraProduto> listaCompra2 = new ArrayList<>();

        CompraProduto cp2 = new CompraProduto();
        cp2.setId(2);
        cp2.setProduto(produto2);
        cp2.setCompra(compra2);
        cp2.setQuantidade(5);
        cp2.setPreco_unit(20.00);

        listaCompra2.add(cp2);

        compra2.setProdutos(listaCompra2);

        System.out.println("Compra2: " + compraController.salvar(compra2));

        // =========================
        // VENDA 1
        // =========================
        Venda venda1 = new Venda();
        venda1.setId(1);
        venda1.setData_venda(LocalDate.now());
        venda1.setValor_total(18.00);
        venda1.setCliente(cliente1);

        List<VendaProduto> listaVenda1 = new ArrayList<>();

        VendaProduto vp1 = new VendaProduto();
        vp1.setId(1);
        vp1.setVenda(venda1);
        vp1.setProduto(produto1);
        vp1.setQuantidade(2);
        vp1.setPreco_unitario(9.00);

        listaVenda1.add(vp1);

        venda1.setProdutos(listaVenda1);

        System.out.println("Venda1: " + vendaController.salvar(venda1));

        // =========================
        // VENDA 2
        // =========================
        Venda venda2 = new Venda();
        venda2.setId(2);
        venda2.setData_venda(LocalDate.now());
        venda2.setValor_total(25.00);
        venda2.setCliente(cliente1);

        List<VendaProduto> listaVenda2 = new ArrayList<>();

        VendaProduto vp2 = new VendaProduto();
        vp2.setId(2);
        vp2.setVenda(venda2);
        vp2.setProduto(produto2);
        vp2.setQuantidade(1);
        vp2.setPreco_unitario(25.00);

        listaVenda2.add(vp2);

        venda2.setProdutos(listaVenda2);

        System.out.println("Venda2: " + vendaController.salvar(venda2));
    }
}