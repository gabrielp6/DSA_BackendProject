var BASE_URI = "http://localhost:8080/dsaApp"

$(document).ready(function(){

    $("#btnRegistrar").click(function(e){
        var username = $('#username').val();
        var email = $('#correo').val();
        var password = $('#password').val();
        var passwordRepetido = $('#passwordRepetido').val();
            if(password == passwordRepetido){
                $.ajax({
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    url: BASE_URI.concat("/auth/registrarUsuario"),
                    type: "POST",
                    data: JSON.stringify({"username": username, "password": password, "email": email}),
                    dataType:'json',

                    success: function (data) {
                    alert("Usuario registrado correctamente!");
                    console.log("Registrado");


                    },
                    error: function(error){
                    message = '"Error"';
                    console.log("Error", error);
                    alert("Error");
                    },

                    });
            }

            else{

                    alert("Las contraseñas no coinciden");
                    message = '"Las contraseñas no coinciden"';

            }
    });