package com.iefp.biblioteca.controller;

import com.iefp.biblioteca.model.Bibliotecario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BibliotecarioController {
    private List<Bibliotecario> bibliotecario = new ArrayList<>();

    @GetMapping("/login")
    public String mostrarLogin(Model model){
        model.addAttribute("bibliotecarios", bibliotecario);
        return "login";
    }

    @PostMapping("/login")
    public String fazerLogin(@RequestParam String nome, @RequestParam int id_bibliotecario,
                                    @RequestParam String password){
        bibliotecario.add(new Bibliotecario(nome, id_bibliotecario, password));
        return "redirect:/login";
    }
}
