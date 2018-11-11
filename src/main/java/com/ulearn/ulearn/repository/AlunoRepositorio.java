package com.ulearn.ulearn.repository;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.ulearn.ulearn.model.Aluno;

import java.util.Collections;
import java.util.List;

public class AlunoRepositorio {

    private final ObjectContainer container;

    public AlunoRepositorio() {
        container = Db4oEmbedded.openFile("bd/alunos.db4o");
    }

    public void adicionarAluno(Aluno aluno) {
        container.store(aluno);
    }

    public void removerAlunoPorNome(String nome) {
        final List<Aluno> alunos = container.queryByExample(Aluno.class);
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equals(nome)) {
                container.delete(aluno);
            }
        }
    }

    public Aluno buscarAlunoPorNome(String nome) {
        final Aluno aluno = new Aluno();
        aluno.setNome(nome);
        final ObjectSet<Aluno> result = container.queryByExample(aluno);
        return result.hasNext() ? result.next() : null;
    }

    public Aluno buscarAlunoPorEmail(String email) {
        final Aluno aluno = new Aluno();
        aluno.setEmail(email);
        final ObjectSet<Aluno> result = container.queryByExample(aluno);
        return result.hasNext() ? result.next() : null;
    }

    public List<Aluno> listarAlunos() {
        final List<Aluno> alunos = container.queryByExample(Aluno.class);
        return Collections.unmodifiableList(alunos);
    }
}
