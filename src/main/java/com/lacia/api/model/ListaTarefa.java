package com.lacia.api.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ListaTarefa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idListaTarefa;
	private String nome;
	private Integer posicao;
	
	@OneToMany(mappedBy = "listaTarefa")
	private List<CartaoTarefa> cartoesTarefas;
	@ManyToOne(targetEntity = Project.class)
    @JoinColumn(name = "projeto_id_projeto")
    private Project project;
	
	public ListaTarefa() { }

	public ListaTarefa(Integer idListaTarefa, String nome, Integer posicao, Project project) {
		this.idListaTarefa = idListaTarefa;
		this.nome = nome;
		this.posicao = posicao;
		this.project = project;
	}

	public Integer getIdListaTarefa() {
		return idListaTarefa;
	}

	public void setIdListaTarefa(Integer idListaTarefa) {
		this.idListaTarefa = idListaTarefa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getPosicao() {
		return posicao;
	}

	public void setPosicao(Integer posicao) {
		this.posicao = posicao;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<CartaoTarefa> getCartoesTarefas() {
		return cartoesTarefas;
	}

	public void setCartoesTarefas(List<CartaoTarefa> cartoesTarefas) {
		this.cartoesTarefas = cartoesTarefas;
	}
}
