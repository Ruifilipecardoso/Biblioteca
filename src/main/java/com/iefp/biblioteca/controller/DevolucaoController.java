package com.iefp.biblioteca.controller;

import com.iefp.biblioteca.model.Devolucao;
import com.iefp.biblioteca.repository.DevolucaoRepository;
import com.iefp.biblioteca.service.DevolucaoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class DevolucaoController {
    private final DevolucaoService devolucaoService;
    public DevolucaoController(DevolucaoService  devolucaoService){
        this.devolucaoService = devolucaoService;
    }

    @GetMapping("/devolucoes")
    public String adicionarDevolucao(@RequestParam Long id, @RequestParam LocalDate dataDevolucao,@RequestParam String estado){
        Devolucao devolucao = new Devolucao(null, dataDevolucao, estado, null);
        devolucaoService.guardarDevolucao(devolucao);
        return "redirect:/devolucoes";
    }
}
