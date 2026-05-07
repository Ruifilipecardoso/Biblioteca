package com.iefp.biblioteca.repository;

import com.iefp.biblioteca.model.Aluno;
import com.iefp.biblioteca.model.Bibliotecario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
