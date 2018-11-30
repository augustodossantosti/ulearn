package com.ulearn.ulearn.repository;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.ulearn.ulearn.model.Curso;

import java.util.Collections;
import java.util.List;

public class CursoRepositorio {

    private final ObjectContainer container;

    public CursoRepositorio(){
        container = Db4oEmbedded.openFile("bd/cursos.db4o");
        adicionarCurso(new Curso(1, "Python", "Development", "Aprenda Python e domine o mundo!",
                "https://2.bp.blogspot.com/-4bKb2pG_jfA/WTTPJDOqa6I/AAAAAAAAAKU/wacHnUfGNpMk_tSl6LyQCbip8I9bHDKGgCLcB/s640/Curso-online-de-Python-principal-11-460x281.png",
                "Descrição do curso de Python.", "Bruno Rodrigues"));
        adicionarCurso(new Curso(2, "Java", "Development", "Aprenda Java e domine o mundo!",
                "https://www.wreducacional.com.br/img_cursos/prod/img_610x320/informatica/linguagem-de-programacao-de-java.jpg",
                "Descrição do curso de Java.", "Bruno Rodrigues"));
        adicionarCurso(new Curso(3, "PHP", "Development", "Aprenda PHP e domine o mundo!",
                "/",
                "Descrição do curso de PHP.", "Bruno Rodrigues"));
        adicionarCurso(new Curso(4, "Java", "TI", "Aprenda Java e domine o mundo!",
                "https://www.wreducacional.com.br/img_cursos/prod/img_610x320/informatica/linguagem-de-programacao-de-java.jpg",
                "Descrição do curso de Java.", "Bruno Rodrigues"));
        adicionarCurso(new Curso(5, "PHP", "TI", "Aprenda PHP e domine o mundo!",
                "https://www.cursosgratisonline.com.br/curso/images/207-php.jpg",
                "Descrição do curso de PHP.", "Bruno Rodrigues"));
        adicionarCurso(new Curso(6, "Python", "TI", "Aprenda Python e domine o mundo!",
                "https://2.bp.blogspot.com/-4bKb2pG_jfA/WTTPJDOqa6I/AAAAAAAAAKU/wacHnUfGNpMk_tSl6LyQCbip8I9bHDKGgCLcB/s640/Curso-online-de-Python-principal-11-460x281.png",
                "Descrição do curso de Python.", "Bruno Rodrigues"));
        adicionarCurso(new Curso(7, "Go", "TI", "Aprenda Go e domine o mundo!",
                "https://2.bp.blogspot.com/-4bKb2pG_jfA/WTTPJDOqa6I/AAAAAAAAAKU/wacHnUfGNpMk_tSl6LyQCbip8I9bHDKGgCLcB/s640/Curso-online-de-Python-principal-11-460x281.png",
                "Descrição do curso de Go.", "Bruno Rodrigues"));
    }

    public List<Curso> listarAlunos() {
        final List<Curso> cursos = container.queryByExample(Curso.class);
        return Collections.unmodifiableList(cursos);
    }
    public void adicionarCurso(Curso curso) {
        container.store(curso);
    }

    public Curso buscarCursoPorNome(String nome) {
        final Curso curso = new Curso();
        curso.setNome(nome);
        final ObjectSet<Curso> result = container.queryByExample(curso);
        return result.hasNext() ? result.next() : null;
    }

    public Curso buscarCursoPorId(Integer id) {
        final Curso curso = new Curso();
        curso.setId(id);
        final ObjectSet<Curso> result = container.queryByExample(curso);
        return result.hasNext() ? result.next() : null;
    }

    public void removerCurso(int cursoId) {
        final Curso curso = new Curso();
        curso.setId(cursoId);
        container.delete(curso);
    }

    public List<Curso> listarCursos () {
        final List<Curso> cursos = container.queryByExample(Curso.class);
        return Collections.unmodifiableList(cursos);
    }

}
