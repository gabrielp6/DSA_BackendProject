var BASE_URI = "http://localhost:8080/dsaApp"

$(document).ready(function(){
var username = localStorage.getItem("username");

$('#buttonEscudoOro').click(function () {

            $.ajax({
                type: 'POST',
                url: BASE_URI.concat("/tienda/escudoOro/?username=" + username),
                success: function(data) {
                        alert("Escudo de oro comprado!");
                        //window.open("tienda.html", "_self");
                        window.location.href = "tienda.html";
                }
            });
        }
    });

    $('#buttonEscudoPlata').click(function () {

                $.ajax({
                    type: 'POST',
                    url: BASE_URI.concat("/tienda/escudoPlata/username=" + username),
                    success: function(data) {
                            alert("Escudo de plata comprado!");
                            //window.open("tienda.html", "_self");
                            window.location.href = "tienda.html";
                    }
                });
            }
        });


    }