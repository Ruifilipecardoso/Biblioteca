package com.iefp.biblioteca.service;

import com.iefp.biblioteca.model.Livro;
import com.iefp.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> obterTodosLivros(){
        return  livroRepository.findAll();
    }

    public void guardarLivro(Livro livro){
        livroRepository.save(livro);
    }

    public void guardar(Livro livro) {
    }
}
