package com.lacia.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.lacia.api.model.Project;
import com.lacia.api.model.User;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

    @Query("select p from Project p where p.user.idUsuario = :idUsuario")
    List<Project> findAllByUser(@Param("idUsuario") Integer idUsuario);
    
    @Query("select p from Project p where p.user.idUsuario <> :idUsuario and p.isAprovado is null")
    List<Project> findAll(@Param("idUsuario") Integer idUsuario);
    
    @Transactional
    @Modifying
    @Query("update Project p set p.isAprovado = true where p.idProjeto = :idProjeto")
    void approveProject(@Param("idProjeto") Integer idProjeto);
    
    @Transactional
    @Modifying
    @Query("update Project p set p.isAprovado = false where p.idProjeto = :idProjeto")
    void reproveProject(@Param("idProjeto") Integer idProjeto);
    
    @Query("select p from Project p where p.isAprovado = true")
    List<Project> findAllCadastrados();
    
    @Query("select p from Project p inner join UserProject up ON up.project1 = p where p.user = :user OR up.user1 = :user")
    List<Project> findAllByUserOrMember(@Param("user") User user);   
}
