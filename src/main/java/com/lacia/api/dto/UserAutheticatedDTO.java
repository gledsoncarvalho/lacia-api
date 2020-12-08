package com.lacia.api.dto;

import com.lacia.api.model.User;


public class UserAutheticatedDTO {
    private String tipo;
    private String email;
    private String nome;
    private String token;
    private char tipoUsuario;
    private byte[] fotoPerfil;

    public UserAutheticatedDTO(String email, String nome, String token, char tipoUsuario, String tipo, byte[] fotoPerfil) {
        this.email = email;
        this.nome = nome;
        this.token = token;
        this.tipo = tipo;
        this.tipoUsuario = tipoUsuario;
        this.fotoPerfil = fotoPerfil;
    }

    public UserAutheticatedDTO(){}

    public static UserAutheticatedDTO toDTO(User user, String tipo) {
        return new UserAutheticatedDTO(user.getEmail(), user.getNome(), user.getToken(), user.getTipoUsuario(), tipo, user.getFotoPerfil());
    }
    
    public String getEmail() {
        return email;
    }

	public String getNome() {
        return nome;
    }

    public String getToken() {
        return token;
    }

    public String getTipo() {
        return tipo;
    }

    public char getTipoUsuario() {
        return tipoUsuario;
    }

    public byte[] getFotoPerfil() {
		return fotoPerfil;
	}
}
