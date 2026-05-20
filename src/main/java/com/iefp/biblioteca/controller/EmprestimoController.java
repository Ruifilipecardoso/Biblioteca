package com.iefp.biblioteca.controller;

import com.iefp.biblioteca.model.Bibliotecario;
import com.iefp.biblioteca.model.Emprestimo;
import com.iefp.biblioteca.service.AlunoService;
import com.iefp.biblioteca.service.BibliotecarioService;
import com.iefp.biblioteca.service.EmprestimoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalTime;

@Controller
public class EmprestimoController {
    private final EmprestimoService emprestimoService;
    private final BibliotecarioService bibliotecarioService;
    private final AlunoService alunoService;

    public EmprestimoController(EmprestimoService emprestimoService, BibliotecarioService bibliotecarioService, AlunoService alunoService) {
        this.emprestimoService = emprestimoService;
        this.bibliotecarioService = bibliotecarioService;
        this.alunoService = alunoService;
    }

    @GetMapping("/emprestimos")
    public String listarEmprestimos(Model model, HttpSession session){
        Bibliotecario bibliotecario = (Bibliotecario) session.getAttribute("bibliotecarioLogado");

        if (bibliotecario == null) {
            return "redirect:/login";
        }

        model.addAttribute("bibliotecario", bibliotecario);
        model.addAttribute("listaEmprestimos", emprestimoService.listarEmprestimos());
        model.addAttribute("bibliotecarios", bibliotecarioService.listarTodos());
        model.addAttribute("alunos", alunoService.listarAlunos());
        return "emprestimos";
    }

    @PostMapping("/emprestimos")
    public String adicionarEmprestimo(LocalDate data, LocalTime hora, String estado, Long bibliotecarioId, Long alunoId, Long livroId){
        emprestimoService.guardarEmprestimo(data, hora, estado, bibliotecarioId, alunoId, livroId);
        return "redirect:/emprestimos";
    }

}
