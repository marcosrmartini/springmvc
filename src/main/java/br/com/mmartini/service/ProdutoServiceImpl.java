package br.com.mmartini.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mmartini.dao.ProdutoDAOImpl;
import br.com.mmartini.model.Produto;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	private ProdutoDAOImpl produtoDAO;

	public void setProdutoDAO(ProdutoDAOImpl personDAO) {
		this.produtoDAO = personDAO;
	}
	
	@Override
	@Transactional
	public void adiciona(Produto p) {
		this.produtoDAO.adiciona(p);		
	}

	@Override
	@Transactional
	public void atualiza(Produto p) {
		this.produtoDAO.atualiza(p);
	}

	@Override
	@Transactional
	public void remove(int id) {
		this.produtoDAO.remove(id);
	}

	@Override
	@Transactional
	public List<Produto> getList() {
		return this.produtoDAO.getList();
	}

	@Override
	@Transactional
	public Produto getById(int id) {
		return (Produto) this.produtoDAO.getById(id);
	}

}
