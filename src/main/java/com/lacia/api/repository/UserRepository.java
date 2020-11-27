package com.lacia.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.lacia.api.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("select u from User u where u.email = :email")
    User findByEmail(@Param("email") String email);
    
    @Query("select u from User u where u.idUsuario = :idUsuario")
    User findId(@Param("idUsuario") Integer idUsuario);
    
    @Query("select u from User u where u.tipoUsuario = :tipoUsuario and u.isAprovado = true")
    List<User> findByTipo(@Param("tipoUsuario") char tipoUsuario);
    
    @Query("select u from User u where u.tipoUsuario = :tipoUsuario and u.isAprovado is null")
    List<User> findAll(@Param("tipoUsuario") char tipoUsuario);
    
    @Query("select u from User u where u.idUsuario = :idUsuario and u.senha = :senha")
    User findByIdAndPassword(@Param("idUsuario") Integer idUsuario, @Param("senha") String senha);
 
    @Transactional
    @Modifying
    @Query("delete from User u where u.idUsuario = :idUsuario")
    void deleteById(@Param("idUsuario") Integer idUsuario);
    
    @Transactional
    @Modifying
    @Query("update User u set u.isAprovado = true where u.idUsuario = :idUsuario")
    void approveUser(@Param("idUsuario") Integer idUsuario);
    
    @Transactional
    @Modifying
    @Query("update User u set u.isAprovado = false where u.idUsuario = :idUsuario")
    void reproveUser(@Param("idUsuario") Integer idUsuario);
}