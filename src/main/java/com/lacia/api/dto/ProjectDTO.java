package com.lacia.api.dto;

import java.math.BigDecimal;
import java.sql.Date;

import com.lacia.api.model.Project;
import com.lacia.api.model.User;

public class ProjectDTO {

    private Integer idProjeto;
	private String titulo;
	private String descricao;
	private BigDecimal orcamento;
	private Date dataInicio;
	private Date dataFim;
	private Boolean aprovado;
    private String emailUsuario;
    
	public ProjectDTO(Integer idProjeto, String titulo, String descricao, BigDecimal orcamento, Date dataInicio,
			Date dataFim, Boolean aprovado, String emailUsuario) {
		this.idProjeto = idProjeto;
		this.titulo = titulo;
		this.descricao = descricao;
		this.orcamento = orcamento;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.aprovado = aprovado;
		this.emailUsuario = emailUsuario;
	}
	
	public Project toProject() {
		return new Project(getIdProjeto(), getTitulo(), getDescricao(), getOrcamento(), getDataInicio(), getDataFim(), isAprovado(), new User(null, null, getEmailUsuario() , null, null));
	}
	
    public static ProjectDTO toDTO(Project project) {
        return new ProjectDTO(project.getIdProjeto(), project.getTitulo(), project.getDescricao(), project.getOrcamento(), project.getDataInicio(), project.getDataFim(), project.isAprovado(), null);
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
		return aprovado;
	}

	public void setAprovado(Boolean aprovado) {
		this.aprovado = aprovado;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}
}
