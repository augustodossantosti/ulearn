package com.ulearn.ulearn.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
public class Aula {

    private Integer id;
    private String nome;
    private Integer cursoId;
    private String linkAula;
}
