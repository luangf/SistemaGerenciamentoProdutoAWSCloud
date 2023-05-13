package br.com.apiproduto.service;

import java.util.List;

import br.com.apiproduto.entity.Produto;

//Contrato do serviço de produto
public interface ProdutoService {
	List<Produto> buscarTodos();
	Produto salvar(Produto produto);
	void delete(Long id);
}
