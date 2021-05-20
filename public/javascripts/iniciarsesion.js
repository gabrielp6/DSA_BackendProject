var BASE_URI= "http://localhost:8080/dsaApp"
$(document).ready(function(){

   $("#btnIniciarSesion").click(function(e){
       e.preventDefault();
       var username = $('#username').val();
       var password = $('#password').val();
       alert("1111");
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
                   alert("3333");
                   myStorage.setItem("user",response.username);
                   myStorage.setItem("password",response.password);
                   myStorage.setItem("id",response.id);

                   message = '"Has iniciado sesión"';

               },
                error: function(error){

                   alert("Error: "+ error);
                   message = '"Nombre/contraseña mal introducido"';

               },
        });
    });
   })