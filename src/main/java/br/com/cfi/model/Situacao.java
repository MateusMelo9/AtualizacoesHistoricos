package br.com.cfi.model;

public enum Situacao {
	
	AGENDADO(" "),
	REALIZADO("*"),
	NÃO_REALIZADO("C");
	
	private String descricao;
	
	private Situacao(String descricao) {
		// TODO Auto-generated constructor stub
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
