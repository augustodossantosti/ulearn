$( testeLogin );

function testeLogin() {
    $.ajax({
        type: "POST",
        xhrFields: { withCredentials: true },
        headers: { "Authorization": "Basic " + btoa("admin:admin") },
        url: "http://localhost:1234/login"
    }).done(function(data) {
        console.log(data);
    })
    .fail(function(error) {
    console.log(error);
    });
}

