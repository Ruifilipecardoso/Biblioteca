package com.iefp.biblioteca.repository;

import com.iefp.biblioteca.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo,Long> {
}
