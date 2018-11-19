package com.ulearn.ulearn.controller;

import com.ulearn.ulearn.model.Aula;
import com.ulearn.ulearn.repository.AulaRepositorio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/aulas")
public class AulaController {

    private AulaRepositorio repositorio = new AulaRepositorio();

    @GetMapping
    public List<Aula> listarAulas() {
        return repositorio.listarAulas();
    }

    @GetMapping(path = "/{id}")
    public List<Aula> buscarPorIdDoCurso(@PathVariable(name = "id") Integer aulaId) {
        return repositorio.buscarPorIdDoCurso(aulaId);
    }

    @PostMapping
    public void adicionarAula(@RequestBody Aula aula) {
        repositorio.adicionarAula(aula);
    }

    @GetMapping (path = "/buscarAula")
    public Aula buscarAula (@RequestParam(name = "nome") String nome){
        return repositorio.buscarPorNomeAula(nome);
    }
}
