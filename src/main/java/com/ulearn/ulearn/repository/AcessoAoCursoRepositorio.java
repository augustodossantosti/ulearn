package com.ulearn.ulearn.repository;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.ulearn.ulearn.model.AcessoAoCurso;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AcessoAoCursoRepositorio {

    private final ObjectContainer container;

    public AcessoAoCursoRepositorio () {
        container = Db4oEmbedded.openFile("bd/acessoAocurso.db4o");
        concederAcesso(new AcessoAoCurso(1, 1));
        concederAcesso(new AcessoAoCurso(3, 1));
        concederAcesso(new AcessoAoCurso(4, 1));
        concederAcesso(new AcessoAoCurso(1, 2));
        concederAcesso(new AcessoAoCurso(2, 2));
        concederAcesso(new AcessoAoCurso(2, 3));
        concederAcesso(new AcessoAoCurso(3, 3));
        concederAcesso(new AcessoAoCurso(1, 4));
        concederAcesso(new AcessoAoCurso(4, 4));
        concederAcesso(new AcessoAoCurso(3, 5));
        concederAcesso(new AcessoAoCurso(5, 5));
        concederAcesso(new AcessoAoCurso(6, 5));
        concederAcesso(new AcessoAoCurso(3, 6));
        concederAcesso(new AcessoAoCurso(5, 6));
        concederAcesso(new AcessoAoCurso(6, 6));
        concederAcesso(new AcessoAoCurso(7, 6));
    }

    public void concederAcesso(AcessoAoCurso acesso) {
        container.store(acesso);
    }

    public void revogarAcesso(int cursoId, int alunoId) {
       AcessoAoCurso acessoAoCurso = new AcessoAoCurso(cursoId,alunoId);
       container.delete(acessoAoCurso);
    }

    public List<AcessoAoCurso> buscarAcessosDoAluno(Integer alunoId) {
        AcessoAoCurso acessoAoCurso = new AcessoAoCurso();
        acessoAoCurso.setAlunoId(alunoId);
        return container.queryByExample(acessoAoCurso);
    }

    public List<Integer> cursosMaisAssinados() {
        return container.query(AcessoAoCurso.class)
                .stream().collect(Collectors.groupingBy(AcessoAoCurso::getCursoId, Collectors.counting())).entrySet()
                .stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).limit(6).collect(Collectors.toList())
                .stream().map(Map.Entry::getKey).collect(Collectors.toList());
    }
}
