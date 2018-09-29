package com.ulearn.ulearn.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Curso {

    private Integer id;
    private String nome;
    private String categoria;
    private String resumo;
    private String linkCapa;
    private String descricao;
    private List<Aula> aulas;
    private String professor;

    public Curso (Integer id, String nome, String categoria, String resumo, String linkCapa,
                  String descricao, String professor) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.resumo = resumo;
        this.linkCapa = linkCapa;
        this.descricao = descricao;
        this.professor = professor;
    }

}
