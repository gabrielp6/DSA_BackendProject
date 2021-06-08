$(document).ready(function(){

   $("#btnIniciarSesion").click(function(e){
       var username = $('#username').val();
       var password = $('#password').val();
       $.ajax({
           headers: {
               'Accept': 'application/json',
               'Content-Type': 'application/json'
               },
               url: BASE_URI.concat("/auth/iniciarSesion",
               type: "POST",
               data: JSON.stringify({"username": username, "password": password}),
               dataType:'json',

               success: function (data) {
                   myStorage.setItem("user",response.username);
                   myStorage.setItem("password",response.password);
                   myStorage.setItem("id",response.id);

                    window.open(localhost:8080/iniciarsesion.html);
                    message = '"Has iniciado sesión"';

               },
                error: function(error){
                    alert("Error: "+error);
                   message = '"Nombre/contraseña mal introducido"';


               },
        });
    });