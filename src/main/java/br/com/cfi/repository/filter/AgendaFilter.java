package br.com.cfi.repository.filter;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class AgendaFilter {
	
	private Integer id;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataInicio = new Date();
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataFim = new Date();
	
	private String cid_usu = "";
	private String cnome_usuario = "";
	private Integer id_empresa = 0;
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
	public String getCid_usu() {
		return cid_usu;
	}
	public void setCid_usu(String cid_usu) {
		this.cid_usu = cid_usu;
	}
	public String getCnome_usuario() {
		return cnome_usuario;
	}
	public void setCnome_usuario(String cnome_usuario) {
		this.cnome_usuario = cnome_usuario;
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
	public String getCstatus() {
		return Cstatus;
	}
	public void setCstatus(String cstatus) {
		Cstatus = cstatus;
	}
	
	

}
