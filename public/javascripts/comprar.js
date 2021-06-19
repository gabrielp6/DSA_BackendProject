var BASE_URI = "http://localhost:8080/dsaApp"

$(document).ready(function(){
var username = localStorage.getItem("username");

$('#buttonEscudoOro').click(function () {

            $.ajax({
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    url: BASE_URI.concat("/tienda/comprarObjeto"),
                    type: "POST",
                    data: JSON.stringify({"nombreObjeto": "escudoOro", "username": username}),
                    dataType:'json',


                       success: function (data) {
                                alert("Escudo de oro comprado! Te quedan "+data.monedasActualizadas+" monedas");
                                message = '"Escudo de oro comprado"';
                                window.location.href = "tienda.html";
                        },

                       error: function(error){
                       alert("No tienes suficiente dinero");
                       }

            });
});

$('#buttonEscudoPlata').click(function () {

            $.ajax({
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    url: BASE_URI.concat("/tienda/comprarObjeto"),
                    type: "POST",
                    data: JSON.stringify({"nombreObjeto": "escudoPlata", "username": username}),
                    dataType:'json',

                       success: function (data) {
                                alert("Escudo de plata comprado! Te quedan "+data.monedasActualizadas+" monedas");
                                window.location.href = "tienda.html";
                        },

                       error: function(error){
                       alert("No tienes suficiente dinero");
                       }
            });
});


$('#buttonEscudoMadera').click(function () {

            $.ajax({
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    url: BASE_URI.concat("/tienda/comprarObjeto"),
                    type: "POST",
                    data: JSON.stringify({"nombreObjeto": "escudoMadera", "username": username}),
                    dataType:'json',

                       success: function (data) {
                                alert("Escudo de madera comprado! Te quedan "+data.monedasActualizadas+" monedas");
                                window.location.href = "tienda.html";
                        },

                       error: function(error){
                       alert("No tienes suficiente dinero");
                       }
            });
});

$('#buttonFlechaOro').click(function () {

            $.ajax({
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    url: BASE_URI.concat("/tienda/comprarObjeto"),
                    type: "POST",
                    data: JSON.stringify({"nombreObjeto": "flechaOro", "username": username}),
                    dataType:'json',

                       success: function (data) {
                                alert("Flecha de oro comprada! Te quedan "+data.monedasActualizadas+" monedas");
                                window.location.href = "tienda.html";
                        },

                       error: function(error){
                       alert("No tienes suficiente dinero");
                       }
            });
});


$('#buttonFlechaPlata').click(function () {

            $.ajax({
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    url: BASE_URI.concat("/tienda/comprarObjeto"),
                    type: "POST",
                    data: JSON.stringify({"nombreObjeto": "flechaPlata", "username": username}),
                    dataType:'json',

                       success: function (data) {
                                alert("Flecha de plata comprada! Te quedan "+data.monedasActualizadas+" monedas");
                                window.location.href = "tienda.html";
                        },

                       error: function(error){
                       alert("No tienes suficiente dinero");
                       }
            });
});


$('#buttonFlechaMadera').click(function () {

            $.ajax({
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    url: BASE_URI.concat("/tienda/comprarObjeto"),
                    type: "POST",
                    data: JSON.stringify({"nombreObjeto": "flechaMadera", "username": username}),
                    dataType:'json',

                       success: function (data) {
                                alert("Flecha de madera comprada! Te quedan "+data.monedasActualizadas+" monedas");
                                window.location.href = "tienda.html";
                        },

                       error: function(error){
                       alert("No tienes suficiente dinero");
                       }
            });
});

$('#buttonManzana').click(function () {

            $.ajax({
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    url: BASE_URI.concat("/tienda/comprarObjeto"),
                    type: "POST",
                    data: JSON.stringify({"nombreObjeto": "manzana", "username": username}),
                    dataType:'json',

                       success: function (data) {
                                alert("Manzana comprada! Te quedan "+data.monedasActualizadas+" monedas");
                                window.location.href = "tienda.html";
                        },

                       error: function(error){
                       alert("No tienes suficiente dinero");
                       }
            });
});


$('#buttonPocionRoja').click(function () {

            $.ajax({
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    url: BASE_URI.concat("/tienda/comprarObjeto"),
                    type: "POST",
                    data: JSON.stringify({"nombreObjeto": "pocionRoja", "username": username}),
                    dataType:'json',

                       success: function (data) {
                                alert("Pocion roja comprada! Te quedan "+data.monedasActualizadas+" monedas");
                                window.location.href = "tienda.html";
                        },

                       error: function(error){
                       alert("No tienes suficiente dinero");
                       }
            });
});

$('#buttonPocionAzul').click(function () {

            $.ajax({
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    url: BASE_URI.concat("/tienda/comprarObjeto"),
                    type: "POST",
                    data: JSON.stringify({"nombreObjeto": "pocionAzul", "username": username}),
                    dataType:'json',

                       success: function (data) {
                                alert("Pocion azul comprada! Te quedan "+data.monedasActualizadas+" monedas");
                                window.location.href = "tienda.html";
                        },

                       error: function(error){
                       alert("No tienes suficiente dinero");
                       }
            });
});





});


