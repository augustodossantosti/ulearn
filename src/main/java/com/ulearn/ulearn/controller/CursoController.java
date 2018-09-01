package com.ulearn.ulearn.controller;

import com.ulearn.ulearn.model.Curso;
import com.ulearn.ulearn.model.CursoRepositorio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/cursos")
@CrossOrigin(origins = "*")
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
