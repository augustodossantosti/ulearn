package com.ulearn.ulearn.controller;

import com.ulearn.ulearn.model.Avaliacao;
import com.ulearn.ulearn.model.Curso;
import com.ulearn.ulearn.service.AcessoAoCursoServico;
import com.ulearn.ulearn.service.CalcularNotaServico;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/cursos")
public class CursoController {

    private AcessoAoCursoServico acessoAoCursoServico = new AcessoAoCursoServico();
    private CalcularNotaServico avaliacaoServico = new CalcularNotaServico();

    @GetMapping
    public List<Curso> listarCursos() {
        return acessoAoCursoServico.listarCursos();
    }

    @PostMapping
    public void adicionarCurso(@RequestBody Curso curso) {
        acessoAoCursoServico.adicionarCurso(curso);
    }

    @DeleteMapping(path = "/{id}")
    public void removerCurso(@PathVariable Integer id) {
        acessoAoCursoServico.removerCurso(id);
    }

    @GetMapping(path = "/{id}")
    public Curso buscarCursoPorId(@PathVariable Integer id) {
        return acessoAoCursoServico.buscarCursoPorId(id);
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

    @GetMapping(path = "/acesso/{alunoId}")
    public List<Curso> listarCursosDoAluno(@RequestParam(name = "alunoId") Integer alunoId) {
        return acessoAoCursoServico.listarCursosDoAluno(alunoId);
    }

    @GetMapping(path = "/avaliacao")
    public Avaliacao buscarAvaliacao(@RequestParam(name = "cursoId") Integer cursoId,
                                     @RequestParam(name = "alunoId") Integer alunoId) {
        return avaliacaoServico.buscarAvaliacao(cursoId, alunoId);
    }

    @PostMapping(path = "/avaliacao")
    public Avaliacao calcularNota(@RequestBody Avaliacao avaliacao) {
        return avaliacaoServico.calcularNota(avaliacao);
    }

}
