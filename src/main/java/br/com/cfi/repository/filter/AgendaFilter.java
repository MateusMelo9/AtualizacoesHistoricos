package br.com.cfi.repository.filter;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class AgendaFilter {
	
	private Integer id;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataInicio = new Date();
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataFim = new Date();
	
	private String cnome_usuario = "";
	private Integer Nid_empresa = 0;
	private String cnome_empresa = "";
	private String Cstatus = "";
	
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
	public String getCnome_usuario() {
		return cnome_usuario;
	}
	public void setCnome_usuario(String cnome_usuario) {
		this.cnome_usuario = cnome_usuario;
	}
	public Integer getNid_empresa() {
		return Nid_empresa;
	}
	public void setNid_empresa(Integer nid_empresa) {
		Nid_empresa = nid_empresa;
	}
	public String getCnome_empresa() {
		return cnome_empresa;
	}
	public void setCnome_empresa(String cnome_empresa) {
		this.cnome_empresa = cnome_empresa;
	}
	public String getCstatus() {
		return Cstatus;
	}
	public void setCstatus(String cstatus) {
		Cstatus = cstatus;
	}
	
	

}
