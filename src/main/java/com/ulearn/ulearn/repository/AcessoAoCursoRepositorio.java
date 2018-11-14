package com.ulearn.ulearn.repository;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.ulearn.ulearn.model.AcessoAoCurso;
import com.ulearn.ulearn.model.Aula;

import java.util.ArrayList;
import java.util.List;

public class AcessoAoCursoRepositorio {

    private final ObjectContainer container;

    public AcessoAoCursoRepositorio () {
        container = Db4oEmbedded.openFile("bd/acessoAocurso.db4o");
    }

    public void concederAcesso(AcessoAoCurso acesso) {
        container.store(acesso);
    }

    public AcessoAoCurso revogarAcesso(int cursoId, int alunoId) {
       AcessoAoCurso acessoAoCurso = new AcessoAoCurso(cursoId,alunoId);
       final ObjectSet<AcessoAoCurso> result = container.queryByExample(acessoAoCurso);
       return result.hasNext() ? result.next() : null;
    }

    public List<AcessoAoCurso> buscarAcessosDoAluno(Integer alunoId) {
        AcessoAoCurso acessoAoCurso = new AcessoAoCurso();
        acessoAoCurso.setAlunoId(alunoId);
        return container.queryByExample(acessoAoCurso);
    }
}
