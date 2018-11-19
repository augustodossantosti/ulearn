package com.ulearn.ulearn.service;

import com.ulearn.ulearn.model.AcessoAoCurso;
import com.ulearn.ulearn.model.Curso;
import com.ulearn.ulearn.repository.AcessoAoCursoRepositorio;
import com.ulearn.ulearn.repository.CursoRepositorio;

import java.util.ArrayList;
import java.util.List;

public class AcessoAoCursoServico {

    private CursoRepositorio cursoRepositorio = new CursoRepositorio();
    private AcessoAoCursoRepositorio acessoAoCursoRepositorio = new AcessoAoCursoRepositorio();

    public List<Curso> listarCursos() {
        return cursoRepositorio.listarCursos();
    }

    public List<Curso> listarCursosDoAluno(Integer idAluno) {
        final List<AcessoAoCurso> acessos = acessoAoCursoRepositorio.buscarAcessosDoAluno(idAluno);
        final List<Curso> encontrados = new ArrayList<>();
        for (AcessoAoCurso acesso : acessos) {
            encontrados.add(cursoRepositorio.buscarCursoPorId(acesso.getCursoId()));
        }
        return encontrados;
    }

    public void adicionarCurso(Curso curso) {
        cursoRepositorio.adicionarCurso(curso);
    }

    public void removerCurso(int cursoId) {
        cursoRepositorio.removerCurso(cursoId);
    }

    public Curso buscarCurso(String nome) {
        return cursoRepositorio.buscarCursoPorNome(nome);
    }

    public Curso buscarCursoPorId(Integer id) {
        return cursoRepositorio.buscarCursoPorId(id);
    }

    public void concederAcesso(int cursoId, int alunoId) {
        final AcessoAoCurso acessoAoCurso = new AcessoAoCurso(cursoId, alunoId);
        acessoAoCursoRepositorio.concederAcesso(acessoAoCurso);
    }

    public void revogarAcesso(int cursoId, int alunoId) {
        acessoAoCursoRepositorio.revogarAcesso(cursoId, alunoId);
    }
}
