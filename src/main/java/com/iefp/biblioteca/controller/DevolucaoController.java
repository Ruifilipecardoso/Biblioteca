package com.iefp.biblioteca.controller;

import com.iefp.biblioteca.model.Devolucao;
import com.iefp.biblioteca.repository.DevolucaoRepository;
import com.iefp.biblioteca.service.DevolucaoService;
import com.iefp.biblioteca.service.EmprestimoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class DevolucaoController {
    private final DevolucaoService devolucaoService;
    private final EmprestimoService emprestimoService;

    public DevolucaoController(DevolucaoService  devolucaoService, EmprestimoService emprestimoService){

        this.devolucaoService = devolucaoService;
        this.emprestimoService = emprestimoService;
    }

    @GetMapping("/devolucoes")
    public String listarDevolucao(Model model) {
        model.addAttribute("lista", devolucaoService.ListarDevolucao());
        model.addAttribute("emprestimos", emprestimoService.listarEmprestimos());
        return "devolucoes";
    }

    @PostMapping("/devolucoes")
    public String adicionarDevolucao(Long emprestimoId, LocalDate dataDevolucao, String estado){
        devolucaoService.guardarDevolucao(emprestimoId, dataDevolucao, estado);
        return "redirect:/devolucoes";
    }
}
