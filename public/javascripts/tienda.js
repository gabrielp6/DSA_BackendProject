$(document).ready(function() {

    $('#buttonEscudoOro').click(function () {
            $.ajax({
                type: 'POST',
                url: BASE_URI.concat("/tienda/escudoOro"),
                success: function(respuesta) {
                        alert("Escudo de oro comprado correctamente");
                }
            });
        });

    $('#buttonEscudoPlata').click(function () {
            $.ajax({
                type: 'POST',
                url: BASE_URI.concat("/tienda/escudoPlata"),
                success: function(respuesta) {
                        alert("Escudo de plata comprado correctamente");
                }
            });
        });

    $('#buttonEscudoMadera').click(function () {
            $.ajax({
                type: 'POST',
                url: BASE_URI.concat("/tienda/escudoMadera"),
                success: function(respuesta) {
                        alert("Escudo de madera comprado correctamente");
                }
            });
        });

    $('#buttonFlechaOro').click(function () {
            $.ajax({
                type: 'POST',
                url: BASE_URI.concat("/tienda/flechaOro"),
                success: function(respuesta) {
                        alert("Flecha de oro comprada correctamente");
                }
            });
        });

    $('#buttonFlechaPlata').click(function () {
            $.ajax({
                type: 'POST',
                url: BASE_URI.concat("/tienda/flechaPlata"),
                success: function(respuesta) {
                        alert("Flecha de plata comprada correctamente");
                }
            });
    });

    $('#buttonFlechaOro').click(function () {
            $.ajax({
                type: 'POST',
                url: BASE_URI.concat("/tienda/flechaMadera"),
                success: function(respuesta) {
                        alert("Flecha de madera comprada correctamente");
                }
            });
        });

    $('#buttonManzana').click(function () {
            $.ajax({
                type: 'POST',
                url: BASE_URI.concat("/tienda/manzana"),
                success: function(respuesta) {
                        alert("Manzana comprada correctamente");
                }
            });
        });


    $('#buttonPocionAzul').click(function () {
            $.ajax({
                type: 'POST',
                url: BASE_URI.concat("/tienda/comprarObjeto/pocionAzul"),
                success: function(respuesta) {
                        alert("Poción azul comprada correctamente");
                }
            });
        });


    $('#buttonPocionRoja').click(function () {
            $.ajax({
                type: 'POST',
                url: BASE_URI.concat("/tienda/pocionRoja"),
                success: function(respuesta) {
                        alert("Poción roja comprada correctamente");
                }
            });
        });

})