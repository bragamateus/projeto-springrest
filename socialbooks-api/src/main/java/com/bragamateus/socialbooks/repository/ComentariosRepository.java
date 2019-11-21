package com.bragamateus.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bragamateus.socialbooks.domain.Comentario;

public interface ComentariosRepository extends JpaRepository<Comentario, Long> {

}
