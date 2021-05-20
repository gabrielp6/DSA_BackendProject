var BASE_URI= "http://localhost:8080/dsaApp"

$(document).ready(function(){

    $("#btnRegistrar").click(function(e){
        e.preventDefault();
        var username = $('#username').val();
        console.log(username);
        var email = $('#email').val();
        console.log(email);
        var password = $('#password').val();
        console.log(password);
        var passwordRepetido = $('#passwordRepetido').val();
        console.log(passwordRepetido);
        alert("1111");
            if(password == passwordRepetido){
                alert("2222");
                $.ajax({
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    url: BASE_URI.concat("/auth/registrarUsuario"),
                    type: "POST",
                    data: JSON.stringify({"username": username, "password": password, "email": email}),
                    dataType:'json',
                    success: function(data){
                        console.log("El usuario se ha registrado correctamente");
                        alert("Ya está registrado el usuario");
                    },


                    error: function(error){
                    message = '"Error"';
                    alert("Error: "+ error);
                        console.log("El usuario no se ha registrado", error);
                    },

                    });
            }

            else{
                    message = '"Las contraseñas no coinciden"';

            }
            })
    });