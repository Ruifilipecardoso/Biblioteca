package com.iefp.biblioteca.repository;

import com.iefp.biblioteca.model.Bibliotecario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BibliotecaRepository extends JpaRepository<Bibliotecario, Long> {
    @Query("SELECT b FROM Bibliotecario b WHERE b.id_bibliotecario = :idBibliotecario AND b.password = :password")
    Bibliotecario findByIdAndPassword(@Param("idBibliotecario") String id_bibliotecario, @Param("password") String password);
}
