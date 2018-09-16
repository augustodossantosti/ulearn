package com.ulearn.ulearn.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Avaliacao {

    private Aluno aluno;
    private Curso curso;
    private Double nota;
    private Date data;
}
