package com.iefp.biblioteca.repository;

import com.iefp.biblioteca.model.Bibliotecario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BibliotecaRepository extends JpaRepository<Bibliotecario, Long> {
}
