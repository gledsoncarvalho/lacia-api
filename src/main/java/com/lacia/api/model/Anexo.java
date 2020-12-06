package com.lacia.api.model;


import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "anexo")
public class Anexo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAnexo;
	private String name;
	private String time;
	private String type;
	@Lob
	private Blob file;
	@Column(name = "cartao_tarefa_id_cartao_tarefa")
	private Integer idCartaoTarefa;
	
	public Anexo() {}


	public Anexo(Integer idAnexo, String name, String time, String type, Blob file, Integer idCartaoTarefa) {
		this.idAnexo = idAnexo;
		this.name = name;
		this.time = time;
		this.type = type;
		this.file = file;
		this.idCartaoTarefa = idCartaoTarefa;
	}


	public Integer getIdCartaoTarefa() {
		return idCartaoTarefa;
	}

	public void setIdCartaoTarefa(Integer idCartaoTarefa) {
		this.idCartaoTarefa = idCartaoTarefa;
	}

	public Integer getIdAnexo() {
		return idAnexo;
	}

	public void setIdAnexo(Integer idAnexo) {
		this.idAnexo = idAnexo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
