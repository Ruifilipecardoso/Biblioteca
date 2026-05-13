package com.iefp.biblioteca.controller;


import com.iefp.biblioteca.model.Aluno;
import com.iefp.biblioteca.service.AlunoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AlunoController {
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping("/alunos")
    public String listaDeAlunos(Model model){
        model.addAttribute("listaDeAlunos", alunoService.listarAlunos());
        return "alunos";
    }

    @PostMapping("/alunos")
    public String adicionarAluno(
            @RequestParam String nome,
            @RequestParam int numeroAluno) {

        Aluno aluno = new Aluno(null, nome, numeroAluno, null);

        alunoService.guardarAluno(aluno);

        return "redirect:/alunos";
    }
}

