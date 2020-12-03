package com.lacia.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Etiqueta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEtiqueta;
	private String nome;
	private String cor;
	@ManyToOne(targetEntity = Project.class)
    @JoinColumn(name = "projeto_id_usuario")
    private Project project;
	
	public Etiqueta() { }

	public Etiqueta(Integer idEtiqueta, String nome, String cor, Project project) {
		this.idEtiqueta = idEtiqueta;
		this.nome = nome;
		this.cor = cor;
		this.project = project;
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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
}
