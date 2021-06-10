var BASE_URI = "http://localhost:8080/dsaApp"

$(document).ready(function(){

   $("#btnIniciarSesion").click(function(e){
       e.preventDefault();
       var username = $('#username').val();
       var password = $('#password').val();
       $.ajax({
           headers: {
               'Accept': 'application/json',
               'Content-Type': 'application/json'
               },
               url: BASE_URI.concat("/auth/iniciarSesion"),
               type: "POST",
               data: JSON.stringify({"username": username, "password": password}),
               dataType:'json',

               success: function (data) {
                   alert("Sesión iniciada correctamente");
                   window.sessionStorage.setItem("user",data.username);
                   window.sessionStorage.setItem("password",data.password);
                    message = '"Has iniciado sesión"';

               },
                error: function(error){
                    alert("Error: "+error);
                   message = '"Nombre/contraseña mal introducido"';


               },
        });
    });
    });