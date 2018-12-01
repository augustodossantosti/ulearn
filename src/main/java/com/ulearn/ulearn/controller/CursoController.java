package com.ulearn.ulearn.controller;

import com.ulearn.ulearn.model.Avaliacao;
import com.ulearn.ulearn.model.Curso;
import com.ulearn.ulearn.service.AcessoAoCursoServico;
import com.ulearn.ulearn.service.CalcularNotaServico;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
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

    @GetMapping(path = "/top")
    public List<Curso> cursosMaisAssinados() {
        return acessoAoCursoServico.cursosMaisAssinados();
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
    public void concederAcesso(@RequestParam(name = "cursoId") Integer cursoId, @AuthenticationPrincipal User user) {
        acessoAoCursoServico.concederAcesso(cursoId, user.getUsername());
    }

    @PutMapping(path = "/acesso")
    public void revogarAcesso(@RequestParam(name = "cursoId") Integer cursoId, @AuthenticationPrincipal User user) {
        acessoAoCursoServico.revogarAcesso(cursoId, user.getUsername());
    }

    @GetMapping(path = "/meus-cursos")
    public List<Curso> listarCursosDoAluno(@AuthenticationPrincipal User user) {
        return acessoAoCursoServico.listarCursosDoAluno(user.getUsername());
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
