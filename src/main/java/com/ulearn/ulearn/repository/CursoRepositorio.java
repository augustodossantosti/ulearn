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
        adicionarCurso(new Curso(1, "Algoritmo", "Basic",
                "O aluno vai aprender raciocinar como um programador.",
                "\\resources\\images\\curso-algoritmo.jpg",
                "Este curso foi feito para pessoas que não têm NENHUM conhecimento em programação e desejam estudá-la. É um curso 10 horas, onde iremos apresentar todos os conceitos utilizados em todas as linguagens de programação. O curso é passo a passo e composto de teorias e vários exemplos práticos, fazendo com que o aluno consiga entender de verdade como pensar como um programador.",
                "Lucas Nadalete"));
        adicionarCurso(new Curso(2, "Contabilidade", "Finanças",
                "Neste curso, a gente vai ver na prática o que você precisa fazer para ficar em dia com todas as obrigações da sua empresa.",
                "\\resources\\images\\curso-contabilidade.png",
                "Ficar reclamando que empreender no Brasil é muito burocrático não vai fazer o seu negócio chegar em lugar algum. O Brasil é complicado mesmo, mas neste jogo existem regras (e muitas exceções), que podem ser aprendidas e usadas a seu favor. Neste curso, a gente vai ver na prática o que você precisa fazer para ficar em dia com todas as obrigações da sua empresa. Além disso, a gente vai falar sobre mais de 30 formas que o seu negócio tem para pagar menos impostos de forma perfeitamente legal.",
                "Edson Morette"));
        adicionarCurso(new Curso(3, "Engenharia de Software", "Development",
                "O guia completo para você conseguir criar uma variedade de aplicações.",
                "\\resources\\images\\curso-engenharia-software.jpg",
                "Curso destinado à aqueles que querem aprender os conceitos de programação em blocos, as atividades desenvolvidas são elaboradas na plataforma Scratch pois nos proporciona um ambiente simples e atrativo utilizando animações que ajudam na programação, este curso contem também questionários simples a cada final de vídeo aula revisando os conteúdos vistos.",
                "Giuliano Bertoti"));
        adicionarCurso(new Curso(4, "Estrutura de Dados", "Development",
                "Implementar suas estruturas de dados. Conhecer as mais variadas estruturas de dados.",
                "\\resources\\images\\curso-estrutura-dados.png",
                "Nesse curso você irá aprender a implementar várias estruturas de dados utilizando a linguagem de programação C. A linguagem C é uma das linguagens mais populares e eficientes que existe! Aprender sobre estruturas de dados é fundamental na carreira de qualquer programador. Esse curso tem como objetivo explicar várias estruturas de dados e, através de aulas dinâmicas e didáticas, implementar cada uma dessas estruturas. O armazenamento e organização dos dados é muito importante para que esses dados sejam utilizados de forma eficiente. Aprenda agora mesmo sobre estruturas de dados com a linguagem C através de aulas claras e objetivas!",
                "Eduardo Sakaue"));
        adicionarCurso(new Curso(5, "Lógica de Programação", "Basic",
                "Desenvolver um raciocínio lógico de programação.",
                "\\resources\\images\\curso-logica-programacao.jpg",
                "Este é um curso sobre lógica de programação focado, essencialmente, no aprendizado das estruturas de controle de fluxo condicionais e de repetição (if-then-else, switch, for, while e do-while). As aulas são ministradas utilizando fluxogramas e pseudocódigo que é uma forma genérica de escrever algoritmos independentes de quaisquer linguagens de programação, o que torna muito mais fácil a compreensão de tais estruturas de controle. No final de cada aula, os exemplos criados em pseudocódigo são reproduzidos utilizando a linguagem de programação C++ apenas para ilustrar os resultados na prática, mas isto não significa que você precise ter conhecimentos em C++ para acompanhar este curso. Divirta-se programando!",
                "Lucas Nadalete"));
        adicionarCurso(new Curso(6, "Modelagem de Banco de Dados", "Database",
                "Entender os seguintes conceitos: entidade, relação, atributo, tupla, tabela, linha, coluna, etc",
                "\\resources\\images\\curso-modelagem-banco-dados.jpg",
                "Atualmente, a informação tornou-se um dos ativos mais importantes nas organizações. Organizar a informação é de vital importância para as empresas manterem-se competitivas. Entre as tecnologias mais utilizadas para a armazenagem da informação de maneira organizada estão os bancos de dados relacionais. Então, tornou-se de vital importância, não só, ser capaz de desenvolver aplicações de banco de dados relacionais, mas também, entender o paradigma relacional, independente da área de formação .",
                "Emanuel Mineda"));
        adicionarCurso(new Curso(7, "Redes de Computadores", "Infrastructure",
                "Entender o que é uma Rede. Protocolo TCP-IP e outros.",
                "\\resources\\images\\curso-rede-computadores.png",
                "Seja bem vindo ao Curso de Redes Introdutório. O curso possui 45 vídeo aulas. O treinamento dado no curso é voltado tanto para a área de redes quanto para área de servidores. Este curso é o primeiro módulo da série de 5 cursos de rede que ofereço na Udemy. Fazem parte deste segmento os cursos de Curso de Redes Cisco, Windows Server 2012 – Mão na Massa, Cisco CCNA Curso Completo de Segurança em Redes e o Curso de Pen Test.",
                "Wellington Sleep"));
        adicionarCurso(new Curso(8, "PL/SQL", "Database",
                "Ao final do meu curso, os alunos poderão realizar consultas simples e complexas no banco de dados Oracle.",
                "\\resources\\images\\curso-pl-sql.jpg",
                "Aprenda SQL e PL/SQL em um treinamento de alta qualidade e seja expert em banco de dados Oracle. Este curso você vai aprender Oracle SQL começando do zero, passando por PL/SQL nível 1 e 2.  Para isto usaremos muitos videos, artigos e manuais de SQL e SQL/PL em PDF. Com este curso você pode ser preparar para certificações OCA e OCE 11g e 12c.",
                "Juliana Doubleju"));
        adicionarCurso(new Curso(9, "Matemática", "Logic",
                "Neste curso vamos apresentar os assuntos de Matemática correspondentes à grade curricular do ensino médio.",
                "\\resources\\images\\cuso-matematica.jpg",
                "Nosso curso será dividido por seções, cada seção abordará um assunto diferente da Matemática, com aulas curtas, narrativas curiosas, sempre com uma pegada tecnológica, realidade aumentada e ambiente virtual que ajuda bastante na hora de ensinar.",
                "Marcos Allan"));
        adicionarCurso(new Curso(10, "Estatistica", "Logic",
                "Todo profissional que deseja trabalhar com análise de dados precisa saber sobre Estatística.",
                "\\resources\\images\\curso-estatistica.jpg",
                "Dominar na prática os principais conceitos em Estatística. Saberá os principais métodos para se obter uma amostra de dados. Aprenderá como analisar estatisticamente cada tipo de variável.",
                "Nanci Thigh"));
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
