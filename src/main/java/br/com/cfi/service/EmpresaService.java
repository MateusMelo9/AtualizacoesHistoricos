package br.com.cfi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cfi.model.Empresa;
import br.com.cfi.repository.Empresarepository;
import br.com.cfi.repository.filter.EmpresaFilter;

@Service
public class EmpresaService {

	@Autowired
	Empresarepository empresas;
	
	@Transactional(readOnly = true)
	public List<Empresa> pesquisaSolicitante(EmpresaFilter empresaFilter){
		List<Empresa> listaEmpresas = null;
		
		if(empresaFilter.getCpesquisa() != null){
			String cpesquisa = empresaFilter.getCpesquisa() == null ? "%" : empresaFilter.getCpesquisa();			
			listaEmpresas = empresas.findByCpesquisaContaining(cpesquisa.toUpperCase());
		}
		return listaEmpresas;
	}
	
}
