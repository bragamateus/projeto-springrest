package com.bragamateus.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bragamateus.socialbooks.domain.Autor;

public interface AutoresRepository extends JpaRepository<Autor, Long> {

}
