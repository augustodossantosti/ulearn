package com.ulearn.ulearn.service;

import com.ulearn.ulearn.model.Alternativa;
import com.ulearn.ulearn.model.Avaliacao;
import com.ulearn.ulearn.model.Pergunta;
import com.ulearn.ulearn.repository.AvaliacaoRepositorio;

public class CalcularNota {

    private AvaliacaoRepositorio avaliacaoRepositorio = new AvaliacaoRepositorio();

    public Avaliacao calcularNota(int IdAluno, int IdCurso) {
        final Avaliacao avaliacao = avaliacaoRepositorio.buscar(IdAluno, IdCurso);
        for (Pergunta pergunta : avaliacao.getPerguntas()) {
            for (Alternativa alternativa : pergunta.listarAlternativas()) {
                if (alternativa.getEstaCorreta() && alternativa.getFoiSelecionada()) {
                    avaliacao.setNota(avaliacao.getNota() + 1);
                }
            }
        }
        return avaliacao;
    }

}
