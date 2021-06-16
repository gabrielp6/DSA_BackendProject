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

                    statusCode: {
                        200: function() {
                                alert("Escudo de oro comprado!");
                                message = '"Escudo de oro comprado"';
                                window.location.href = "tienda.html";
                        }
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

                    statusCode: {
                        200: function() {
                                alert("Escudo de plata comprado!");
                                message = '"Escudo de plata comprado"';
                                window.location.href = "tienda.html";
                        }
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

                    statusCode: {
                        200: function() {
                                alert("Escudo de madera comprado!");
                                message = '"Escudo de madera comprado"';
                                window.location.href = "tienda.html";
                        }
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

                    statusCode: {
                        200: function() {
                                alert("Flecha de oro comprada!");
                                message = '"Flecha de oro comprada"';
                                window.location.href = "tienda.html";
                        }
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

                    statusCode: {
                        200: function() {
                                alert("Flecha de plata comprada!");
                                message = '"Flecha de plata comprada"';
                                window.location.href = "tienda.html";
                        }
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

                    statusCode: {
                        200: function() {
                                alert("Flecha de madera comprada!");
                                message = '"Flecha de madera comprada"';
                                window.location.href = "tienda.html";
                        }
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

                    statusCode: {
                        200: function() {
                                alert("Manzana comprada!");
                                message = '"Manzana comprada"';
                                window.location.href = "tienda.html";
                        }
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

                    statusCode: {
                        200: function() {
                                alert("Pocion roja comprada!");
                                message = '"Pocion roja comprado"';
                                window.location.href = "tienda.html";
                        }
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

                    statusCode: {
                        200: function() {
                                alert("Pocion azul comprada!");
                                message = '"Pocion azul comprado"';
                                window.location.href = "tienda.html";
                        }
                    }
            });
});





});


