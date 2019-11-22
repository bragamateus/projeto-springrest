package com.bragamateus.socialbooks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bragamateus.socialbooks.domain.Autor;
import com.bragamateus.socialbooks.repository.AutoresRepository;
import com.bragamateus.socialbooks.services.exceptions.AutorExistenteException;
import com.bragamateus.socialbooks.services.exceptions.AutorNaoEncontradoException;

@Service
public class AutoresService {
	@Autowired
	private AutoresRepository autoresRepository;
	
	public List<Autor> listar(){
		return autoresRepository.findAll();
	}
	
	public Autor salvar(Autor autor) {
		if(autor.getId() != null) {
			Optional<Autor> a = autoresRepository.findById(autor.getId());
			
			if(a.isPresent()) {
				throw new AutorExistenteException("O autor já existe");
			}
		}
		
		return autoresRepository.save(autor);
	}
	
	public Optional<Autor> buscar(Long id) {
		Optional<Autor> autor = autoresRepository.findById(id);
		
		if(!autor.isPresent()) {
			throw new AutorNaoEncontradoException("O autor não foi encontrado");
		}
		return autor;
	}
}
