package com.ulearn.ulearn.repository;

import com.ulearn.ulearn.model.Avaliacao;

import java.util.ArrayList;
import java.util.List;

public class AvaliacaoRepositorio {

    private List<Avaliacao> avaliacoes = new ArrayList<>();

    public AvaliacaoRepositorio() {
        adicionarAvaliacao(new Avaliacao(1,1));
    }

    public void adicionarAvaliacao (Avaliacao avaliacao){
        avaliacoes.add(avaliacao);
    }

    public void removerAvaliacaoPorIdAlunoIdCurso (int IdCurso,int IdAluno){
        avaliacoes.remove(buscar(IdCurso,IdAluno));
    }

    public Avaliacao buscar(int IdAluno, int Idcurso){
        for (Avaliacao avaliacao:avaliacoes){
            if (avaliacao.getIdAluno() == IdAluno && avaliacao.getIdCurso()== Idcurso) return avaliacao;
        }
        return null;
    }

}
