package br.com.cfi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.cfi.repository.filter.AgendaFilter;
import br.com.cfi.repository.filter.EmpresaFilter;
import br.com.cfi.service.AgendaService;
import br.com.cfi.service.EmpresaService;

@Controller
@RequestMapping("/agendas")
public class AgendaController {

	@Autowired
	AgendaService agendas;
	
	@Autowired
	EmpresaService empresas;
	
	@RequestMapping
	public ModelAndView pesquisa(@ModelAttribute("agendaFilter") AgendaFilter agendaFilter, BindingResult result, EmpresaFilter empresaFilter){
		ModelAndView mv = new ModelAndView("agenda-consultor/agendas");
		mv.addObject("agendas", agendas.filtroFuncaoAgenda(agendaFilter));
		mv.addObject("empresas", empresas.pesquisaSolicitante(empresaFilter));
		return mv;
	}
}
