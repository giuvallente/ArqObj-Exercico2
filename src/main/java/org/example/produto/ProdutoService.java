package org.example.produto;

import java.util.ArrayList;

public class ProdutoService {

    private ArrayList<Produto> produtos = new ArrayList<>();

    public void cadastrarProduto(String nome, double preco) {
        if (nome.equals("") || preco <= 0) {
            System.out.println("Dados do produto invalido.");
        } else {
            Produto produto = new Produto(nome, preco);
            produtos.add(produto);
            System.out.println("Produto cadastrado com sucesso.");
        }
    }

    public void listarProdutos() {
        System.out.println("Lista de produtos:");
        System.out.println("");
        for (Produto produto : produtos) {
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Preço: " + produto.getPreco());
            System.out.println("");
        }
    }

    public void excluirProduto(String nome) {
        Produto produtoRemover = null;
        for (Produto produto : produtos) {
            if (nome.equalsIgnoreCase(produto.getNome())) {
                produtoRemover = produto;
            }
        }
        if (produtoRemover != null) {
            System.out.println("Produto removido com sucesso");
            produtos.remove(produtoRemover);
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public Produto buscaProduto(String nome) {
        Produto produtoBusca = null;
        for (Produto produto : produtos) {
            if (nome.equalsIgnoreCase(produto.getNome())) {
                return produto;
            }
        }

        return null;
    }
}

