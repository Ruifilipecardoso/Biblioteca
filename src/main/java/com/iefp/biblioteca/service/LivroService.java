package com.iefp.biblioteca.service;

import com.iefp.biblioteca.model.Emprestimo;
import com.iefp.biblioteca.model.Livro;
import com.iefp.biblioteca.repository.EmprestimoRepository;
import com.iefp.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class LivroService {
    private final LivroRepository livroRepository;
    private final EmprestimoRepository emprestimoRepository;

    public LivroService(LivroRepository livroRepository, EmprestimoRepository emprestimoRepository) {
        this.livroRepository = livroRepository;
        this.emprestimoRepository = emprestimoRepository;
    }

    public void guardarLivro(String titulo, String categoria, String autor, Integer isbn, String estado, Integer estoque, Long emprestimoId) {
        Emprestimo emprestimo = emprestimoRepository.findById(emprestimoId).orElse(null);
        Livro livro = new Livro();
        livro.setTitulo(titulo);
        livro.setCategoria(categoria);
        livro.setAutor(autor);
        livro.setIsbn(isbn);
        livro.setEstado(estado);
        livro.setEstoque(estoque);
        livroRepository.save(livro);
    }


    public List<Livro> listarLivros(){
        return  livroRepository.findAll();
    }


}
