package br.com.senac.supfx.repository;

import br.com.senac.supfx.model.Fornecedor;
import br.com.senac.supfx.service.FornecedoresDBService;

import java.util.List;

public interface Fornecedores {
    public List<Fornecedor> buscarTodosOsFornecedores();

    public Fornecedor buscarUmFornecedor(int id);

    public static Fornecedores getNewInstance() {
        return new FornecedoresDBService();
    }
}
