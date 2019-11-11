package com.bragamateus.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bragamateus.socialbooks.domain.Livro;

public interface LivrosRepository extends JpaRepository<Livro, Long> {
	
	

}
