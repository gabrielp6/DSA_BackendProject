var BASE_URI = "http://localhost:8080/dsaApp"

$(document).ready(function() {
    var username = localStorage.getItem("username");

    $('#btnResultados').click(function () {

        $.ajax({
            url: BASE_URI.concat("/estadisticas/records"),
                success: function(data) {
alert("111");
                    $("#nombre1").text(data[0].username);
                    $("#enemigosMatados1").text(data[0].enemigosMatados);
                    $("#tiempo1").text(data[0].tiempo);
                    $("#monedasRecogidas1").text(data[0].monedasRecogidas);
                    $("#puntuacionFinal1").text(data[0].puntuacionFinal);
alert("222");
                    $("#nombre2").text(data[1].username);
                    $("#enemigosMatados2").text(data[1].enemigosMatados);
                    $("#tiempo2").text(data[1].tiempo);
                    $("#monedasRecogidas2").text(data[1].monedasRecogidas);
                    $("#puntuacionFinal2").text(data[1].puntuacionFinal);

alert("333");


                }
                alert("444");
        })
    });
    });