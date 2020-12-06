package com.lacia.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lacia.api.model.CartaoTarefa;

public interface CartaoTarefaRepository extends JpaRepository<CartaoTarefa, Integer>{

	@Query("select ct from CartaoTarefa ct where ct.idListaTarefa = :idListaTarefa")
	List<CartaoTarefa> findAllByIdListaTarefa(@Param("idListaTarefa") Integer idListaTarefa);
}
