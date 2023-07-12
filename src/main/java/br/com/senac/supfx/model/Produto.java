package br.com.senac.supfx.model;

public class Produto {

    private int id;
    private String nome;
    private String descricao;
    private int quantidade;
    private int preco;
    private int medida;
    //private int estoque_max;
    //private int estoque_min;


    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getPreco() {
        return preco;
    }

    public int getMedida() {
        return medida;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setMedida(int medida) {
        this.medida = medida;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }
}
