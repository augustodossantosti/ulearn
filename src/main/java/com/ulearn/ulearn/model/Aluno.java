package com.ulearn.ulearn.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Aluno {

    private Long id;
    private String nome;
    private String email;
    private String senha;
    private final List<Avaliacao> avaliacoes = new ArrayList<>();
}
