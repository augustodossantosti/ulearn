package com.ulearn.ulearn.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Pergunta {

    @Getter
    private final String enunciado;
    private final List<Alternativa> alternativas = new ArrayList<>();

    public Pergunta(String enunciado) {
        this.enunciado = enunciado;
    }

    public void adicionarAlternativa(Alternativa alternativa) {
        alternativas.add(alternativa);
    }

    public List<Alternativa> listarAlternativas() {
        return Collections.unmodifiableList(alternativas);
    }
}
