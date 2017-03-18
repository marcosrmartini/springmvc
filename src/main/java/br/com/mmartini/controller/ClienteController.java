package br.com.mmartini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import br.com.mmartini.service.ClienteService;

@Controller
public class ClienteController {
	
	private ClienteService clienteService;
	
	@Autowired(required = true)
	@Qualifier(value = "clienteService") 
	public void setClienteService(ClienteService cs){
		this.clienteService = cs;
	}
	
	

}
