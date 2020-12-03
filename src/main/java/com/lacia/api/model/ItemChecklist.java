package com.lacia.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="items_checklist")
public class ItemChecklist {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_items_checklist")
	private Integer idItemChecklist;
	private String nome;
	private Boolean isChecked;
	
	public ItemChecklist() {}

	public ItemChecklist(Integer idItemChecklist, String nome, Boolean isChecked) {
		this.idItemChecklist = idItemChecklist;
		this.nome = nome;
		this.isChecked = isChecked;
	}

	public Integer getIdItemChecklist() {
		return idItemChecklist;
	}

	public void setIdItemChecklist(Integer idItemChecklist) {
		this.idItemChecklist = idItemChecklist;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getIsChecked() {
		return isChecked;
	}

	public void setIsChecked(Boolean isChecked) {
		this.isChecked = isChecked;
	}
	
	
}
