package com.iefp.biblioteca.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String titulo;
    private String categoria;
    private String autor;
    private Integer isbn;
    private String estado;
    private Integer estoque;


    @ManyToOne
    private Emprestimo emprestimo;
}
