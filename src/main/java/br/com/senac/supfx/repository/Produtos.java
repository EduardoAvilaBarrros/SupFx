package br.com.senac.supfx.repository;

import br.com.senac.supfx.model.Produto;
import br.com.senac.supfx.service.ProdutosDBService;

import java.util.List;

public interface Produtos {

    public void salvarProduto(Produto produto);
    public void atualizarProduto(Produto produto);
    public void apagarProduto(Produto produto);
    public List<Produto> buscarTodosOsProdutos();

    public static Produtos getNewInstance(){
        return new ProdutosDBService();
    }
}
