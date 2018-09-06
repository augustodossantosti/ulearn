package com.ulearn.ulearn.controller;

import com.ulearn.ulearn.model.Aluno;
import com.ulearn.ulearn.model.AlunoRepositorio;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/alunos")
@CrossOrigin(origins = "*")
public class AlunoController {

    private AlunoRepositorio repositorio = new AlunoRepositorio();

    public List<Aluno> listarAlunos() {
        return repositorio.listarAlunos();
    }

    public void AdicionarAluno(Aluno aluno) {
        repositorio.adicionarAluno(aluno);
    }

    public boolean removerAluno(String nome) {
        return repositorio.removerAlunoPorNome(nome);
    }

    public Aluno buscarAlunoPorNome(String nome) {
        return repositorio.buscarAlunoPorNome(nome);
    }

    public Aluno buscarAlunoPorEmail(String email) {
        return repositorio.buscarAlunoPorEmail(email);
    }

}
