import model.Cliente;
import model.ItemPedido;
import model.Pedido;
import model.Produto;
import service.Loja;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Loja loja = new Loja();

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n====================");
            System.out.println("       LOJA");
            System.out.println("====================");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Cadastrar cliente");
            System.out.println("3 - Criar pedido");
            System.out.println("4 - Consultar produto");
            System.out.println("5 - Consultar cliente");
            System.out.println("6 - Consultar pedido");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Nome: ");
                    String nomeProduto = scanner.nextLine();

                    System.out.println("Codigo: ");
                    String codigoProduto = scanner.nextLine();

                    System.out.println("Preço: R$");
                    double precoProduto = scanner.nextDouble();

                    System.out.println("Estoque: ");
                    int estoqueProduto = scanner.nextInt();

                    Produto produto = new Produto(nomeProduto, codigoProduto, precoProduto, estoqueProduto);
                    loja.adicionarProduto(produto);
                    System.out.println("Produto adicionado.");
                    break;
                case 2:
                    System.out.println("Nome: ");
                    String nomeCliente = scanner.nextLine();

                    System.out.println("CPF: ");
                    String cpfCliente = scanner.nextLine();

                    Cliente cliente = new Cliente(nomeCliente, cpfCliente);
                    loja.adicionarCliente(cliente);
                    System.out.println("Cliente adicionado.");
                    break;
                case 3:
                    System.out.println("CPF: ");
                    cpfCliente = scanner.nextLine();
                    Cliente clienteProcurado = loja.procurarCliente(cpfCliente);
                    if (clienteProcurado == null) {
                        System.out.println("CPF inválido.");
                        break;
                    }
                    Pedido pedido = new Pedido(clienteProcurado);

                    int escolhaContinuar = 0;
                    while (escolhaContinuar == 0) {
                        System.out.println("Codigo do produto: ");
                        codigoProduto = scanner.nextLine();
                        Produto produtoProcurado = loja.procurarProduto(codigoProduto);
                        if (produtoProcurado == null) {
                            System.out.println("Produto inválido.");
                            break;
                        }

                        System.out.println("Quantidade: ");
                        int quantidadeItem = scanner.nextInt();
                        scanner.nextLine();
                        if (quantidadeItem <= 0) {
                            System.out.println("Quantidade inválida.");
                            break;
                        }

                        ItemPedido itemPedido = new ItemPedido(produtoProcurado, quantidadeItem);
                        pedido.adicionarItem(itemPedido);
                        System.out.println("Item adicionado ao pedido.");

                        System.out.println("Adicionar produto? \n(0-sim/1-não)");
                        escolhaContinuar = scanner.nextInt();
                        scanner.nextLine();
                    }
                    loja.adicionarPedido(pedido);
                    break;
                case 4:
                    System.out.println("Codigo do produto: ");
                    codigoProduto = scanner.nextLine();
                    Produto produtoProcurado = loja.procurarProduto(codigoProduto);
                    if (produtoProcurado == null) {
                        System.out.println("Produto inválido.");
                        break;
                    }
                    produtoProcurado.imprimeProduto();
                    break;
                case 5:
                    System.out.println("CPF: ");
                    cpfCliente = scanner.nextLine();
                    clienteProcurado = loja.procurarCliente(cpfCliente);
                    if (clienteProcurado == null) {
                        System.out.println("CPF inválido.");
                        break;
                    }
                    clienteProcurado.imprimeCliente();
                    break;
                case 6:
                    if (loja.getPedidos().isEmpty()) {
                        System.out.println("Nenhum pedido cadastrado.");
                        break;
                    }

                    for (Pedido pedidoAtual : loja.getPedidos()) {

                        System.out.println("\n====================");
                        System.out.println("PEDIDO");
                        System.out.println("====================");

                        System.out.println("Cliente: " + pedidoAtual.getCliente().getNome());
                        System.out.println("CPF: " + pedidoAtual.getCliente().getCpf());

                        System.out.println("\nItens do pedido:");
                        
                        for (ItemPedido item : pedidoAtual.getItens()) {

                            Produto produtoAtual = item.getProduto();

                            System.out.println("--------------------");
                            System.out.println("Produto: " + produtoAtual.getNome());
                            System.out.println("Código: " + produtoAtual.getCodigo());
                            System.out.println("Preço: R$ " + produtoAtual.getPreco());
                            System.out.println("Quantidade: " + item.getQuantidade());

                            double subtotal = produtoAtual.getPreco() * item.getQuantidade();
                            System.out.println("Subtotal: R$ " + subtotal);
                        }
                    }
                    break;
                case 0:
                    opcao = 0;
                    break;
                default:
                    System.out.println("opção invalida.");
                    break;
            }
        }
    }
}