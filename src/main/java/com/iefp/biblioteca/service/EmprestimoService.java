package com.iefp.biblioteca.service;

import com.iefp.biblioteca.model.Emprestimo;
import com.iefp.biblioteca.repository.EmprestimoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmprestimoService {
    private final EmprestimoRepository emprestimoRepository;
    public EmprestimoService(EmprestimoRepository emprestimoRepository) {
        this.emprestimoRepository = emprestimoRepository;
    }

    public static void guardar(Emprestimo emprestimo) {
    }

    public List<Emprestimo> listarEmprestimos(){
        return emprestimoRepository.findAll();
    }

    public void guardarEmprestimo(Emprestimo emprestimo){
        emprestimoRepository.save(emprestimo);
    }
}
