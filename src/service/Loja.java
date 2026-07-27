package service;

import model.Cliente;
import model.Pedido;
import model.Produto;

import java.util.ArrayList;

public class Loja {
    private ArrayList<Cliente> clientes;
    private ArrayList<Produto> produtos;
    private ArrayList<Pedido> pedidos;

    public Loja() {
        clientes = new ArrayList<>();
        produtos = new ArrayList<>();
        pedidos = new ArrayList<>();
    }

    public void adicionarPedido (Pedido pedido) {
        pedidos.add(pedido);
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public Cliente procurarCliente(String cpf) {
        for (Cliente cliente : clientes){
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public Produto procurarProduto(String codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo().equals(codigo)){
                return produto;
            }
        }
        return null;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
}
