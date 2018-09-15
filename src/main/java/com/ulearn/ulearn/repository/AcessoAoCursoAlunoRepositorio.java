package com.ulearn.ulearn.repository;

import com.ulearn.ulearn.model.AcessoAoCursoAluno;

import java.util.ArrayList;
import java.util.List;

public class AcessoAoCursoAlunoRepositorio {

    private List<AcessoAoCursoAluno> acessos = new ArrayList<>();

    public void concederAcesso(AcessoAoCursoAluno acesso) {
        acessos.add(acesso);
    }

    public void revogarAcesso(int cursoId, int alunoId) {
        for (AcessoAoCursoAluno acessoAoCursoAluno : acessos) {
            if (acessoAoCursoAluno.getCursoId() == cursoId &&
                    acessoAoCursoAluno.getAlunoId() == alunoId) {
                acessos.remove(acessoAoCursoAluno);
            }
        }
    }
}
