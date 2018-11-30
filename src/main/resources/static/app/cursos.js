$( carregarCursos );

const apiInf = {
    baseUrl: 'http://localhost:1234/'
};

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
                                <a href="/" class="btn btn-primary" role="button">Assinar</a>
                                <a href="/curso-descricao?id=${curso.id}" class="btn btn-default" role="button">Detalhes</a>
                            </p>
                        </div>
                    </div>
                </div>
            `;

            if (itens.has(curso.categoria)) {
                itens.get(curso.categoria).push(template);
            } else {
                $('#main').append(`<h6>${curso.categoria}:</h6><div id="row-${curso.categoria}" class="row"></div>`);
                itens.set(curso.categoria, [template]);
            }
        });

        itens.forEach((cursos, categoria) => $(`#row-${categoria}`).append(cursos.join('')));
    });
}