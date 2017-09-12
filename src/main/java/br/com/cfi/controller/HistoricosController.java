package br.com.cfi.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.cfi.controller.page.PageWrapper;
import br.com.cfi.model.Empresa;
import br.com.cfi.model.Ophistorico;
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
	public ModelAndView pesquisa(@ModelAttribute("historicoFilter") HistoricosFilter historicoFilter,BindingResult result,
			EmpresaFilter empresaFilter , @PageableDefault(size = 10)Pageable pageable,HttpServletRequest httpServletRequest){
				
		ModelAndView mv = new ModelAndView("historicos/atualizacoes");
		PageWrapper<Ophistorico> paginas = new PageWrapper<>(historicos.filtroFuncao(historicoFilter, pageable), httpServletRequest);
		mv.addObject("paginas", paginas);
//		mv.addObject("paginas", historicos.filtroFuncaoLista(historicoFilter)); 
		mv.addObject("modulos", historicos.filtroFuncaoModulo());
		
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
