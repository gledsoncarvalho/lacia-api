package com.lacia.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Etiqueta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEtiqueta;
	private String nome;
	private String cor;
	@Column(name = "projeto_id_projeto")
	private Integer idProjeto;
	
	public Etiqueta() { }

	public Etiqueta(Integer idEtiqueta, String nome, String cor, Integer idProjeto) {
		this.idEtiqueta = idEtiqueta;
		this.nome = nome;
		this.cor = cor;
		this.idProjeto = idProjeto;
	}

	public Integer getIdProjeto() {
		return idProjeto;
	}

	public void setIdProjeto(Integer idProjeto) {
		this.idProjeto = idProjeto;
	}

	public Integer getIdEtiqueta() {
		return idEtiqueta;
	}

	public void setIdEtiqueta(Integer idEtiqueta) {
		this.idEtiqueta = idEtiqueta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
}
