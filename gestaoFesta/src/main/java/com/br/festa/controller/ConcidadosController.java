package com.br.festa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.festa.model.Convidado;
import com.br.festa.repository.ConvidadosRepository;

@Controller
public class ConcidadosController {
	
	@Autowired
	private ConvidadosRepository convidados;
	
	@GetMapping("/convidados")
	public ModelAndView lista(){
		ModelAndView modelAndViww=new ModelAndView("ListaConvidados");
		modelAndViww.addObject("convidados", convidados.findAll());
		
		modelAndViww.addObject(new Convidado());
		return modelAndViww;
	}

	@PostMapping("/convidados")
	public String salvar(Convidado convidado){
		this.convidados.save(convidado);
		return "redirect:/convidados";
	}
}
