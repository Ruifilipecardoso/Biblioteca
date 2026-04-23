package com.iefp.biblioteca.controller;

import com.iefp.biblioteca.model.Bibliotecario;
import com.iefp.biblioteca.repository.BibliotecaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BibliotecarioController {
    private final BibliotecaRepository repository;
    public BibliotecarioController(BibliotecaRepository repository){
        this.repository = repository;
    }


    @GetMapping("/registoBibliotecario")
    public String fazerRegistoBibliotecario(Model model){
        model.addAttribute("bibliotecarios", "Lista de bibliotecarios");
        model.addAttribute ("lista", repository.findAll());
        return "registoBibliotecario";
    }

    @PostMapping("/registoBibliotecario")
    public String fazerRegistoBibliotecario(@RequestParam String nome, @RequestParam int id_bibliotecario,
                                    @RequestParam String password){
        repository.save(new Bibliotecario(null, nome, id_bibliotecario, password));
        return "redirect:/registoBibliotecario";
    }
}
