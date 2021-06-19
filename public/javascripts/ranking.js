var BASE_URI = "http://localhost:8080/dsaApp"

$(document).ready(function(e) {

    $('#btnResultados').click(function (e) {

    e.preventDefault();
        $.ajax({
            url: BASE_URI.concat("/estadisticas/records"),
                success: function(data) {
                    $("#nombre1").text(data[0].username);
                    $("#enemigosMatados1").text(data[0].enemigosMatados);
                    $("#tiempo1").text(data[0].tiempo);
                    $("#monedasRecogidas1").text(data[0].monedasRecogidas);
                    $("#puntuacionFinal1").text(data[0].puntuacionFinal);

                    $("#nombre2").text(data[1].username);
                    $("#enemigosMatados2").text(data[1].enemigosMatados);
                    $("#tiempo2").text(data[1].tiempo);
                    $("#monedasRecogidas2").text(data[1].monedasRecogidas);
                    $("#puntuacionFinal2").text(data[1].puntuacionFinal);

                    $("#nombre3").text(data[2].username);
                    $("#enemigosMatados3").text(data[2].enemigosMatados);
                    $("#tiempo3").text(data[2].tiempo);
                    $("#monedasRecogidas3").text(data[2].monedasRecogidas);
                    $("#puntuacionFinal3").text(data[2].puntuacionFinal);

                    $("#nombre4").text(data[3].username);
                    $("#enemigosMatados4").text(data[3].enemigosMatados);
                    $("#tiempo4").text(data[3].tiempo);
                    $("#monedasRecogidas4").text(data[3].monedasRecogidas);
                    $("#puntuacionFinal4").text(data[3].puntuacionFinal);

                    $("#nombre5").text(data[1].username);
                    $("#enemigosMatados5").text(data[4].enemigosMatados);
                    $("#tiempo5").text(data[4].tiempo);
                    $("#monedasRecogidas5").text(data[4].monedasRecogidas);
                    $("#puntuacionFinal5").text(data[4].puntuacionFinal);

                    $("#nombre6").text(data[5].username);
                    $("#enemigosMatados6").text(data[5].enemigosMatados);
                    $("#tiempo6").text(data[5].tiempo);
                    $("#monedasRecogidas6").text(data[5].monedasRecogidas);
                    $("#puntuacionFinal6").text(data[5].puntuacionFinal);

                    $("#nombre7").text(data[1].username);
                    $("#enemigosMatados7").text(data[6].enemigosMatados);
                    $("#tiempo7").text(data[6].tiempo);
                    $("#monedasRecogidas7").text(data[6].monedasRecogidas);
                    $("#puntuacionFinal7").text(data[6].puntuacionFinal);

                    $("#nombre8").text(data[1].username);
                    $("#enemigosMatados8").text(data[7].enemigosMatados);
                    $("#tiempo8").text(data[7].tiempo);
                    $("#monedasRecogidas8").text(data[7].monedasRecogidas);
                    $("#puntuacionFinal8").text(data[7].puntuacionFinal);

                    $("#nombre9").text(data[1].username);
                    $("#enemigosMatados9").text(data[8].enemigosMatados);
                    $("#tiempo9").text(data[8].tiempo);
                    $("#monedasRecogidas9").text(data[8].monedasRecogidas);
                    $("#puntuacionFinal9").text(data[8].puntuacionFinal);

                    $("#nombre10").text(data[1].username);
                    $("#enemigosMatados10").text(data[9].enemigosMatados);
                    $("#tiempo10").text(data[9].tiempo);
                    $("#monedasRecogidas10").text(data[9].monedasRecogidas);
                    $("#puntuacionFinal10").text(data[9].puntuacionFinal);

                    $("#campeon2").text(data[1].username);
                    $("#campeon1").text(data[0].username);
                    $("#campeon3").text(data[2].username);
                }

        })
    });
    });