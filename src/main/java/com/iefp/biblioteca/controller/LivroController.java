package com.iefp.biblioteca.controller;

import com.iefp.biblioteca.model.Livro;
import com.iefp.biblioteca.service.LivroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LivroController {
    private final LivroService livroService;

    public LivroController(LivroService livroService, LivroService livroService1) {
        this.livroService = livroService;
    }

    @GetMapping("/livros")
    public String listarLivros(@RequestParam Long id, @RequestParam String titulo, @RequestParam String categoria, @RequestParam String autor, @RequestParam Integer isbn, @RequestParam String estado, @RequestParam Integer estoque) {
        Livro livro = new Livro(null, titulo, categoria,autor, isbn, estado, estoque, null);
        livroService.guardar(livro);
        return "redirect:/livros";
    }
}
