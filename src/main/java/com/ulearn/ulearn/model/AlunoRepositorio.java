package com.ulearn.ulearn.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlunoRepositorio {

    private List<Aluno> alunos = new ArrayList<>();

    public AlunoRepositorio() {
        adicionarAluno(new Aluno("Hermes","asterix@obelix.uol.br", "cesar"));
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public boolean removerAlunoPorNome(String nome) {
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equals(nome)) {
                return alunos.remove(aluno);
            }
        }
        return false;
    }

    public Aluno buscarAlunoPorNome(String nome) {
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equals(nome)) {
                return aluno;
            }
        }
        return null;
    }

    public Aluno buscarAlunoPorEmail(String email) {
        for (Aluno aluno : alunos) {
            if (aluno.getEmail().equals(email)) {
                return aluno;
            }
        }
        return null;
    }

    public List<Aluno> listarAlunos() {
        return Collections.unmodifiableList(alunos);
    }
}
