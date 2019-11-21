package com.bragamateus.socialbooks.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.bragamateus.socialbooks.domain.Comentario;
import com.bragamateus.socialbooks.domain.Livro;
import com.bragamateus.socialbooks.repository.ComentariosRepository;
import com.bragamateus.socialbooks.repository.LivrosRepository;
import com.bragamateus.socialbooks.services.exceptions.LivroNaoEncontradoException;

@Service
public class LivrosService {
	
	@Autowired
	private LivrosRepository livrosRepository;
	
	@Autowired
	private ComentariosRepository comentariosRepository;
	
	public List<Livro> listar(){
		return livrosRepository.findAll();
	}
	
	public Optional<Livro> buscar(Long id) {
		Optional<Livro> livro = livrosRepository.findById(id);
		
		if(!livro.isPresent()) {
			throw new LivroNaoEncontradoException("O livro não foi encontrado");
		}
		return livro;
	}
	
	public Livro salvar(Livro livro) {
		livro.setId(null);
		return livrosRepository.save(livro);
	}
	
	public void deletar(Long id) {
		try {
			livrosRepository.deleteById(id);
			
		} catch (EmptyResultDataAccessException e) {
			throw new LivroNaoEncontradoException("O livro não foi encontrado");
		}
		
	}
	
	public void atualizar(Livro livro) {
		verificarSeExiste(livro);
		livrosRepository.save(livro);
	}
	
	public void verificarSeExiste(Livro livro) {
		buscar(livro.getId());
	}
	
	public Comentario salvarComentario(Long livroId, Comentario comentario) {
		Optional<Livro> livro = buscar(livroId);
		
		comentario.setLivro(livro.get());
		comentario.setData(new Date());
		
		return comentariosRepository.save(comentario);
	}

}
