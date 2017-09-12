package br.com.cfi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="x_pesquisa")
public class Tagenda {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long nid_xpesquisa;
		
		@DateTimeFormat(pattern = "dd/MM/yyyy")
		@Temporal(TemporalType.DATE)
		private Date Ddata;
		
		private String Csemana;
		private String Chora;
		private String Cid_usu;
		private String Cnome_usuario;
		private Integer Nid_empresa;
		private String Cnome_empresa;
		private String Cobs;
		private String Cstatus;
		
		
		public Long getNid_xpesquisa() {
			return nid_xpesquisa;
		}
		public void setNid_xpesquisa(Long nid_xpesquisa) {
			this.nid_xpesquisa = nid_xpesquisa;
		}
		public Date getDdata() {
			return Ddata;
		}
		public void setDdata(Date ddata) {
			Ddata = ddata;
		}		
		public String getCid_usu() {
			return Cid_usu;
		}
		public void setCid_usu(String cid_usu) {
			Cid_usu = cid_usu;
		}
		public String getCsemana() {
			return Csemana;
		}
		public void setCsemana(String csemana) {
			Csemana = csemana;
		}
		public String getChora() {
			return Chora;
		}
		public void setChora(String chora) {
			Chora = chora;
		}
		public String getCnome_usuario() {
			return Cnome_usuario;
		}
		public void setCnome_usuario(String cnome_usuario) {
			Cnome_usuario = cnome_usuario;
		}
		public Integer getNid_empresa() {
			return Nid_empresa;
		}
		public void setNid_empresa(Integer nid_empresa) {
			Nid_empresa = nid_empresa;
		}
		public String getCnome_empresa() {
			return Cnome_empresa;
		}
		public void setCnome_empresa(String cnome_empresa) {
			Cnome_empresa = cnome_empresa;
		}
		public String getCobs() {
			return Cobs;
		}
		public void setCobs(String cobs) {
			Cobs = cobs;
		}
		public String getCstatus() {
			return Cstatus;
		}
		public void setCstatus(String cstatus) {
			Cstatus = cstatus;
		}
		
		
		
}
