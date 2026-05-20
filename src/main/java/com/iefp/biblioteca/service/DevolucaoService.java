package com.iefp.biblioteca.service;

import com.iefp.biblioteca.model.Devolucao;
import com.iefp.biblioteca.model.Emprestimo;
import com.iefp.biblioteca.repository.DevolucaoRepository;
import com.iefp.biblioteca.repository.EmprestimoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DevolucaoService {
    private final DevolucaoRepository devolucaoRepository;
    private final EmprestimoRepository emprestimoRepository;

    public DevolucaoService(DevolucaoRepository devolucaoRepository, EmprestimoRepository emprestimoRepository) {
        this.devolucaoRepository = devolucaoRepository;
        this.emprestimoRepository = emprestimoRepository;
    }

    public void guardarDevolucao(Long emprestimoId, LocalDate dataDevolucao, String estado){
        Emprestimo emprestimo = emprestimoRepository.findById(emprestimoId).orElse(null);
        Devolucao devolucao = new Devolucao();
        devolucao.setDataDevolucao(dataDevolucao);
        devolucao.setEstado(estado);
        devolucao.setEmprestimo(emprestimo);

        devolucaoRepository.save(devolucao);
    }

    public List<Devolucao> ListarDevolucao(){
        return devolucaoRepository.findAll();
    }


}
