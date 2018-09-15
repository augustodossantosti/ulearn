package com.ulearn.ulearn.controller;

import com.ulearn.ulearn.service.AcessoAoCurso;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/cursos")
@CrossOrigin(origins = "*")
public class CursoController {

    private AcessoAoCurso acessoAoCurso = new AcessoAoCurso();

}
