package com.lacia.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lacia.api.model.ListaTarefa;

public interface ListaTarefaRepository extends JpaRepository<ListaTarefa, Integer>{

	@Query("select lt from ListaTarefa lt where lt.project.idProjeto = :idProjeto")
	List<ListaTarefa> findAllByIdProjeto(@Param("idProjeto") Integer idProjeto);
}
