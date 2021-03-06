$( montarSlide );

const apiInf = {
    baseUrl: 'http://localhost:1234/'
};

function montarSlide() {
    $.getJSON(apiInf.baseUrl + "cursos/top", function (data) {
        let itens = [];
        $.each(data, function (key, curso) {
            itens.push(`
                <div class="col-md-4">
                  <div class="card flex-md-row mb-4 shadow-sm h-md-250">
                    <div class="card-body d-flex flex-column align-items-start">
                      <strong class="d-inline-block mb-2 text-primary">${curso.categoria}</strong>
                      <h3 class="mb-0">
                        <a class="text-dark" href="/curso-descricao?id=${curso.id}">${curso.nome}</a>
                      </h3>
                      <p class="card-text mb-auto">${curso.resumo}</p>
                      <a href="/curso-descricao?id=${curso.id}">Saiba mais...</a>
                    </div>
                    <img class="card-img-right flex-auto d-none d-lg-block" src="${curso.linkCapa}" alt="Capa do curso">
                  </div>
                </div>
             `);
        });

        $('#listaDeCursos').append(itens.join(''));

        $('#listaDeCursos').slick({
            dots: true,
            infinite: true,
            speed: 300,
            slidesToShow: 3,
            slidesToScroll: 3,
            responsive: [
                {
                    breakpoint: 1024,
                    settings: {
                        slidesToShow: 3,
                        slidesToScroll: 3,
                        infinite: true,
                        dots: true
                    }
                },
                {
                    breakpoint: 600,
                    settings: {
                        slidesToShow: 2,
                        slidesToScroll: 2
                    }
                },
                {
                    breakpoint: 480,
                    settings: {
                        slidesToShow: 1,
                        slidesToScroll: 1
                    }
                }
            ]
        });
    });

    carregarCursos();
}

function carregarCursos() {
    $.getJSON(apiInf.baseUrl + "cursos", function (data) {

        let itens = new Map();
        $.each(data, function (key, curso) {
            const template = `
                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail">
                        <img src="${curso.linkCapa}" alt="${curso.nome}">
                        <div class="caption">
                            <h3>${curso.nome}</h3>
                            <p>${curso.resumo}</p>
                            <p>
                                <a href="/curso-descricao?id=${curso.id}" class="btn btn-default" role="button">Detalhes</a>
                            </p>
                        </div>
                    </div>
                </div>
            `;

            if (itens.has(curso.categoria)) {
                itens.get(curso.categoria).push(template);
            } else {
                $('#listagem-cursos').append(`<h6 class="curso-categoria">${curso.categoria}:</h6><div id="row-${curso.categoria}" class="row"></div>`);
                itens.set(curso.categoria, [template]);
            }
        });

        itens.forEach((cursos, categoria) => $(`#row-${categoria}`).append(cursos.join('')));
    });
}