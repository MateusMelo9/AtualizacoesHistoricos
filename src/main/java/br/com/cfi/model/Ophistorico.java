package br.com.cfi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.groovy.runtime.dgmimpl.arrays.IntegerArrayGetAtMetaMethod;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="x_pesquisa")
public class Ophistorico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long nid_xpesquisa;
	
	private Integer nid_op;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date ddata;
	
	private String cobs;
	private Integer nid_empresa;
	private String cnome_empresa;
	private String cprograma;
	private String cversao;	
	
	public Long getNid_xpesquisa() {
		return nid_xpesquisa;
	}
	public void setNid_xpesquisa(Long nid_xpesquisa) {
		this.nid_xpesquisa = nid_xpesquisa;
	}
	public Integer getNid_op() {
		return nid_op;
	}
	public void setNid_op(Integer nid_op) {
		this.nid_op = nid_op;
	}
	public Date getDdata() {
		return ddata;
	}
	public void setDdata(Date ddata) {
		this.ddata = ddata;
	}
	public String getCobs() {
		return cobs;
	}
	public void setCobs(String cobs) {
		this.cobs = cobs;
	}	
	public Integer getNid_empresa() {
		return nid_empresa;
	}
	public void setNid_empresa(Integer nid_empresa) {
		this.nid_empresa = nid_empresa;
	}
	public String getCnome_empresa() {
		return cnome_empresa;
	}
	public void setCnome_empresa(String cnome_empresa) {
		this.cnome_empresa = cnome_empresa;
	}
	public String getCprograma() {
		return cprograma;
	}
	public void setCprograma(String cprograma) {
		this.cprograma = cprograma;
	}
	public String getCversao() {
		return cversao;
	}
	public void setCversao(String cversao) {
		this.cversao = cversao;
	}		
	
}
