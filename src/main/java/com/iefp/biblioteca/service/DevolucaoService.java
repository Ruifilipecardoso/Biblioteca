package com.iefp.biblioteca.service;

import com.iefp.biblioteca.model.Devolucao;
import com.iefp.biblioteca.repository.DevolucaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevolucaoService {
    private final DevolucaoRepository devolucaoRepository;
    public DevolucaoService(DevolucaoRepository devolucaoRepository) {
        this.devolucaoRepository = devolucaoRepository;
    }

    public List<Devolucao> ListarDevolucao(){
        return devolucaoRepository.findAll();
    }

    public void guardarDevolucao(Devolucao devolucao){
        devolucaoRepository.save(devolucao);
    }
}
