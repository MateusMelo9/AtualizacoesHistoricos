package br.com.cfi.repository.filter;


public class EmpresaFilter {

	private Integer nid_empresa;
	private String cpesquisa;
	private String cnome_empresa;
	
	public Integer getNid_empresa() {
		return nid_empresa;
	}
	public void setNid_empresa(Integer nid_empresa) {
		this.nid_empresa = nid_empresa;
	}
	public String getCpesquisa() {
		return cpesquisa;
	}
	public void setCpesquisa(String cpesquisa) {
		this.cpesquisa = cpesquisa;
	}
	public String getCnome_empresa() {
		return cnome_empresa;
	}
	public void setCnome_empresa(String cnome_empresa) {
		this.cnome_empresa = cnome_empresa;
	}
	
	
}
