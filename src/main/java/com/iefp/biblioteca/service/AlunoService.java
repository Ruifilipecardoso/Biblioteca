package com.iefp.biblioteca.service;

import com.iefp.biblioteca.model.Aluno;
import com.iefp.biblioteca.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> listarAlunos() {
        return alunoRepository.findAll();
    }

    public void guardarAluno(Aluno aluno) {
        alunoRepository.save(aluno);
    }

    public void guardar(Aluno aluno) {
    }
}
