package com.lacia.api.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Checklist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idChecklist;
	private String titulo;
	@Column(name = "check_items")
	private Integer checkItens;
	@Column(name = "check_items_checked")
	private Integer checkItensChecked;

	@OneToMany(targetEntity = ItemChecklist.class)
    private List<ItemChecklist> itens;
	
	public Checklist() { }

	public Checklist(Integer idChecklist, String titulo, Integer checkItens, Integer checkItensChecked) {
		this.idChecklist = idChecklist;
		this.titulo = titulo;
		this.checkItens = checkItens;
		this.checkItensChecked = checkItensChecked;
	}

	public Integer getIdChecklist() {
		return idChecklist;
	}

	public void setIdChecklist(Integer idChecklist) {
		this.idChecklist = idChecklist;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getCheckItens() {
		return checkItens;
	}

	public void setCheckItens(Integer checkItens) {
		this.checkItens = checkItens;
	}

	public Integer getCheckItensChecked() {
		return checkItensChecked;
	}

	public void setCheckItensChecked(Integer checkItensChecked) {
		this.checkItensChecked = checkItensChecked;
	}

	public List<ItemChecklist> getItens() {
		return itens;
	}

	public void setItens(List<ItemChecklist> itens) {
		this.itens = itens;
	}
	
}