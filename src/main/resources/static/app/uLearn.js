$( listarCursos );

const apiInf = {
    baseUrl: 'http://localhost:1234/ulearn/'
};

function listarCursos() {
    $.getJSON(apiInf.baseUrl + "cursos", function (data) {
        let itens = [];
        $.each(data, function (key, result) {
             itens.push(`
                <div class="col-md-4">
                  <div class="card flex-md-row mb-4 shadow-sm h-md-250">
                    <div class="card-body d-flex flex-column align-items-start">
                      <strong class="d-inline-block mb-2 text-primary">${result.categoria}</strong>
                      <h3 class="mb-0">
                        <a class="text-dark" href="/ulearn/meus-cursos?id=${result.id}">${result.nome}</a>
                      </h3>
                      <p class="card-text mb-auto">${result.resumo}</p>
                      <a href="/ulearn/meus-cursos?id=${result.id}">Saiba mais...</a>
                    </div>
                    <img class="card-img-right flex-auto d-none d-lg-block" src="${result.linkCapa}" alt="Capa do curso">
                  </div>
                </div>
             `);
        });
        
        $('#listaDeCursos').append(itens.join(""));
    });
}

function adicionarCurso() {

}

function buscarCurso() {

}
