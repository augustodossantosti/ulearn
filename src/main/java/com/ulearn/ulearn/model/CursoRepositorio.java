package com.ulearn.ulearn.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CursoRepositorio {

    public CursoRepositorio() {
        adicionarCurso(new Curso("Contabilidade", "Finanças", 150.0, new ArrayList<>(),
                "Morette"));
    }

    private List<Curso> cursos = new ArrayList<>();

    public void adicionarCurso(Curso curso) {
        cursos.add(curso);
    }


}
