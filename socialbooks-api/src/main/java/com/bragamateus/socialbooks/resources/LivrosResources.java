package com.bragamateus.socialbooks.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bragamateus.socialbooks.domain.Livro;

@RestController
public class LivrosResources {
	
	@RequestMapping(value = "/livros", method = RequestMethod.GET)
	public List<Livro> listar() {
		
		Livro livro1 = new Livro("Rest Applicado");
		Livro livro2 = new Livro("Git passo-a-passo");
		
		Livro[] livros = {livro1, livro2};
		
		return Arrays.asList(livros);
		
		
	}

}
