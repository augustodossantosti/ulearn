package com.ulearn.ulearn.controller;

import com.ulearn.ulearn.model.Aluno;
import com.ulearn.ulearn.repository.AlunoRepositorio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/alunos")
@CrossOrigin(origins = "*")
public class AlunoController {

    private AlunoRepositorio repositorio = new AlunoRepositorio();

    @GetMapping
    public List<Aluno> listarAlunos() {
        return repositorio.listarAlunos();
    }

    @PostMapping
    public void adicionarAluno(Aluno aluno) {
        repositorio.adicionarAluno(aluno);
    }

    @DeleteMapping
    public boolean removerAluno(String nome) {
        return repositorio.removerAlunoPorNome(nome);
    }

    @GetMapping(path = "/buscar")
    public Aluno buscarAluno(@RequestParam(name = "nome", required = false) String nome, @RequestParam(name = "email", required = false) String email) {
        return email != null ? repositorio.buscarAlunoPorEmail(email) : repositorio.buscarAlunoPorNome(nome);
    }

}
