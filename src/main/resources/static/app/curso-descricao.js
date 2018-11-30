$( carregarInformacoes );

const apiUri = {
    baseUrl: 'http://localhost:1234/'
};

function carregarInformacoes() {
    const searchParams = new URLSearchParams(window.location.search);
    if (searchParams.has('id')) {
        const cursoId = searchParams.get('id');

        $.getJSON(apiUri.baseUrl + "cursos/" + cursoId, function (data) {
            preencherCampos(data)
        });
    }
}

function preencherCampos(curso) {
    $(document).attr("title", "Ulearn - " + curso.nome);
    $('#curso-nome').text(curso.nome);
    $('#curso-categoria').text(curso.categria);
    $('#curso-descricao').text(curso.descricao);
}