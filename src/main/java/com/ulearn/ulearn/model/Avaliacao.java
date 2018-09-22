package com.ulearn.ulearn.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Avaliacao {

    private int IdAluno;
    private int IdCurso;
    private Double nota;
    private LocalDate data;
    private List<Pergunta> perguntas = new ArrayList<>();

    public Avaliacao (int idcurso, int idaluno) {
        this.nota = 0.0;
        this.IdCurso = idcurso;
        this.IdAluno = idaluno;
        this.data = LocalDate.now();
    }
}
