package com.ulearn.ulearn.controller;

import com.ulearn.ulearn.model.Curso;
import com.ulearn.ulearn.model.CursoRepositorio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/cursos")
public class CursoController {

    private CursoRepositorio repositorio = new CursoRepositorio();

    @GetMapping
    public List<Curso> listarCursos() {
        return repositorio.getCursos();
    }

    @PostMapping
    public void adicionarCurso(Curso curso) {
        repositorio.adicionarCurso(curso);
    }

}
