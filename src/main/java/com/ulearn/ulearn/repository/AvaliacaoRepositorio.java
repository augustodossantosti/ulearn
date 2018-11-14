package com.ulearn.ulearn.repository;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.ulearn.ulearn.model.Aula;
import com.ulearn.ulearn.model.Avaliacao;

import java.util.ArrayList;
import java.util.List;

public class AvaliacaoRepositorio {

    private final ObjectContainer container;

    public AvaliacaoRepositorio() {
        container = Db4oEmbedded.openFile("bd/avaliacao.db4o");
    }

    public void gravarAvaliacao(Avaliacao avaliacao) {
        container.store(avaliacao);
    }

    public Avaliacao buscarAvaliacao(int Idcurso, int IdAluno) {
        final Avaliacao avaliacao = new Avaliacao();
        avaliacao.setIdAluno(IdAluno);
        avaliacao.setIdCurso(Idcurso);
        final ObjectSet<Avaliacao> result = container.queryByExample(avaliacao);
        return result.hasNext() ? result.next() : null;
    }
}