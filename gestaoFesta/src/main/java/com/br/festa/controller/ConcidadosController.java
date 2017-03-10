package com.br.festa.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
	
	/****
	 * o thymeleaf não suporta metodos HTTP DELETE e PUT. somente POST e GET
	 * 
	 * */ 
	
	@GetMapping(value="/convidados/{id}")
	public String deletar(@RequestParam ("id") String id){
	
		
			
		 Long idConvert = Long.parseLong(id);
		
		Convidado convidadoEncontrado= convidados.findOne(idConvert);
	    this.convidados.delete(convidadoEncontrado);	
		return "redirect:/convidados";
	}
}
