package com.ulearn.ulearn.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Alternativa {
    private final Character opcao;
    private final String textoAlternativa;
    private final Boolean estaCorreta;
    private Boolean foiSelecionada;
}
