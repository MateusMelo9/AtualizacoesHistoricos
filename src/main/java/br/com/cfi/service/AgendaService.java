package br.com.cfi.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.cfi.model.Tagenda;
import br.com.cfi.repository.AgendaRepository;
import br.com.cfi.repository.filter.AgendaFilter;

@Service
public class AgendaService {

	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private AgendaRepository agendas;
	
	public Page<Tagenda> filtroFuncaoAgenda(AgendaFilter filter,Pageable pageable){
		List<Tagenda> lista = null;
		Page<Tagenda> pages = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataInicio;
		Date dataFim;
		Random random = new Random();
		int id = random.nextInt();
		
		try {
			dataInicio = sdf.parse("01/01/2017");
			dataFim = sdf.parse("11/08/2017");
			Sort sort = orderBy();
			if(sort != null){
				Sort.Order order = sort.iterator().next();				
			}		
			agendas.findByFuncaoTagenda(id, filter.getDataInicio(), filter.getDataFim(), filter.getId_empresa(),filter.getCid_usu(), filter.getCstatus());
			pages=agendas.findByAllRandom(id,pageable);
			lista = agendas.findByXpesquisaFuncaoTagenda(id);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return pages;
	}
	
	private Sort orderBy(){
		return new Sort(Sort.Direction.DESC,"cid_usu");
	}
	
	public List<Tagenda> filtroFuncaoConsultor(){
		List<Tagenda> lista = null;
		Random random = new Random();
		int id = random.nextInt();
		
		agendas.findByFuncaoConsultor(id);
		lista = agendas.findByXpesquisaFuncaoTagenda(id);
		return lista;
	}
}
