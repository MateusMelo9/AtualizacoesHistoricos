package br.com.cfi.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.com.cfi.model.Ophistorico;
import br.com.cfi.repository.HistoricosRepository;
import br.com.cfi.repository.filter.HistoricosFilter;

@Service
public class HistoricosService {
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private HistoricosRepository historicos;
	//filtroFuncaoOphistorico
	public Page<Ophistorico> filtroFuncao(HistoricosFilter filter, Pageable pageable){
		List<Ophistorico> lista = null;
		Page<Ophistorico> pages = null;
		Random random = new Random();
		int id = random.nextInt();
		
//		System.out.println(id+" "+filter.getDataInicio()+" "+filter.getDataFim()+" "+filter.getModulo()+" "+filter.getId_empresa());
		historicos.findByXpesquisaFuncaoOphistorico(id, filter.getDataInicio(), filter.getDataFim(), filter.getModulo(), filter.getId_empresa());
		pages = historicos.findByXpesquisa(id, pageable);
			
		
		return pages;
	}
	public List<Ophistorico> filtroFuncaoLista(HistoricosFilter filter){
		List<Ophistorico> lista = null;
		Page<Ophistorico> pages = null;
		Random random = new Random();
		int id = random.nextInt();
		
//		System.out.println(id+" "+filter.getDataInicio()+" "+filter.getDataFim()+" "+filter.getModulo()+" "+filter.getId_empresa());
		historicos.findByXpesquisaFuncaoOphistorico(id, filter.getDataInicio(), filter.getDataFim(), filter.getModulo(), filter.getId_empresa());
		lista = historicos.findByXpesquisaOphistorico(id);
			
		
		return lista;
	}
	
	public List<Ophistorico> filtroFuncaoSemFilter(){
		List<Ophistorico> lista = null;	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataInicio;
		Date dataFim;
		Random random = new Random();
		int id = random.nextInt();
		
		try {
			dataInicio = sdf.parse("01/01/2017");
			dataFim = sdf.parse("11/08/2017");
//			System.out.println(id+" "+filter.getDataInicio()+" "+filter.getDataFim()+" "+filter.getModulo()+" "+filter.getId_empresa());
			historicos.findByXpesquisaFuncaoOphistorico(id,dataInicio,dataFim,"",0);
//			historicos.findByXpesquisaFuncaoOphistorico(id, filter.getDataInicio(), filter.getDataFim(), filter.getModulo(), filter.getId_empresa());
			lista = historicos.findByXpesquisaOphistorico(id);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public List<Ophistorico> filtroFuncaoModulo(){
		List<Ophistorico> lista = null;
		Random random = new Random();
		int id = random.nextInt();
		
		historicos.findByFuncaoCprograma(id);
		lista=historicos.findByCprograma(id);
		
		return lista;
	}
	
	
	/*@SuppressWarnings("unchecked")
	public Page<Ophistorico> filtroTabela(HistoricosFilter filter,Pageable pageable){
		
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Ophistorico.class);
		
		int paginaAtual = pageable.getPageNumber();
		int totalRegistro = pageable.getPageSize();
		int primeiroRegistro = paginaAtual * totalRegistro;
		
		criteria.setFirstResult(primeiroRegistro);
		criteria.setMaxResults(totalRegistro);
		
		criteria.add(Restrictions.sqlRestriction("nid_op < 90"));
		
		return new PageImpl<>(criteria.list(), pageable, total());
	}*/

	/*private Long total() {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Ophistorico.class);
		criteria.add(Restrictions.sqlRestriction("(nid_op < 90)"));
		criteria.setProjection(Projections.rowCount());
			
		return (Long) criteria.uniqueResult();
	}*/	
	
}
