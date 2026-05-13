package com.iefp.biblioteca.controller;

import com.iefp.biblioteca.model.Livro;
import com.iefp.biblioteca.service.EmprestimoService;
import com.iefp.biblioteca.service.LivroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LivroController {
    private final LivroService livroService;
    private final EmprestimoService emprestimoService;

    public LivroController(LivroService livroService, LivroService livroService1, EmprestimoService emprestimoService) {
        this.livroService = livroService;
        this.emprestimoService = emprestimoService;
    }

    @GetMapping("/livros")
    public String listarLivros(Model model){
        model.addAttribute("lista", livroService.listarLivros());
        model.addAttribute("emprestimos", emprestimoService.listarEmprestimos());
        return "livros";
    }

    @PostMapping("/livros")
    public String adicionarLivro(String titulo, String categoria, String autor, Integer isbn, String estado, Integer estoque, Long emprestimoId) {
        livroService.guardarLivro(titulo, categoria, autor, isbn, estado, estoque, emprestimoId);
        return "redirect:/livros";
    }

}
