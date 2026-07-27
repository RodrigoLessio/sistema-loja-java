package model;

public class Produto {
    private String nome;
    private String codigo;
    private double preco;
    private int estoque;

    public Produto(String nome, String codigo, double preco, int estoque) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.estoque = estoque;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void imprimeProduto(){
        System.out.println("Nome: " + nome);
        System.out.println("Codigo: " + codigo);
        System.out.println("Preço: " + preco);
        System.out.println("Estoque: " + estoque);
    }
}
