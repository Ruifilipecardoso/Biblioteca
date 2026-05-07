package com.iefp.biblioteca.controller;

import com.iefp.biblioteca.model.Emprestimo;
import com.iefp.biblioteca.service.EmprestimoService;
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
    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @GetMapping("/emprestimos")
    public String emprestimos(Model model){
        model.addAttribute("listaEmprestimos", emprestimoService.listarEmprestimos());
        return "emprestimos";
    }

    @PostMapping
    public String adicionarEmprestimo(@RequestParam Long id, @RequestParam LocalDate data, @RequestParam LocalTime hora, @RequestParam String estado){
        Emprestimo emprestimo = new Emprestimo(null, data, hora, estado, null, null);
        EmprestimoService.guardar(emprestimo);
        return "redirect:/emprestimos";
    }

}
