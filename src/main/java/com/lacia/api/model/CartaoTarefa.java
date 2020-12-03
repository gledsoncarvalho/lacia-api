package com.lacia.api.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class CartaoTarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCartaoTarefa;
	private String titulo;
	private String descricao;
	private Integer posicao;
	private Date dataEntrega;
	@ManyToOne(targetEntity = ListaTarefa.class)
    @JoinColumn(name = "lista_tarefa_id_lista_tarefa")
    private ListaTarefa listaTarefa;
	
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "etiqueta_has_cartao_tarefa",
    		joinColumns = {
    				 @JoinColumn(name = "cartao_tarefa_id_cartao_tarefa", referencedColumnName = "idCartaoTarefa",
                             nullable = false, updatable = false)},
            inverseJoinColumns = {
            		@JoinColumn(name = "etiqueta_id_etiqueta", referencedColumnName = "idEtiqueta",
                            nullable = false, updatable = false)})
    private List<Etiqueta> etiquetas = new ArrayList<>();
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "cartao_usuario",
    		joinColumns = {
    				 @JoinColumn(name = "cartao_tarefa_id_cartao_tarefa", referencedColumnName = "idCartaoTarefa",
                             nullable = false, updatable = false)},
            inverseJoinColumns = {
            		@JoinColumn(name = "usuario_id_usuario", referencedColumnName = "idUsuario",
                            nullable = false, updatable = false)})
    private List<User> users = new ArrayList<>();
    
    @OneToMany(targetEntity = Anexo.class)
    private List<Anexo> anexos;
	
    @OneToMany(targetEntity = Checklist.class)
    private List<Checklist> checklists;
    
	public CartaoTarefa() { }

	

	public CartaoTarefa(Integer idCartaoTarefa, String titulo, String descricao, Integer posicao, Date dataEntrega,
			ListaTarefa listaTarefa, List<Etiqueta> etiquetas, List<User> users, List<Anexo> anexos,
			List<Checklist> checklists) {
		this.idCartaoTarefa = idCartaoTarefa;
		this.titulo = titulo;
		this.descricao = descricao;
		this.posicao = posicao;
		this.dataEntrega = dataEntrega;
		this.listaTarefa = listaTarefa;
		this.etiquetas = etiquetas;
		this.users = users;
		this.anexos = anexos;
		this.checklists = checklists;
	}

	public Integer getIdCartaoTarefa() {
		return idCartaoTarefa;
	}

	public void setIdCartaoTarefa(Integer idCartaoTarefa) {
		this.idCartaoTarefa = idCartaoTarefa;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getPosicao() {
		return posicao;
	}

	public void setPosicao(Integer posicao) {
		this.posicao = posicao;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public ListaTarefa getListaTarefa() {
		return listaTarefa;
	}

	public void setListaTarefa(ListaTarefa listaTarefa) {
		this.listaTarefa = listaTarefa;
	}

	public List<Etiqueta> getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(List<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Anexo> getAnexos() {
		return anexos;
	}

	public void setAnexos(List<Anexo> anexos) {
		this.anexos = anexos;
	}

	public List<Checklist> getChecklists() {
		return checklists;
	}

	public void setChecklists(List<Checklist> checklists) {
		this.checklists = checklists;
	}
}