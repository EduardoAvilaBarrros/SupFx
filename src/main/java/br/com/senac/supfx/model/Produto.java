package br.com.senac.supfx.model;

public class Produto {

    private int id;
    private String nome;
    private String descricao;
    private double quantidade;
    private double preco;
    private double medida;


    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public double getMedida() {
        return medida;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setMedida(double medida) {
        this.medida = medida;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }
}
