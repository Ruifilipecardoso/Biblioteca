package com.iefp.biblioteca.service;

import com.iefp.biblioteca.model.Aluno;
import com.iefp.biblioteca.model.Bibliotecario;
import com.iefp.biblioteca.model.Emprestimo;
import com.iefp.biblioteca.model.Livro;
import com.iefp.biblioteca.repository.AlunoRepository;
import com.iefp.biblioteca.repository.BibliotecaRepository;
import com.iefp.biblioteca.repository.EmprestimoRepository;
import com.iefp.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {
    private final EmprestimoRepository emprestimoRepository;
    private final BibliotecaRepository bibliotecaRepository;
    private final AlunoRepository alunoRepository;
    private final LivroRepository livroRepository;


    public EmprestimoService(EmprestimoRepository emprestimoRepository, BibliotecaRepository bibliotecaRepository, AlunoRepository alunoRepository, LivroRepository livroRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.bibliotecaRepository = bibliotecaRepository;
        this.alunoRepository = alunoRepository;
        this.livroRepository = livroRepository;
    }

    public void guardarEmprestimo(LocalDate data, LocalTime hora, String estado, Long bibliotecarioId, Long alunoId, Long livroId) {
        Optional <Bibliotecario> bibliotecario = bibliotecaRepository.findById(bibliotecarioId);
        Optional <Aluno> aluno = alunoRepository.findById(alunoId);
        Optional <Livro> livro = livroRepository.findById(livroId);
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setData(data);
        emprestimo.setHora(hora);
        emprestimo.setEstado(estado);
        emprestimo.setBibliotecario(bibliotecario.get());
        emprestimo.setAluno(aluno.get());
        emprestimo.setLivro(livro.get());
        emprestimoRepository.save(emprestimo);
    }

    public List<Emprestimo> listarEmprestimos(){
        return emprestimoRepository.findAll();
    }

}
