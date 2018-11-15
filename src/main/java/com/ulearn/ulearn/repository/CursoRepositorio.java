package com.ulearn.ulearn.repository;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.internal.ObjectContainerFactory;
import com.db4o.query.Query;
import com.ulearn.ulearn.model.Aluno;
import com.ulearn.ulearn.model.Aula;
import com.ulearn.ulearn.model.Curso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CursoRepositorio {

    private final ObjectContainer container;

    public CursoRepositorio(){
        container = Db4oEmbedded.openFile("bd/cursos.db4o");
    }

    public List<Curso> listarAlunos() {
        final List<Curso> cursos = container.queryByExample(Curso.class);
        return Collections.unmodifiableList(cursos);
    }
    public void adicionarCurso(Curso curso) {
        container.store(curso);
    }

    public Curso buscarCursoPorNome(String nome) {
        final Curso curso = new Curso();
        curso.setNome(nome);
        final ObjectSet<Curso> result = container.queryByExample(curso);
        return result.hasNext() ? result.next() : null;
    }

    public List<Curso> buscarCursoPorId(Integer id) {
        final Curso curso = new Curso();
        curso.setId(id);
        return container.queryByExample(curso);
    }

    public void removerCurso(int cursoId) {
        final Curso curso = new Curso();
        curso.setId(cursoId);
        container.delete(curso);
    }

    public List<Curso> listarCursos () {
        final List<Curso> cursos = container.queryByExample(Curso.class);
        return Collections.unmodifiableList(cursos);
    }

}
