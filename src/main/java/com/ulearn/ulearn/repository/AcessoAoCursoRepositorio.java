package com.ulearn.ulearn.repository;

import com.ulearn.ulearn.model.AcessoAoCurso;

import java.util.ArrayList;
import java.util.List;

public class AcessoAoCursoRepositorio {

    private List<AcessoAoCurso> acessos = new ArrayList<>();

    public void concederAcesso(AcessoAoCurso acesso) {
        acessos.add(acesso);
    }

    public void revogarAcesso(int cursoId, int alunoId) {
        for (AcessoAoCurso acessoAoCurso : acessos) {
            if (acessoAoCurso.getCursoId() == cursoId &&
                    acessoAoCurso.getAlunoId() == alunoId) {
                acessos.remove(acessoAoCurso);
            }
        }
    }

    public List<AcessoAoCurso> buscarAcessosDoAluno(Integer alunoId) {
        final List<AcessoAoCurso> encontrados = new ArrayList<>();
        for (AcessoAoCurso acesso : acessos) {
            if (acesso.getAlunoId().equals(alunoId)) {
                encontrados.add(acesso);
            }
        }
        return encontrados;
    }
}
