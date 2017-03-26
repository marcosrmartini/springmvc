package br.com.mmartini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.mmartini.model.Cliente;
import br.com.mmartini.model.Produto;
import br.com.mmartini.service.ClienteService;

@Controller
public class ClienteController {
	
	private ClienteService clienteService;
	
	@Autowired(required = true)
	@Qualifier(value = "clienteService") 
	public void setClienteService(ClienteService cs){
		this.clienteService = cs;
	}
	
	@RequestMapping(value = "/clientes", method = RequestMethod.GET)
	public String listClientes(Model model) {
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("listClientes", this.clienteService.getList());
		return "cliente";
	}

	// For add and update person both
	@RequestMapping(value = "/cliente/adiciona", method = RequestMethod.POST)
	public String adicionaCliente(@ModelAttribute("cliente") Cliente c) {

		if (c.getId() == 0) {
			// new person, add it
			this.clienteService.adiciona(c);
		} else {
			// existing person, call update
			this.clienteService.atualiza(c);
		}

		return "redirect:/clientes";

	}

	@RequestMapping("/removeCliente/{id}")
	public String removeCliente(@PathVariable("id") int id) {
		this.clienteService.remove(id);
		return "redirect:/clientes";
	}

	@RequestMapping("/alteraCliente/{id}")
	public String alteraClientes(@PathVariable("id") int id, Model model) {
		model.addAttribute("cliente", this.clienteService.getById(id));
		model.addAttribute("listClientes", this.clienteService.getList());
		return "cliente";
	}
	

}
