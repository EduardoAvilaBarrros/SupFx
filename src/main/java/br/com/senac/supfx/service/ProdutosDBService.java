package br.com.senac.supfx.service;

import br.com.senac.supfx.model.Produto;
import br.com.senac.supfx.repository.Produtos;

import java.text.ParseException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutosDBService implements Produtos {

    final String USUARIO = "root";
    final String SENHA = "root";
    final String URL_BANCO = "jdbc:mysql://localhost::3306/senac_crud_sup_fx";
    final String CLASSE_DRIVER = "com.mysql.jdbc.Driver";

    final String BUSCAR_TODOS = "SELECT id";

    final String INSERIR = "INSERT INTO produto(nome,descricao,quantidade," +
            "data_vencimento,preco,medida,estoque_max" +
            "estoque_min) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    final String ATUALIZAR = "UPDATE produto SET nome = ?, descricao = ?" +
            "quantidade = ?, data_vencimento = ?, preco = ?" +
            "medida = ?, estoque_max = ?, estoque_min = ? WHERE id = ?";
    final String APAGAR = "DELETE FROM produto WHERE id = ?";

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

    @Override
    public void salvarProduto(Produto produto) {
        try {
            Connection con = conexao();
            PreparedStatement salvar = con.prepareStatement(INSERIR);
            salvar.setString(1, produto.getNome());
            salvar.setString(2, produto.getDescricao());
            salvar.setDouble(3, produto.getPreco());
            salvar.setDouble(4, produto.getQuantidade());
            salvar.setDouble(5, produto.getMedida());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERRO SALVANDO CONTA");
            System.exit(0);
        }

    }

    public void atualizarProduto(Produto produto) {
        try {
            Connection con = conexao();
            PreparedStatement autulizar = con.prepareStatement(ATUALIZAR);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERRO AO ATUALIZAR");
            System.exit(0);
        }
    }

    private Produto extraiProduto(ResultSet resultSet) throws SQLException,
            ParseException{
        Produto produto = new Produto();
        produto.setId(resultSet.getInt(1));
        produto.setNome(resultSet.getString(2));
        produto.setDescricao(resultSet.getString(3));
        produto.setPreco(resultSet.getDouble(4));
        produto.setQuantidade(resultSet.getDouble(5));
        produto.setMedida(resultSet.getDouble(6));
        return produto;
    }

    @Override
    public void apagarProduto(Produto produto) {
        try{
            Connection con = conexao();
            PreparedStatement apagar = con.prepareStatement(APAGAR);
            apagar.setInt(1, produto.getId());
            apagar.executeUpdate();
            apagar.close();
            con.close();
        }catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    @Override
    public List<Produto> buscarTodosOsProdutos() {
        List<Produto> produtos = new ArrayList<>();

        try {
            Connection con = conexao();
            PreparedStatement buscarTodos = con.prepareStatement(BUSCAR_TODOS);
            ResultSet resultadoBusca = buscarTodos.executeQuery();
            while (resultadoBusca.next()){
                Produto produto = extraiProduto(resultadoBusca);
                produtos.add(produto);
            }
            buscarTodos.close();
            con.close();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERRO BUSCANDO TODOS OS PRODUTOS");
            System.exit(0);
        }
        return produtos;
    }
}
