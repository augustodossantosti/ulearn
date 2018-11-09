$( listarCursos );

const apiInf = {
    baseUrl: 'http://localhost:1234/ulearn/'
};

function listarCursos() {
    $.getJSON(apiInf.baseUrl + "cursos", function (data) {
        let itens = [];
        $.each(data, function (key, value) { 
             itens.push("<li id='" + key + "'>" + val + "</li>");
        });
        
        $("<ul/>", {
            html: items.join("")
        }).appendTo( "body" );
    });
}

function adicionarCurso() {

}

function buscarCurso() {

}
