package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import org.example.cliente.Cliente;
import org.example.cliente.ClienteService;
import org.example.compra.CompraService;
import org.example.compra.Item;
import org.example.pagamento.Boleto;
import org.example.pagamento.CartaoCredito;
import org.example.pagamento.MeioPagamento;
import org.example.pagamento.Pix;
import org.example.produto.ProdutoService;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Cliente> clientes = new ArrayList<>();
        String opcao = "0";

        ClienteService clienteService = new ClienteService();
        ProdutoService produtoService = new ProdutoService();
        CompraService compraService = new CompraService();
        Item item = new Item();


        while(!opcao.equalsIgnoreCase("9")) {

            System.out.println("""
                    1 - Cadastrar Cliente
                    2 - Listar Clientes
                    3 - Excluir Cliente
                    4 - Cadastrar Produto
                    5 - Listar Produtos
                    6 - Excluir Produto
                    7 - Cadastrar Compra
                    8 - Listar Compras
                    9 - Sair
                    """);
            opcao = scanner.nextLine();
            if (opcao.equalsIgnoreCase("1")) {

                System.out.println("Digite o nome do cliente:");
                String nome = scanner.nextLine();
                System.out.println("Digite o CPF do cliente;");
                String cpf = scanner.nextLine();

                clienteService.cadastraCliente(nome, cpf);
            }

            if (opcao.equalsIgnoreCase("2")) {

                clienteService.listarClientes();
            }

            if (opcao.equalsIgnoreCase("3")) {

                System.out.println("Digite o cpf do cliente para deletar:");
                String cpf = scanner.nextLine();
                clienteService.excluirCliente(cpf);
            }

            if (opcao.equalsIgnoreCase("4")) {
                System.out.println("Digite o nome do produto:");
                String nome = scanner.nextLine();
                System.out.println("Digite o preco do produto:");
                double preco = scanner.nextDouble();
                scanner.nextLine();
                produtoService.cadastrarProduto(nome, preco);

            }

            if (opcao.equalsIgnoreCase("5")) {
                produtoService.listarProdutos();
            }

            if (opcao.equalsIgnoreCase("6")) {
                System.out.println("Digite o nome do produto para deletar:");
                String nome = scanner.nextLine();
                produtoService.excluirProduto(nome);
            }

            if (opcao.equalsIgnoreCase("7")) {
                System.out.println("Digite o cpf do cliente:");
                String cpf = scanner.nextLine();

                Cliente cliente = clienteService.buscaCliente(cpf);

                System.out.println("Digite o nome do produto:");
                String nome = scanner.nextLine();
                System.out.println("Digite a quantidade do produto:");
                int quantidade = scanner.nextInt();
                scanner.nextLine();

                item.setProduto(produtoService.buscaProduto(nome));
                item.setQuantidade(quantidade);

                System.out.println("""
                    Escolha o Meio de Pagamento:
                    1 - Pix
                    2 - Cartão de Crédito
                    3 - Boleto
                    """);
                String meioPagamento = scanner.nextLine();

                MeioPagamento meioPagamento1 = null;

                if (meioPagamento.equalsIgnoreCase("1")) {
                    System.out.println("Digite a chave pix:");
                    String chavePix = scanner.nextLine();

                    System.out.println("Digite o QRCode:");
                    String qrCodePix = scanner.nextLine();

                    meioPagamento1 = new Pix(true, LocalDateTime.now(), chavePix, qrCodePix);
                }

                if (meioPagamento.equalsIgnoreCase("2")) {
                    System.out.println("Digite o número do cartão:");
                    String numeroCartao = scanner.nextLine();

                    System.out.println("Digite a bandeira do cartão:");
                    String bandeiraCartao = scanner.nextLine();

                    meioPagamento1 = new CartaoCredito(true, LocalDateTime.now(), numeroCartao, bandeiraCartao);
                }

                if (meioPagamento.equalsIgnoreCase("3")) {
                    System.out.println("Digite o código de barras do boleto:");
                    String codigoBoleto = scanner.nextLine();

                    meioPagamento1 = new Boleto(true, LocalDateTime.now(), codigoBoleto);
                }

                compraService.cadastrarCompra(item, cliente, meioPagamento1);

            }

            if (opcao.equalsIgnoreCase("8")) {
                compraService.listarCompras();
            }
        }
    }
}