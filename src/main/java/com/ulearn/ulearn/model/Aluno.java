package com.ulearn.ulearn.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Aluno {

    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private final List<Avaliacao> avaliacoes = new ArrayList<>();

    public Aluno() {}

    public Aluno(Integer id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

}
