package com.ulearn.ulearn.repository;

import com.ulearn.ulearn.model.Avaliacao;

import java.util.ArrayList;
import java.util.List;

public class AvaliacaoRepositorio {

    private List<Avaliacao> avaliacoes = new ArrayList<>();

    public AvaliacaoRepositorio() {
        gravarAvaliacao(new Avaliacao(1,1));
    }

    public void gravarAvaliacao(Avaliacao avaliacao){
        avaliacoes.add(avaliacao);
    }

    public Avaliacao buscar(int IdAluno, int Idcurso){
        for (Avaliacao avaliacao:avaliacoes){
            if (avaliacao.getIdAluno() == IdAluno && avaliacao.getIdCurso()== Idcurso) return avaliacao;
        }
        return null;
    }

}
