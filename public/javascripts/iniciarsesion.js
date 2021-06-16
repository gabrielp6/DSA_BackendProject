var BASE_URI = "http://localhost:8080/dsaApp"

$(document).ready(function(){

   myStorage = window.localStorage;

   $("#btnIniciarSesion").click(function(e){
       e.preventDefault();
       var username = $('#username').val();
       var password = $('#password').val();
       if (username == null || password == null){
           alert("Hay campos vacios!");
           message = '"Campos vacios"';
       }
       else {

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
                        myStorage.setItem("user",data.username);
                        myStorage.setItem("password",data.password);
                        message = '"Has iniciado sesión"';
                        //window.location.pathname = "/tienda.html";
                        //window.open("home_sesioniniciada.html");
                        window.location.href = "home_sesioniniciada.html";

                       },
                      error: function(error){
                        alert("Error: Nombre/contraseña mal introducido");
                        message = '"Nombre/contraseña mal introducido"';

                       }
                      })

            }


       });
   });
