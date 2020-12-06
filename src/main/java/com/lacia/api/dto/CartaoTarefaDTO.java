package com.lacia.api.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.lacia.api.model.Anexo;
import com.lacia.api.model.CartaoTarefa;
import com.lacia.api.model.Checklist;
import com.lacia.api.model.Etiqueta;
import com.lacia.api.model.User;

public class CartaoTarefaDTO {

	private Integer idCartaoTarefa;
	private String titulo;
	private String descricao;
	private Integer posicao;
	private Date dataEntrega;
	private Integer idListaTarefa;
	private List<EtiquetaDTO> etiquetas;
	private List<UserProjectSaveDTO> users;
	private List<Anexo> anexos;
	private List<Checklist> checklists;
	
	public CartaoTarefaDTO() { }

	public CartaoTarefaDTO(Integer idCartaoTarefa, String titulo, String descricao, Integer posicao, Date dataEntrega,
			Integer idListaTarefa, List<EtiquetaDTO> etiquetas, List<UserProjectSaveDTO> users, List<Anexo> anexos,
			List<Checklist> checklists) {
		this.idCartaoTarefa = idCartaoTarefa;
		this.titulo = titulo;
		this.descricao = descricao;
		this.posicao = posicao;
		this.dataEntrega = dataEntrega;
		this.idListaTarefa = idListaTarefa;
		this.etiquetas = etiquetas;
		this.users = users;
		this.anexos = anexos;
		this.checklists = checklists;
	}
	
	public static CartaoTarefa toCartaoTarefa(CartaoTarefaDTO cartaoTarefaDTO) {
		return new CartaoTarefa(cartaoTarefaDTO.getIdCartaoTarefa(), cartaoTarefaDTO.getTitulo(), cartaoTarefaDTO.getDescricao(), cartaoTarefaDTO.getPosicao(), cartaoTarefaDTO.getDataEntrega(), cartaoTarefaDTO.getIdListaTarefa(), converterListaToEtiqueta(cartaoTarefaDTO.getEtiquetas()), converterListaToUser(cartaoTarefaDTO.getUsers()), cartaoTarefaDTO.getAnexos(), cartaoTarefaDTO.getChecklists());
	}
	
	public static List<User> converterListaToUser(List<UserProjectSaveDTO> usuarios){
    	List<User> users = new ArrayList<>();
    	for (UserProjectSaveDTO user : usuarios) {
    		users.add(UserProjectSaveDTO.toUser(user));
    	}
    	return users;
    }

	public static List<Etiqueta> converterListaToEtiqueta(List<EtiquetaDTO> etiquetasDTO){
    	List<Etiqueta> etiquetas = new ArrayList<>();
    	for (EtiquetaDTO etiquetaDTO: etiquetasDTO) {
    		etiquetas.add(EtiquetaDTO.toEtiqueta(etiquetaDTO));
    	}
    	return etiquetas;
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

	public Integer getIdListaTarefa() {
		return idListaTarefa;
	}

	public void setIdListaTarefa(Integer idListaTarefa) {
		this.idListaTarefa = idListaTarefa;
	}

	public List<EtiquetaDTO> getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(List<EtiquetaDTO> etiquetas) {
		this.etiquetas = etiquetas;
	}

	public List<UserProjectSaveDTO> getUsers() {
		return users;
	}

	public void setUsers(List<UserProjectSaveDTO> users) {
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
