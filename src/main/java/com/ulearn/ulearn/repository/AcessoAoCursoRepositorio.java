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
        concederAcesso(new AcessoAoCurso(1, "user1"));
        concederAcesso(new AcessoAoCurso(3, "user1"));
        concederAcesso(new AcessoAoCurso(4, "user1"));
        concederAcesso(new AcessoAoCurso(1, "user2"));
        concederAcesso(new AcessoAoCurso(2, "user2"));
        concederAcesso(new AcessoAoCurso(2, "user3"));
        concederAcesso(new AcessoAoCurso(3, "user3"));
        concederAcesso(new AcessoAoCurso(1, "user4"));
        concederAcesso(new AcessoAoCurso(4, "user4"));
        concederAcesso(new AcessoAoCurso(3, "user5"));
        concederAcesso(new AcessoAoCurso(5, "user5"));
        concederAcesso(new AcessoAoCurso(6, "user5"));
        concederAcesso(new AcessoAoCurso(3, "user6"));
        concederAcesso(new AcessoAoCurso(5, "user6"));
        concederAcesso(new AcessoAoCurso(6, "user6"));
        concederAcesso(new AcessoAoCurso(7, "user6"));
    }

    public void concederAcesso(AcessoAoCurso acesso) {
        container.store(acesso);
    }

    public void revogarAcesso(int cursoId, String username) {
       AcessoAoCurso acessoAoCurso = new AcessoAoCurso(cursoId, username);
       container.delete(acessoAoCurso);
    }

    public List<AcessoAoCurso> buscarAcessosDoAluno(String username) {
        AcessoAoCurso acessoAoCurso = new AcessoAoCurso();
        acessoAoCurso.setUsername(username);
        return container.queryByExample(acessoAoCurso);
    }

    public List<Integer> cursosMaisAssinados() {
        return container.query(AcessoAoCurso.class)
                .stream().collect(Collectors.groupingBy(AcessoAoCurso::getCursoId, Collectors.counting())).entrySet()
                .stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).limit(6).collect(Collectors.toList())
                .stream().map(Map.Entry::getKey).collect(Collectors.toList());
    }
}
