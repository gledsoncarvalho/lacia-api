package com.lacia.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario_projeto")
public class UserProject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuarioProjeto;
	
	@ManyToOne
	@JoinColumn(name = "projeto_id_projeto")
	private Project project1;

	@ManyToOne
	@JoinColumn(name = "usuario_id_usuario")
	private User user1;
	
	public UserProject() { }

	public UserProject(Integer idUsuarioProjeto, Project project, User user) {
		this.idUsuarioProjeto = idUsuarioProjeto;
		this.project1 = project;
		this.user1 = user;
	}

	public Integer getIdUsuarioProjeto() {
		return idUsuarioProjeto;
	}

	public void setIdUsuarioProjeto(Integer idUsuarioProjeto) {
		this.idUsuarioProjeto = idUsuarioProjeto;
	}

	public Project getProject() {
		return project1;
	}

	public void setProject(Project project) {
		this.project1 = project;
	}

	public User getUser() {
		return user1;
	}

	public void setUser(User user) {
		this.user1 = user;
	}
	
	
}
