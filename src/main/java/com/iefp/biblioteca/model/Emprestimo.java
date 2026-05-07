package com.iefp.biblioteca.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private LocalDate data;
    private LocalTime hora;
    private String estado;

    @ManyToOne
    private Bibliotecario bibliotecario;

  /*  @ManyToOne
    private Aluno aluno; */

    @OneToMany
    private List<Livro> livros;

   /* @OneToOne
    private Devolucao devolucao; */
}
