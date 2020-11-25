package com.lacia.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lacia.api.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    
    @Query("select u from User u where u.idUsuario = :idUsuario")
    User findId(@Param("idUsuario") Integer idUsuario);
    
    @Query("select u from User u where u.tipoUsuario = :tipoUsuario")
    List<User> findByTipo(@Param("tipoUsuario") char tipoUsuario);
    
    @Query("select u from User u where u.idUsuario = :idUsuario and u.senha = :senha")
    User findByIdAndPassword(@Param("idUsuario") Integer idUsuario, @Param("senha") String senha);
}