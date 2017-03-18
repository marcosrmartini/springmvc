package br.com.mmartini.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mmartini.dao.ClienteDAOImpl;
import br.com.mmartini.model.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	private ClienteDAOImpl clienteDAO;
	
	public void setClienteDAO(ClienteDAOImpl clienteDAO){
		this.clienteDAO = clienteDAO;
	}

	@Override
	@Transactional
	public void adiciona(Cliente c) {
		this.clienteDAO.adiciona(c);		
	}

	@Override
	@Transactional
	public void atualiza(Cliente c) {
		this.clienteDAO.atualiza(c);
	}

	@Override
	@Transactional
	public void remove(int id) {
		this.clienteDAO.remove(id);
	}

	@Override
	@Transactional
	public List<Cliente> getList() {
		return this.clienteDAO.getList();
	}

	@Override
	@Transactional
	public Cliente getById(int id) {
		return (Cliente) this.clienteDAO.getById(id);
	}

}
