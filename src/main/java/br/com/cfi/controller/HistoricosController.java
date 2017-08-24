package br.com.cfi.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cfi.repository.Empresarepository;
import br.com.cfi.repository.HistoricosRepository;
import br.com.cfi.repository.filter.EmpresaFilter;
import br.com.cfi.repository.filter.HistoricosFilter;
import br.com.cfi.service.EmpresaService;
import br.com.cfi.service.HistoricosService;

@Controller
@RequestMapping("/atualizacoes")
public class HistoricosController {

	@Autowired
	HistoricosService historicos;
	
	@Autowired
	EmpresaService empresas;
	
	@Autowired
	HistoricosRepository historicosRepository;
	
	@RequestMapping
	public ModelAndView pesquisa(@ModelAttribute("historicoFilter") HistoricosFilter historicoFilter,BindingResult result,EmpresaFilter empresaFilter , @PageableDefault(size = 10)Pageable pageable){
				
		ModelAndView mv = new ModelAndView("historicos/atualizacoes");
//		Page<Ophistorico> paginas = historicos.filtroTabela(historicoFilter, pageable);
		mv.addObject("empresas", empresas.pesquisaSolicitante(empresaFilter));
//		mv.addObject("paginas", historicos.filtroFuncaoSemFilter());
		mv.addObject("paginas", historicos.filtroFuncao(historicoFilter)); 
		mv.addObject("modulos", historicos.filtroFuncaoModulo());
		
		return mv;
	}
	
}
