package br.com.senac.supfx.service;

import br.com.senac.supfx.repository.Produtos;

import java.text.SimpleDateFormat;

public class ContasDBService implements Produtos {

    final String USUARIO = "root";
    final String SENHA = "root";
    final String URL_BANCO = "jdbc:mysql://localhost::3306/senac_crud_sup_fx";
    final String CLASSE_DRIVER = "com.mysql.jdbc.Driver";

    final String INSERIR = "INSERT INTO produto(nome,descricao,quantidade," +
            "data_vencimento,preco,medida,estoque_max" +
            "estoque_min) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    final String ATUALIZAR = "UPDATE produto SET nome = ?, descricao = ?" +
            "quantidade = ?, data_vencimento = ?, preco = ?" +
            "medida = ?, estoque_max = ?, estoque_min = ? WHERE id = ?";
    final String APAGAR = "DELETE FROM conta where id = ?";
    final String FORMATO_DATA = "yyyy-MM-dd";
    final SimpleDateFormat FORMATADOR = new SimpleDateFormat(FORMATO_DATA);

    private Connection conexao(){
        try{
            Class.forName(CLASSE_DRIVER);
            return DriverManager.getConnection(URL_BANCO, USUARIO, SENHA);
        } catch (Exception e){
            e.printStackTrace();
            if (e instanceof ClassNotFoundException){
                System.out.println("VEREFIQUE SE O DRIVER DO BANCO DE DADOS" +
                        "ESTA NO CLASSPATH DO PROJETO");
            } else {
                System.out.println("VERIFIQUE SE O BANCO DE DADOS ESTÁ" +
                        "RODANDO E SE OS DADOS DE CONEXAO ESTÃO CORRETOS");
            }
            System.exit(0);
            return null;
        }
    }

}
