package br.com.senac.supfx.service;

import br.com.senac.supfx.model.Fornecedor;
import br.com.senac.supfx.repository.Fornecedores;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FornecedoresDBService implements Fornecedores {

    final String USUARIO = "root";
    final String SENHA = "root";
    final String URL_BANCO = "jdbc::mysql://localhost:3306/senac_crud_contas_fx";
    final String CLASSE_DRIVER = "com.mysql.jdbc.Driver";
    final String BUSCAR_TODOS = "SELEC id";
    final String FORMATO_DATA = "dd/mm/yyyy";
    final SimpleDateFormat FORMATADOR = new SimpleDateFormat(FORMATO_DATA);

    private Connection conexao() {
        try {
            Class.forName(CLASSE_DRIVER);
            return DriverManager.getConnection(URL_BANCO, USUARIO, SENHA);
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof ClassNotFoundException) {
                System.out.println("VEREFIQUE SE O DRIVER NO BANCO DE DADOS" +
                        "ESTA NO CLASSPATH DO PROJETO");
            } else {
                System.out.println("VEREFIQUE SE O BANCO DE DADOS ESTA" + "RODANDO E SE OS DADOS DE CONEXAO ESTAO CORRETOS");
            }
        }
        System.exit(0);
        return null;
    }

    @Override
    public List<Fornecedor> buscarTodosOsFornecedores() {
        List<Fornecedor> fornecedors = new ArrayList<>();

        try {
            Connection con = conexao();
            PreparedStatement buscarTodos = con.prepareStatement(BUSCAR_TODOS);
            ResultSet resultSet = buscarTodos.executeQuery();
            while (resultSet.next()){
                Fornecedor fornecedor = extraiFornecedor(resultSet);
                fornecedors.add(fornecedor);
            }
            buscarTodos.close();
            con.close();
        }catch (Exception e){

        }
        return fornecedors;
    }

    private Fornecedor extraiFornecedor(ResultSet resultSet) throws SQLException,
            ParseException {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(resultSet.getInt(1));
        fornecedor.setNome(resultSet.getString(2));
        fornecedor.setCNPJ(resultSet.getString(3));
        fornecedor.setNumero_NF(resultSet.getString(4));
        Date data_recebimento = FORMATADOR.parse(resultSet.getString(5));
        fornecedor.setData_recebimento(data_recebimento);
        return fornecedor;
    }

    @Override
    public Fornecedor buscarUmFornecedor(int id) {
        return null;
    }
}
