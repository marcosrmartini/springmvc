package br.com.mmartini.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.mmartini.model.Produto;
import br.com.mmartini.service.ProdutoService;

@Controller
public class ProdutoController {

	private static final Logger log = LoggerFactory
			.getLogger(ProdutoController.class);


	private ProdutoService produtoService;
	
	@Autowired(required = true)
	@Qualifier(value = "produtoService")
	public void setProdutoService(ProdutoService ps){
		this.produtoService = ps;
	}

	@RequestMapping(value = "/produtos", method = RequestMethod.GET)
	public String listProdutos(Model model) {
		model.addAttribute("produto", new Produto());
		model.addAttribute("listProdutos", this.produtoService.getList());
		return "produto";
	}

	// For add and update person both
	@RequestMapping(value = "/produto/adiciona", method = RequestMethod.POST)
	public String adicionaProduto(@ModelAttribute("produto") Produto p) {

		if (p.getId() == 0) {
			// new person, add it
			this.produtoService.adiciona(p);
		} else {
			// existing person, call update
			this.produtoService.atualiza(p);
		}

		return "redirect:/produtos";

	}

	@RequestMapping("/removeProduto/{id}")
	public String removeProduto(@PathVariable("id") int id) {
		log.info("Produto a ser removido " + id);
		this.produtoService.remove(id);
		return "redirect:/produtos";
	}

	@RequestMapping("/alteraProduto/{id}")
	public String alteraProdutos(@PathVariable("id") int id, Model model) {
		model.addAttribute("produto", this.produtoService.getById(id));
		model.addAttribute("listProdutos", this.produtoService.getList());
		return "produto";
	}
	
	
	
}





