package com.ulearn.ulearn.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Aluno {
    private final String nome;
    private final String email;
    private final String senha;
    private final List<Avaliacao> avaliacoes = new ArrayList<>();

    public Aluno(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

}
