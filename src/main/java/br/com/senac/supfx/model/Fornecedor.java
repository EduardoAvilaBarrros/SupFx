package br.com.senac.supfx.model;


import java.util.Date;

public class Fornecedor {

    private int id;

    private String nome;

    private String CNPJ;

    private String numero_NF;

    private Date data_recebimento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getNumero_NF() {
        return numero_NF;
    }

    public void setNumero_NF(String numero_NF) {
        this.numero_NF = numero_NF;
    }

    public Date getData_recebimento() {
        return data_recebimento;
    }

    public void setData_recebimento(Date data_recebimento) {
        this.data_recebimento = data_recebimento;
    }
}
