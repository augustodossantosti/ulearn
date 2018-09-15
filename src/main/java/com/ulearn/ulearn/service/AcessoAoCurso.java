package com.ulearn.ulearn.service;

import com.ulearn.ulearn.model.AcessoAoCursoAluno;
import com.ulearn.ulearn.model.Curso;
import com.ulearn.ulearn.repository.AcessoAoCursoAlunoRepositorio;
import com.ulearn.ulearn.repository.CursoRepositorio;

import java.util.List;

public class AcessoAoCurso {

    private CursoRepositorio cursoRepositorio = new CursoRepositorio();

    private AcessoAoCursoAlunoRepositorio acessoAoCursoAlunoRepositorio = new AcessoAoCursoAlunoRepositorio();

    public List<Curso> listarCursos() {
        return cursoRepositorio.getCursos();
    }

    public void adicionarCurso(Curso curso) {
        cursoRepositorio.adicionarCurso(curso);
    }

    public void concederAcesso(int cursoId, int alunoId) {
        final AcessoAoCursoAluno acessoAoCursoAluno = new AcessoAoCursoAluno(cursoId, alunoId);
        acessoAoCursoAlunoRepositorio.concederAcesso(acessoAoCursoAluno);
    }

    public void revogarAcesso(int cursoId, int alunoId) {
        acessoAoCursoAlunoRepositorio.revogarAcesso(cursoId, alunoId);
    }
}
