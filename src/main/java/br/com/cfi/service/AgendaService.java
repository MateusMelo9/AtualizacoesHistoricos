package br.com.cfi.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public List<Tagenda> filtroFuncaoAgenda(AgendaFilter filter){
		List<Tagenda> lista = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataInicio;
		Date dataFim;
		Random random = new Random();
		int id = random.nextInt();
		
		try {
			dataInicio = sdf.parse("01/01/2017");
			dataFim = sdf.parse("11/08/2017");
			agendas.findByFuncaoTagenda(id, filter.getDataInicio(), filter.getDataFim(), filter.getNid_empresa(),filter.getCnome_empresa(), filter.getCstatus());
			lista=agendas.findByXpesquisaFuncaoTagenda(id);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return lista;
	}
}
