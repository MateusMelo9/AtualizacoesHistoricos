package br.com.cfi.repository.filter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.format.annotation.DateTimeFormat;

public class HistoricosFilter {
	
	private Integer id;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataInicio = new Date();
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataFim = new Date();
	
	private String modulo ="";
	private Integer id_empresa = 0;
	private String cnome_empresa="";
	
	public Integer getId() {		
		return id;
	}
	public void setId(Integer id) {
		this.id = id;	
	}
	public Date getDataInicio() {		
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {		
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	public String getModulo() {
		return modulo;
	}
	public void setModulo(String modulo) {
		this.modulo = modulo;
	}
	public Integer getId_empresa() {
		return id_empresa;
	}
	public void setId_empresa(Integer id_empresa) {
		this.id_empresa = id_empresa;
	}
	public String getCnome_empresa() {
		return cnome_empresa;
	}
	public void setCnome_empresa(String cnome_empresa) {
		this.cnome_empresa = cnome_empresa;
	}
	
}
