package com.iefp.biblioteca.controller;

import com.iefp.biblioteca.model.Bibliotecario;
import com.iefp.biblioteca.model.Livro;
import com.iefp.biblioteca.service.EmprestimoService;
import com.iefp.biblioteca.service.LivroService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LivroController {
    private final LivroService livroService;

    public LivroController(LivroService livroService, LivroService livroService1, EmprestimoService emprestimoService) {
        this.livroService = livroService;
    }

    @GetMapping("/livros")
    public String listarLivros(Model model, HttpSession session){
        Bibliotecario bibliotecario = (Bibliotecario) session.getAttribute("bibliotecarioLogado");

        if (bibliotecario == null) {
            return "redirect:/login";
        }

        model.addAttribute("bibliotecario", bibliotecario);
        model.addAttribute("lista", livroService.listarLivros());
        return "livros";
    }

    @PostMapping("/livros")
    public String adicionarLivro(String titulo, String categoria, String autor, Integer isbn, String estado, Integer estoque) {
        livroService.guardarLivro(titulo, categoria, autor, isbn, estado, estoque);
        return "redirect:/livros";
    }

}
