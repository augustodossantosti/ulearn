package com.ulearn.ulearn.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AcessoAoCurso {

    private Integer cursoId;
    private Integer alunoId;

    public AcessoAoCurso() {
    }

}
