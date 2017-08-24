package br.com.cfi.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "empresa")
@Table(name="empresa")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer nid_empresa;
	private String cnome_empresa;
	private String cpesquisa;
	
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
	public String getCpesquisa() {
		return cpesquisa;
	}
	public void setCpesquisa(String cpesquisa) {
		this.cpesquisa = cpesquisa;
	}
	
}
