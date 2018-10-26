package com.ulearn.ulearn.repository;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.internal.ObjectContainerFactory;
import com.ulearn.ulearn.model.Curso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CursoRepositorio {

    private ObjectContainer container;
    private List<Curso> cursos = new ArrayList<>();

    public CursoRepositorio() {
        container = ObjectContainerFactory
                .openObjectContainer(Db4oEmbedded.newConfiguration(), "bd/cursos.db4o");
        adicionarCurso(new Curso(1, "Redes", "Teoria", "Teste de curso",
                "www.qualquer.com.br", "Curso voltado ao sono", "Wellington"));
        adicionarCurso(new Curso(2, "Redes", "Teoria", "Teste de curso",
                "www.qualquer.com.br", "Curso voltado ao sono", "Wellington"));
    }

    public List<Curso> listarCursos() {
        return Collections.unmodifiableList(cursos);
    }

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

    public Curso buscarCursoPorId(Integer id) {
        for(Curso curso: cursos) {
            if (curso.getId().equals(id)) {
                return curso;
            }
        }
        return null;
    }

    public void removerCurso(int cursoId) {
        for (Curso curso : cursos) {
            if (curso.getId() == cursoId) {
                cursos.remove(curso);
            }
        }
    }

}
