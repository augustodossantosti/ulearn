package com.ulearn.ulearn.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Aluno {
    private String email;
    private String senha;
    private List<Nota> notas;

}
