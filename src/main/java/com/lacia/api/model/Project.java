package com.lacia.api.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "projeto")
public class Project {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProjeto;
    @Column
	private String titulo;
    @Column
	private String descricao;
    @Column
	private BigDecimal orcamento;
    @Column
	private Date dataInicio;
    @Column
	private Date dataFim;
    @Column
	private Boolean isAprovado;
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "usuario_id_usuario")
    private User user;
	
    public Project() {
    	
    }
    
    public Project(Integer idProjeto, String titulo, String descricao, BigDecimal orcamento, Date dataInicio, Date dataFim,
    		Boolean isAprovado, User user) {
		super();
		this.idProjeto = idProjeto;
		this.titulo = titulo;
		this.descricao = descricao;
		this.orcamento = orcamento;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.isAprovado = isAprovado;
		this.user = user;
	}

	public Integer getIdProjeto() {
		return idProjeto;
	}
    
	public void setIdProjeto(Integer idProjeto) {
		this.idProjeto = idProjeto;
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
	
	public BigDecimal getOrcamento() {
		return orcamento;
	}
	
	public void setOrcamento(BigDecimal orcamento) {
		this.orcamento = orcamento;
	}
	
	public Date getDataInicio() {
		return dataInicio;
	}
	
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public Date getDataFim() {
		return dataFim;
	}
	
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	
	public Boolean isAprovado() {
		return isAprovado;
	}
	
	public void setAprovado(Boolean isAprovado) {
		this.isAprovado = isAprovado;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}
