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

    @PostMapping
    public void adicionarAula(Aula aula) {
        repositorio.adicionarAula(aula);
    }

    @DeleteMapping(path = "/{id}")
    public void removerAula(@PathVariable Integer id) {
        repositorio.removerAulaPorIdCurso(id);
    }

    @GetMapping (path = "/buscarAula")
    public Aula buscarAula (@RequestParam(name = "nome", required = false) String nome, @RequestParam(name = "id", required = false) Integer id){
        return nome != null ? repositorio.buscarPorNomeAula(nome) : repositorio.buscarPorIDAula(id);
    }
}
