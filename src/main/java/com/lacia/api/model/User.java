package com.lacia.api.model;

import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    @Column
	private String nome;
    @Column
    private String email;
    @Column
    private String senha;
    @Column
    private String telefone;
    @Column
    private Date dataNascimento;
    @Column
    private String cpf;
    @Column(name = "tipo")
    private char tipoUsuario;
    @Column
    @Lob
    private byte[] fotoPerfil;
    @Column
    private Boolean isAprovado;
    @Transient
    private String token;
    
    public User(Integer idUsuario, String nome, String email, String telefone, Date dataNascimento) {
    	this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }

    
	public User(Integer idUsuario, String nome, String email, String senha){
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public User(Integer idUsuario, String nome, String email, String senha, String telefone, char tipoUsuario, String cpf, byte[] fotoPerfil, Date dataNascimento){
        this.idUsuario = idUsuario;
    	this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.tipoUsuario = tipoUsuario;
        this.cpf = cpf;
        this.fotoPerfil = fotoPerfil;
        this.dataNascimento = dataNascimento;
    }

    public User(Integer idUsuario, String nome, String email, String telefone, Date dataNascimento, String cpf) {
    	this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }
    
    public User(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
    

    public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public char getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(char tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public byte[] getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(byte[] fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}
	
    public Boolean isAprovado() {
		return isAprovado;
	}

	public void setAprovado(Boolean isAprovado) {
		this.isAprovado = isAprovado;
	}


}
