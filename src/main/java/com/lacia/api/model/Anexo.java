package com.lacia.api.model;

import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Anexo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAnexo;
	private String nome;
	private String time;
	private String type;
	
}
