var BASE_URI = "http://localhost:8080/dsaApp"

$(document).ready(function(e) {

    $('#btnVerPartidas').click(function (e) {
        var usuario = $('#username').val();
        e.preventDefault();

        $.ajax({
            url: BASE_URI.concat("/estadisticas/partidasUsuario/"+usuario),
                success: function(data) {
                    alert("recibido");

                    var inHTML = "<tr><td align='center' style='font-size:150%'><strong>Enemigos matados</strong></td><td align='center' style='font-size:150%'><strong>Tiempo</strong></td><td align='center' style='font-size:150%''><strong>Monedas recogidas</strong></td><td align='center'' style='font-size:150%'><strong>Puntuación final</strong></td></tr>";
                    alert("r");
                    var extra = "";
                    $.each(data, function(index, value){
                        var newItem = "<tr><td align='center'' style='font-size:125%'>"+ value.enemigosMatados + "</td><td align='center' style='font-size:125%'>"+ value.tiempo +"</td><td align='center' style='font-size:125%'>"+ value.monedasRecogidas +"</td><td align='center' style='font-size:125%'>"+ value.puntuacionFinal +"</td></tr>"
                        extra += newItem;
                    });

                    $("table#dinamica").html(inHTML + extra);
                }

        })
    });
    });