package com.ulearn.ulearn.repository;

import com.ulearn.ulearn.model.Aula;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AulaRepositorio {

    private List<Aula> aulas = new ArrayList<>();

    public AulaRepositorio () {
        adicionarAula(new Aula(1,"sono",1,"youtube"));
    }

    public void adicionarAula (Aula aula) {
        aulas.add(aula);
    }

    public void removerAulaPorIdCurso (int id) {
        aulas.remove(buscarPorIDAula(id));
    }

    public Aula buscarPorNomeAula (String nome) {
        for (Aula aula: aulas){
            if (aula.getNome().equals(nome)) return aula;
        }
        return null;
    }


    public Aula buscarPorIDAula (int id) {
        for (Aula aula: aulas){
            if (aula.getId() == id) return aula;
        }
        return null;
    }

    public List<Aula> listarAulas () {
        return Collections.unmodifiableList(aulas);
    }
}
