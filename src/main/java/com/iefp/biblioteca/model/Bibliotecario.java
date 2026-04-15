package com.iefp.biblioteca.model;

public class Bibliotecario {
    private String nome;
    private int id_bibliotecario;
    private String password;

//Construtor
public Bibliotecario (String nome, int id_bibliotecario,String password){
    this.nome = nome;
    this.id_bibliotecario = id_bibliotecario;
    this.password = password;
}

public String getNome(){
    return nome;
}

public int getId_bibliotecario(){
    return id_bibliotecario;
}

public String getPassword(){
    return password;
}
}


