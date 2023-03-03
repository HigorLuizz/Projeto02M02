package com.example.projeto02m02.Repositories;

import com.example.projeto02m02.Entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    @Query("select u from UsuarioEntity u where u.nome like %?1%")
    List<UsuarioEntity> findUserByName(String nome);

    @Query("select u from UsuarioEntity u where u.login = ?1")
    UsuarioEntity findUserByLogin(String login);
}
