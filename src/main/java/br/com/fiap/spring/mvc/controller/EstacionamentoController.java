package br.com.fiap.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("cadastrar")
	public String abrirForm(Estacionamento estacionamento) {
		return "estacionamento/cadastro";
	}
	
	@PostMapping("cadastrar")
	@Transactional
	public ModelAndView processarForm(Estacionamento estacionamento, RedirectAttributes attr) {
		try {
			dao.cadastrar(estacionamento);
			
		}catch(Exception e) {
			e.printStackTrace();
			return new ModelAndView("estacionamento/cadastro");
		}
		
		
		attr.addFlashAttribute("msg", "Cadastro com sucesso");
		return new ModelAndView("redirect:/estacionamento/cadastrar");
		
	}
}
