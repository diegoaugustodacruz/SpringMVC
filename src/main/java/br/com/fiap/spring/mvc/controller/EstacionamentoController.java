package br.com.fiap.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.spring.mvc.dao.EstacionamentoDAO;
import br.com.fiap.spring.mvc.entity.Estacionamento;

@Controller
@RequestMapping("estacionamento")
public class EstacionamentoController {

	@Autowired
	private EstacionamentoDAO dao;
	
	@GetMapping("editar/{id}")
	public ModelAndView abrirFormEdicao(@PathVariable("id") int codigo) {
		return new ModelAndView("estacionamento/edicao").addObject("estacionamento", dao.buscar(codigo));
	}
	
	@PostMapping("editar")
	@Transactional
	public ModelAndView processarFormEdicao(Estacionamento estacionamento, RedirectAttributes attrs) {
		try {
			dao.atualizar(estacionamento);
			
		}catch(Exception e) {
			return new ModelAndView("estacionamento/edicao").addObject("msg", e.getMessage());
		}
		attrs.addFlashAttribute("msg", "Atualizado");
		return new ModelAndView("redirect:/estacionamento/listar");
	}
	
	@GetMapping("listar")
	public ModelAndView listar() {
		return new ModelAndView("estacionamento/lista").addObject("lista", dao.listar());
	}
	
	@GetMapping("cadastrar")
	public String abrirForm(Estacionamento estacionamento) {
		return "estacionamento/cadastro";
	}
	
	@PostMapping("cadastrar")
	@Transactional
	public ModelAndView processarForm(Estacionamento estacionamento, RedirectAttributes attr) {
		try {
			dao.cadastrar(estacionamento);
			attr.addFlashAttribute("msg", "Cadastro com sucesso");
			
		}catch(Exception e) {
			e.printStackTrace();
			return new ModelAndView("estacionamento/cadastro");
		}
		
		
		return new ModelAndView("redirect:/estacionamento/cadastrar");
		
	}
}
