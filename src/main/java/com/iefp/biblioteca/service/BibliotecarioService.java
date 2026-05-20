package com.iefp.biblioteca.service;

import com.iefp.biblioteca.model.Bibliotecario;
import com.iefp.biblioteca.repository.BibliotecaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BibliotecarioService {

    private final BibliotecaRepository bibliotecaRepository;
    public BibliotecarioService(BibliotecaRepository bibliotecaRepository) {
        this.bibliotecaRepository = bibliotecaRepository;
    }
    public List<Bibliotecario> listarTodos(){
        return bibliotecaRepository.findAll();
    }

    public void guardar(Bibliotecario bibliotecario){
        bibliotecaRepository.save(bibliotecario);
    }

    public Bibliotecario autenticar(String id_bibliotecario, String password){
        return bibliotecaRepository.findByIdAndPassword(id_bibliotecario.trim(), password.trim());

    }


}
