package com.ulearn.ulearn.controller;

import com.ulearn.ulearn.model.Curso;
import com.ulearn.ulearn.service.AcessoAoCursoServico;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/cursos")
public class CursoController {

    private AcessoAoCursoServico acessoAoCursoServico = new AcessoAoCursoServico();

    @GetMapping
    public List<Curso> listarCursos() {
        return acessoAoCursoServico.listarCursos();
    }

    @PostMapping
    public void adicionarCurso(Curso curso) {
        acessoAoCursoServico.adicionarCurso(curso);
    }

    @DeleteMapping(path = "/{id}")
    public void removerCurso(@PathVariable Integer id) {
        acessoAoCursoServico.removerCurso(id);
    }

    @GetMapping(path = "/buscar")
    public Curso buscarCurso(@RequestParam(name = "nome") String nome) {
        return acessoAoCursoServico.buscarCurso(nome);
    }

    @PostMapping(path = "/acesso")
    public void concederAcesso(@RequestParam(name = "cursoId") Integer cursoId,
                               @RequestParam(name = "alunoId") Integer alunoId) {
        acessoAoCursoServico.concederAcesso(cursoId, alunoId);
    }

    @PutMapping(path = "/acesso")
    public void revogarAcesso(@RequestParam(name = "cursoId") Integer cursoId,
                              @RequestParam(name = "alunoId") Integer alunoId) {
        acessoAoCursoServico.revogarAcesso(cursoId, alunoId);
    }

}
