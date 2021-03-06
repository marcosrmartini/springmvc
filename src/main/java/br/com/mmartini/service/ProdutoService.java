package br.com.mmartini.service;

import java.util.List;

import br.com.mmartini.model.Produto;

public interface ProdutoService {
	
	public void adiciona(Produto p);
	public void atualiza(Produto p);
	public void remove(int id);
	public List<Produto> getList();
	public Produto getById(int id);

}
