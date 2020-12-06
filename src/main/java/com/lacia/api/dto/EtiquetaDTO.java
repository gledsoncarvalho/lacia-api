package com.lacia.api.dto;

import com.lacia.api.model.Etiqueta;

public class EtiquetaDTO {
	
	private Integer idEtiqueta;
	private String nome;
	private String cor;
	private Integer idProjeto;
	
	public EtiquetaDTO() {}

	public EtiquetaDTO(Integer idEtiqueta, String nome, String cor, Integer idProjeto) {
		this.idEtiqueta = idEtiqueta;
		this.nome = nome;
		this.cor = cor;
		this.idProjeto = idProjeto;
	}
	
	public static Etiqueta toEtiqueta(EtiquetaDTO etiquetaDTO) {
		return new Etiqueta(etiquetaDTO.getIdEtiqueta(), etiquetaDTO.getNome(), etiquetaDTO.getCor(), etiquetaDTO.getIdProjeto());
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

	public Integer getIdProjeto() {
		return idProjeto;
	}

	public void setIdProjeto(Integer idProjeto) {
		this.idProjeto = idProjeto;
	}
}
