package org.example.cliente;

import java.util.ArrayList;

public class ClienteService {

    private ArrayList<Cliente> clientes = new ArrayList<>();

    public void cadastraCliente(String nome, String cpf) {
        if (nome.equals("") || cpf.equals("")) {
            System.out.println("Dados do cliente invalido.");
        } else {
            Cliente cliente = new Cliente(nome, cpf, null);
            clientes.add(cliente);
            System.out.println("Cliente cadastrado com sucesso.");
        }
    }

    public void listarClientes() {
        System.out.println("Lista de clientes:");
        System.out.println("");
        for (Cliente cliente : clientes) {
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("");
        }
    }

    public void excluirCliente(String cpf) {
        Cliente clienteRemover = null;
        for (Cliente cliente : clientes) {
            if (cpf.equalsIgnoreCase(cliente.getCpf())) {
                clienteRemover = cliente;
            }
        }
        if (clienteRemover != null) {
            System.out.println("Cliente removido com sucesso");
            clientes.remove(clienteRemover);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public Cliente buscaCliente(String cpf) {
        Cliente clienteBusca = null;
        for (Cliente cliente : clientes) {
            if (cpf.equalsIgnoreCase(cliente.getCpf())) {
                return cliente;
            }
        }

        return null;
    }

}

