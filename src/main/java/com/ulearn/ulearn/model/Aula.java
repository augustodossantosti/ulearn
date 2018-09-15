package com.ulearn.ulearn.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *  Representação das Aulas existentes
 *
 * @author Mateus das Piadinhas
 * @version 1.0 31/08/18
 */
@Getter
@Setter
@AllArgsConstructor
public class Aula {

    private int id;
    private String nome;
    private int cursoId;
    private String linkAula;
}
