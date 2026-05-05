package com.iefp.biblioteca.controller;

import com.iefp.biblioteca.model.Bibliotecario;
import com.iefp.biblioteca.repository.BibliotecaRepository;
import com.iefp.biblioteca.service.BibliotecarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BibliotecarioController {
    private final BibliotecarioService bibliotecarioService;
    public BibliotecarioController(BibliotecarioService bibliotecaService){
        this.bibliotecarioService = bibliotecaService;
    }


    @GetMapping("/registoBibliotecario")
    public String fazerRegistoBibliotecario(Model model){
        model.addAttribute("bibliotecarios", "Lista de bibliotecarios");
        model.addAttribute ("lista", bibliotecarioService.listarTodos());
        return "registoBibliotecario";
    }

    @PostMapping("/registoBibliotecario")
    public String fazerRegistoBibliotecario(@RequestParam String nome, @RequestParam String id_bibliotecario,
                                    @RequestParam String password){
       Bibliotecario bibliotecario= new Bibliotecario(null, nome, id_bibliotecario, password, null);
        bibliotecarioService.guardar(bibliotecario);
        return "redirect:/registoBibliotecario";
    }
}
