package com.ulearn.ulearn.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Curso {

    private int id;
    private String nome;
    private String categoria;
    private List<Aula> aulas;
    private String professor;
}
