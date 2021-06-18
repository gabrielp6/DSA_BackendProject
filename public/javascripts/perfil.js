var BASE_URI = "http://localhost:8080/dsaApp"

$(document).ready(function(e) {


    $('#btnVerPerfil').click(function (e) {
    e.preventDefault(e);
        var usuario = $('#username').val();
        $.ajax({
            url: BASE_URI.concat("/user/obtenerUsuario/"+usuario),
                success: function(data) {
                    alert("recibido");
                    $("#id").text(data.ID);
                    $("#nu").text(data.username);
                    $("#ce").text(data.email);
                    $("#cv").text(data.vida);
                    $("#f").text(data.fuerza);
                    $("#m").text(data.coins);

                }

        })
    });
    });