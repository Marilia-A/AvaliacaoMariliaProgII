import java.util.Date;
import java.util.Scanner;

import atividade_programacao.controller.CategoriaController;
import atividade_programacao.controller.ClienteController;
import atividade_programacao.controller.FornecedorController;
import atividade_programacao.controller.ProdutoController;
import atividade_programacao.controller.VendaController;
import atividade_programacao.model.CategoriaModel;
import atividade_programacao.model.ClienteModel;
import atividade_programacao.model.FornecedorModel;
import atividade_programacao.model.ProdutoModel;
import atividade_programacao.model.VendaModel;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CategoriaController categoriaController = new CategoriaController();
        ClienteController clienteController = new ClienteController();
        FornecedorController fornecedorController = new FornecedorController();
        ProdutoController produtoController = new ProdutoController();
        VendaController vendaController = new VendaController();

        int opcaoPrincipal;

        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1 - Gerenciar Categorias");
            System.out.println("2 - Gerenciar Clientes");
            System.out.println("3 - Gerenciar Fornecedores");
            System.out.println("4 - Gerenciar Produtos");
            System.out.println("5 - Vendas");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcaoPrincipal = Integer.parseInt(sc.nextLine());

            int opcaoSub;

            switch (opcaoPrincipal) {
                case 1 -> { // CATEGORIAS
                    do {
                        System.out.println("\n--- SUBMENU CATEGORIAS ---");
                        System.out.println("1 - Cadastrar | 2 - Alterar | 3 - Excluir | 4 - Pesquisar | 0 - Voltar");
                        System.out.print("Ação: ");
                        opcaoSub = Integer.parseInt(sc.nextLine());
                        switch (opcaoSub) {
                            case 1 -> {
                                CategoriaModel categoria = new CategoriaModel();
                                System.out.print("ID da categoria: ");
                                categoria.setId(Integer.parseInt(sc.nextLine()));
                                System.out.print("Nome da categoria: ");
                                categoria.setNome(sc.nextLine());
                                System.out.println(categoriaController.salvar(categoria) ? "Categoria salva." : "Erro ao salvar.");
                            }
                            case 2 -> {
                                CategoriaModel categoria = new CategoriaModel();
                                System.out.print("ID da categoria: ");
                                categoria.setId(Integer.parseInt(sc.nextLine()));
                                System.out.print("Nome da categoria: ");
                                categoria.setNome(sc.nextLine());
                                System.out.println(categoriaController.alterar(categoria) ? "Categoria alterada." : "Erro ao alterar.");
                            }
                            case 3 -> {
                                System.out.print("ID da categoria: ");
                                int id = Integer.parseInt(sc.nextLine());
                                System.out.println(categoriaController.excluir(id) ? "Categoria excluida." : "Erro ao excluir.");
                            }
                            case 4 -> {
                                System.out.print("ID da categoria: ");
                                int id = Integer.parseInt(sc.nextLine());
                                CategoriaModel categoria = categoriaController.pesquisar(id);
                                if (categoria != null) {
                                    System.out.println("ID: " + categoria.getId() + " | Nome: " + categoria.getNome());
                                } else { System.out.println("Categoria nao encontrada."); }
                            }
                        }
                    } while (opcaoSub != 0);
                }
                case 2 -> { // CLIENTES
                    do {
                        System.out.println("\n--- SUBMENU CLIENTES ---");
                        System.out.println("1 - Cadastrar | 2 - Alterar | 3 - Excluir | 4 - Pesquisar | 0 - Voltar");
                        System.out.print("Ação: ");
                        opcaoSub = Integer.parseInt(sc.nextLine());
                        switch (opcaoSub) {
                            case 1 -> {
                                ClienteModel cliente = new ClienteModel();
                                System.out.print("ID do cliente: ");
                                cliente.setId(Integer.parseInt(sc.nextLine()));
                                System.out.print("Nome: "); cliente.setNome(sc.nextLine());
                                System.out.print("CPF: "); cliente.setCpf(sc.nextLine());
                                System.out.print("RG: "); cliente.setRg(sc.nextLine());
                                System.out.print("Endereco: "); cliente.setEndereco(sc.nextLine());
                                System.out.print("Telefone: "); cliente.setTelefone(sc.nextLine());
                                System.out.println(clienteController.salvar(cliente) ? "Cliente salvo." : "Erro ao salvar.");
                            }
                            case 2 -> {
                                ClienteModel cliente = new ClienteModel();
                                System.out.print("ID do cliente: ");
                                cliente.setId(Integer.parseInt(sc.nextLine()));
                                System.out.print("Nome: "); cliente.setNome(sc.nextLine());
                                System.out.print("CPF: "); cliente.setCpf(sc.nextLine());
                                System.out.print("RG: "); cliente.setRg(sc.nextLine());
                                System.out.print("Endereco: "); cliente.setEndereco(sc.nextLine());
                                System.out.print("Telefone: "); cliente.setTelefone(sc.nextLine());
                                System.out.println(clienteController.alterar(cliente) ? "Cliente alterado." : "Erro ao alterar.");
                            }
                            case 3 -> {
                                System.out.print("ID do cliente: ");
                                int id = Integer.parseInt(sc.nextLine());
                                System.out.println(clienteController.excluir(id) ? "Cliente excluido." : "Erro ao excluir.");
                            }
                            case 4 -> {
                                System.out.print("ID do cliente: ");
                                int id = Integer.parseInt(sc.nextLine());
                                ClienteModel cliente = clienteController.pesquisar(id);
                                if (cliente != null) {
                                    System.out.println("ID: " + cliente.getId() + " | Nome: " + cliente.getNome() + " | CPF: " + cliente.getCpf());
                                } else { System.out.println("Cliente nao encontrado."); }
                            }
                        }
                    } while (opcaoSub != 0);
                }
                case 3 -> { // FORNECEDORES
                    do {
                        System.out.println("\n--- SUBMENU FORNECEDORES ---");
                        System.out.println("1 - Cadastrar | 2 - Alterar | 3 - Excluir | 4 - Pesquisar | 0 - Voltar");
                        System.out.print("Ação: ");
                        opcaoSub = Integer.parseInt(sc.nextLine());
                        switch (opcaoSub) {
                            case 1 -> {
                                FornecedorModel fornecedor = new FornecedorModel();
                                System.out.print("ID do fornecedor: "); fornecedor.setId(Integer.parseInt(sc.nextLine()));
                                System.out.print("Nome fantasia: "); fornecedor.setNome_fantasia(sc.nextLine());
                                System.out.print("Razao social: "); fornecedor.setRazao_social(sc.nextLine());
                                System.out.print("CNPJ: "); fornecedor.setCnpj(sc.nextLine());
                                System.out.println(fornecedorController.salvar(fornecedor) ? "Fornecedor salvo." : "Erro ao salvar.");
                            }
                            case 2 -> {
                                FornecedorModel fornecedor = new FornecedorModel();
                                System.out.print("ID do fornecedor: "); fornecedor.setId(Integer.parseInt(sc.nextLine()));
                                System.out.print("Nome fantasia: "); fornecedor.setNome_fantasia(sc.nextLine());
                                System.out.print("Razao social: "); fornecedor.setRazao_social(sc.nextLine());
                                System.out.print("CNPJ: "); fornecedor.setCnpj(sc.nextLine());
                                System.out.println(fornecedorController.alterar(fornecedor) ? "Fornecedor alterado." : "Erro ao alterar.");
                            }
                            case 3 -> {
                                System.out.print("ID do fornecedor: ");
                                int id = Integer.parseInt(sc.nextLine());
                                System.out.println(fornecedorController.excluir(id) ? "Fornecedor excluido." : "Erro ao excluir.");
                            }
                            case 4 -> {
                                System.out.print("ID do fornecedor: ");
                                int id = Integer.parseInt(sc.nextLine());
                                FornecedorModel fornecedor = fornecedorController.pesquisar(id);
                                if (fornecedor != null) {
                                    System.out.println("ID: " + fornecedor.getId() + " | Fantasia: " + fornecedor.getNome_fantasia());
                                } else { System.out.println("Fornecedor nao encontrado."); }
                            }
                        }
                    } while (opcaoSub != 0);
                }
                case 4 -> { // PRODUTOS
                    do {
                        System.out.println("\n--- SUBMENU PRODUTOS ---");
                        System.out.println("1 - Cadastrar | 2 - Alterar | 3 - Excluir | 4 - Pesquisar | 0 - Voltar");
                        System.out.print("Ação: ");
                        opcaoSub = Integer.parseInt(sc.nextLine());
                        switch (opcaoSub) {
                            case 1 -> {
                                ProdutoModel produto = new ProdutoModel();
                                CategoriaModel categoria = new CategoriaModel();
                                System.out.print("ID do produto: "); produto.setId(Integer.parseInt(sc.nextLine()));
                                System.out.print("Nome do produto: "); produto.setNome(sc.nextLine());
                                System.out.print("Preco: "); produto.setPreco(Double.parseDouble(sc.nextLine()));
                                System.out.print("Quantidade em estoque: "); produto.setQtd_estoque(Double.parseDouble(sc.nextLine()));
                                System.out.print("ID da categoria: "); categoria.setId(Integer.parseInt(sc.nextLine()));
                                produto.setCategoria(categoria);
                                System.out.println(produtoController.salvar(produto) ? "Produto salvo." : "Erro ao salvar.");
                            }
                            case 2 -> {
                                ProdutoModel produto = new ProdutoModel();
                                CategoriaModel categoria = new CategoriaModel();
                                System.out.print("ID do produto: "); produto.setId(Integer.parseInt(sc.nextLine()));
                                System.out.print("Nome do produto: "); produto.setNome(sc.nextLine());
                                System.out.print("Preco: "); produto.setPreco(Double.parseDouble(sc.nextLine()));
                                System.out.print("Quantidade em estoque: "); produto.setQtd_estoque(Double.parseDouble(sc.nextLine()));
                                System.out.print("ID da categoria: "); categoria.setId(Integer.parseInt(sc.nextLine()));
                                produto.setCategoria(categoria);
                                System.out.println(produtoController.alterar(produto) ? "Produto alterado." : "Erro ao alterar.");
                            }
                            case 3 -> {
                                System.out.print("ID do produto: ");
                                int id = Integer.parseInt(sc.nextLine());
                                System.out.println(produtoController.excluir(id) ? "Produto excluido." : "Erro ao excluir.");
                            }
                            case 4 -> {
                                System.out.print("ID do produto: ");
                                int id = Integer.parseInt(sc.nextLine());
                                ProdutoModel produto = produtoController.pesquisar(id);
                                if (produto != null) {
                                    System.out.println("ID: " + produto.getId() + " | Nome: " + produto.getNome() + " | Estoque: " + produto.getQtd_estoque());
                                } else { System.out.println("Produto nao encontrado."); }
                            }
                        }
                    } while (opcaoSub != 0);
                }
                case 5 -> { // VENDAS
                    do {
                        System.out.println("\n--- SUBMENU VENDAS ---");
                        System.out.println("1 - Realizar Venda | 2 - Pesquisar Venda | 0 - Voltar");
                        System.out.print("Ação: ");
                        opcaoSub = Integer.parseInt(sc.nextLine());
                        if (opcaoSub == 1) {
                            VendaModel venda = new VendaModel();
                            ClienteModel cliente = new ClienteModel();
                            ProdutoModel produto = new ProdutoModel();
                            System.out.print("ID da venda: "); venda.setId(Integer.parseInt(sc.nextLine()));
                            System.out.print("ID do cliente: "); cliente.setId(Integer.parseInt(sc.nextLine()));
                            System.out.print("ID do produto: "); produto.setId(Integer.parseInt(sc.nextLine()));

                            ClienteModel clienteBanco = clienteController.pesquisar(cliente.getId());
                            ProdutoModel produtoBanco = produtoController.pesquisar(produto.getId());

                            if (clienteBanco == null || produtoBanco == null) {
                                System.out.println("Erro: Cliente ou Produto não encontrados.");
                                continue;
                            }
                            if (produtoBanco.getQtd_estoque() < 1) {
                                System.out.println("Venda abortada. Produto sem estoque.");
                                continue;
                            }
                            if (vendaController.contarVendasPorCliente(clienteBanco.getId()) >= 3) {
                                System.out.println("Alerta: cliente atingiu a quantidade maxima de vendas.");
                                continue;
                            }
                            venda.setCliente(clienteBanco);
                            venda.setProduto(produtoBanco);
                            venda.setValor_total(produtoBanco.getPreco());
                            venda.setData_venda(new Date());
                            System.out.println(vendaController.salvar(venda) ? "Venda realizada." : "Erro na venda.");
                        } else if (opcaoSub == 2) {
                            System.out.print("ID da venda: ");
                            int id = Integer.parseInt(sc.nextLine());
                            VendaModel venda = vendaController.pesquisar(id);
                            if (venda != null) {
                                System.out.println("Venda ID: " + venda.getId() + " | Valor: " + venda.getValor_total());
                            } else { System.out.println("Venda nao encontrada."); }
                        }
                    } while (opcaoSub != 0);
                }
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcaoPrincipal != 0);

        sc.close();
    }
}