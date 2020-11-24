package com.lacia.api.dto;

import com.lacia.api.model.User;

public class UserAutheticatedDTO {
    private String tipo;
    private String email;
    private String nome;
    private String token;
    private char tipoUsuario;

    public UserAutheticatedDTO(String email, String nome, String token, char tipoUsuario, String tipo) {
        this.email = email;
        this.nome = nome;
        this.token = token;
        this.tipo = tipo;
        this.tipoUsuario = tipoUsuario;
    }

    public UserAutheticatedDTO(){}

    public static UserAutheticatedDTO toDTO(User user, String tipo) {
        return new UserAutheticatedDTO(user.getEmail(), user.getNome(), user.getToken(), user.getTipoUsuario(), tipo);
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
}
