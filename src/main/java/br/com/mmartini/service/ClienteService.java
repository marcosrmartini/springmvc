package br.com.mmartini.service;

import java.util.List;

import br.com.mmartini.model.Cliente;

public interface ClienteService {
	
	public void adiciona(Cliente c);
	public void atualiza(Cliente c);
	public void remove(int id);
	public List<Cliente> getList();
	public Cliente getById(int id);

}
