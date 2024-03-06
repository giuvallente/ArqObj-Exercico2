package org.example.compra;

import org.example.cliente.Cliente;
import org.example.pagamento.MeioPagamento;


import java.time.LocalDateTime;
import java.util.ArrayList;

public class Compra {

    private LocalDateTime dataCompra = LocalDateTime.now();
    private Double precoTotal;
    private Cliente cliente;

    private ArrayList<Item> itens = new ArrayList<>();

    private MeioPagamento meioPagamento;

    public Compra() {
    }

    public Compra(Double precoTotal, Cliente cliente, MeioPagamento meioPagamento) {
        this.precoTotal = precoTotal;
        this.cliente = cliente;
        this.meioPagamento = meioPagamento;
    }

    public void calculaPrecoTotal() {
        Double total = 0D;
        for (Item item : itens) {
            total = total + item.getQuantidade()
                    * item.getProduto().getPreco();
        }
        this.precoTotal =  total;
    }

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDateTime dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Double getPrecoTotal() {
        return precoTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void adicionarItem(Item item)  {
        this.itens.add(item);
    }

    public MeioPagamento getMeioPagamento() {
        return meioPagamento;
    }

    public void setMeioPagamento(MeioPagamento meioPagamento) {
        this.meioPagamento = meioPagamento;
    }

}

