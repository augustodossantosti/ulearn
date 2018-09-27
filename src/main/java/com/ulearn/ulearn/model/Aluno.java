package com.ulearn.ulearn.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Aluno {

    private String nome;
    private String email;
    private String senha;
    private final List<Avaliacao> avaliacoes = new ArrayList<>();

    public Aluno(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

}
