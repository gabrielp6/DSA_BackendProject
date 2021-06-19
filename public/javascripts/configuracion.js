var BASE_URI = "http://localhost:8080/dsaApp"

$(document).ready(function(){

    $("#btnEditar").click(function(e){
        e.preventDefault();
        var username = $('#username').val();
        var passwordActual = $('#email').val();
        var passwordNueva = $('#password').val();
        var passwordNuevaRepetida = $('#passwordRepetido').val();
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
                    //window.open("iniciarsesion.html");
                    window.location.href = "iniciarsesion.html";

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

    $("#btnEliminar").click(function(e){
    e.preventDefault();
        var username = $('#username2').val();
        var password = $('#password2').val();
        var passwordRepetido = $('#passwordRepetido2').val();
            if(password == passwordRepetido){
                $.ajax({
                    type: "DELETE",
                    url: BASE_URI.concat("/user/borrarUsuario/"+username+"/"+password),
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },

                    success: function () {
                    alert("Usuario eliminado correctamente");
                    console.log("Eliminado");
                    window.location.href = "index.html";

                    },
                    error: function(){
                    alert("Error");
                    alert(""+url);
                    },

                    });
            }

            else{
                    alert("Las contraseñas no coinciden");
            }
    });

    });