package com.lacia.api.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ListaTarefa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idListaTarefa;
	private String nome;
	private Integer posicao;
	@Column(name = "projeto_id_projeto")
    private Integer idProjeto;
	
	@OneToMany(targetEntity = CartaoTarefa.class, mappedBy = "idListaTarefa")
	private List<CartaoTarefa> cartaoTarefaList;
	
	public ListaTarefa() { }

	public ListaTarefa(Integer idListaTarefa, String nome, Integer posicao, Integer idProjeto) {
		this.idListaTarefa = idListaTarefa;
		this.nome = nome;
		this.posicao = posicao;
		this.idProjeto = idProjeto;
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

	public Integer getIdProjeto() {
		return idProjeto;
	}

	public void setIdProjeto(Integer idProjeto) {
		this.idProjeto = idProjeto;
	}

	public List<CartaoTarefa> getCartaoTarefaList() {
		return cartaoTarefaList;
	}

	public void setCartaoTarefaList(List<CartaoTarefa> cartaoTarefaList) {
		this.cartaoTarefaList = cartaoTarefaList;
	}
}
