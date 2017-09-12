package br.com.cfi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.cfi.controller.page.PageWrapper;
import br.com.cfi.model.Empresa;
import br.com.cfi.model.Situacao;
import br.com.cfi.model.Tagenda;
import br.com.cfi.repository.AgendaRepository;
import br.com.cfi.repository.filter.AgendaFilter;
import br.com.cfi.repository.filter.EmpresaFilter;
import br.com.cfi.service.AgendaService;
import br.com.cfi.service.EmpresaService;

@Controller
@RequestMapping("/agendas")
public class AgendaController {
	@Autowired
	AgendaRepository agendaRepository;
	
	@Autowired
	AgendaService agendas;
	
	@Autowired
	EmpresaService empresas;
	
	@RequestMapping
	public ModelAndView pesquisa(@ModelAttribute("agendaFilter") AgendaFilter agendaFilter, BindingResult result,
			EmpresaFilter empresaFilter, @PageableDefault(size = 10) Pageable pageable,HttpServletRequest httpServletRequest){
		ModelAndView mv = new ModelAndView("agenda-consultor/agendas");
		PageWrapper<Tagenda> pagina = new PageWrapper<>(agendas.filtroFuncaoAgenda(agendaFilter, pageable), httpServletRequest);
		mv.addObject("agendas", pagina);
		mv.addObject("situacoes", Situacao.values());
		mv.addObject("consultores", agendas.filtroFuncaoConsultor());
		return mv;
		
	}
	
	@RequestMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody List<Empresa> pesquisaSolicitante(EmpresaFilter empresaFilter){
		validarInputModal(empresaFilter);
		return empresas.pesquisaSolicitante(empresaFilter);
	}
	
	private void validarInputModal(EmpresaFilter empresaFilter){
		if(StringUtils.isEmpty(empresaFilter.getCpesquisa())){
			System.out.println(">>>>"+empresaFilter.getCpesquisa());
			throw new IllegalArgumentException();
		}
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Void> tratarIllegalArgumentException(IllegalArgumentException e){
		return ResponseEntity.badRequest().build();
	}
}
