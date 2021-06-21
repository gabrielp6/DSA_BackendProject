var BASE_URI = "http://localhost:8080/dsaApp"

$(document).ready(function(e) {

    $('#btnVerPerfil').click(function (e) {
    e.preventDefault(e);
        var usuario = $('#username').val();
        $.ajax({
            url: BASE_URI.concat("/user/obtenerUsuario/"+usuario),
                success: function(data) {
                    $("#id").text(data.ID);
                    $("#nu").text(data.username);
                    $("#ce").text(data.email);
                    $("#cv").text(data.vida);
                    $("#f").text(data.fuerza);
                    $("#m").text(data.coins);

                }

        })

        $.ajax({
            url: BASE_URI.concat("/tienda/obtenerInventarioUsuario/"+usuario),
                success: function(data) {
                    $("#escudoOro").text(data.escudoOro);
                    $("#escudoPlata").text(data.escudoPlata);
                    $("#escudoMadera").text(data.escudoMadera);
                    $("#flechaOro").text(data.flechaOro);
                    $("#flechaPlata").text(data.flechaPlata);
                    $("#flechaMadera").text(data.flechaMadera);
                    $("#manzana").text(data.manzana);
                    $("#pocionAzul").text(data.pocionAzul);
                    $("#pocionRoja").text(data.pocionRoja);
                }

        })
    });
    });