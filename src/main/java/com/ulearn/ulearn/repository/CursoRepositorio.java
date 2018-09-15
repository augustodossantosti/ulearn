package com.ulearn.ulearn.repository;

import com.ulearn.ulearn.model.Curso;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class CursoRepositorio {

    public CursoRepositorio() {
        adicionarCurso(new Curso(1, "Contabilidade", "Finanças", new ArrayList<>(), "Morette"));
    }

    private List<Curso> cursos = new ArrayList<>();

    public void adicionarCurso(Curso curso) {
        cursos.add(curso);
    }

    public Curso buscarCursoPorNome(String nome) {
        for (Curso curso: cursos) {
            if (curso.getNome().equalsIgnoreCase(nome)) {
                return curso;
            }
        }
        return null;
    }

    public List<Curso> listarCursos() {
        return Collections.unmodifiableList(cursos);
    }

}
