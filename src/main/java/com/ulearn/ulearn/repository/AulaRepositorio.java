package com.ulearn.ulearn.repository;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.ulearn.ulearn.model.Aula;

import java.util.Collections;
import java.util.List;

public class AulaRepositorio {

    private final ObjectContainer container;

    public AulaRepositorio () {
        container = Db4oEmbedded.openFile("bd/aulas.db4o");
    }

    public void adicionarAula (Aula aula) {
        container.store(aula);
    }

    public Aula buscarPorNomeAula (String nome) {
        final Aula aula = new Aula();
        aula.setNome(nome);
        final ObjectSet<Aula> result = container.queryByExample(aula);
        return result.hasNext() ? result.next() : null;
    }

    public List<Aula> buscarPorIdDoCurso(int idCurso) {
        final Aula aula = new Aula();
        aula.setCursoId(idCurso);
        return container.queryByExample(aula);
    }

    public List<Aula> listarAulas () {
        final List<Aula> aulas = container.queryByExample(Aula.class);
        return Collections.unmodifiableList(aulas);
    }
}
