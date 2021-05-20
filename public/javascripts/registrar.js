$(document).ready(function(){

    $("#btnRegistrar").click(function(){
        var username = $('#username').val();
        var correo = $('#correo').val();
        var contraseña = $('#contraseña').val();
        var contraseñarepetida = $('#contraseñarepetida').val();
            if(contraseñarepetida == contraseñarepetida){
                $.ajax({
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    url: "/dsaApp/auth/registrarUsuario",
                    type: "POST",
                    data: JSON.stringify({"username": username, "contraseña": contraseña, "correo": correo}),
                    dataType:'json',

                    error: function(error){
                    message = '"Error"';
                    },

                    });
            }

            else{
                    message = '"Las contraseñas no coinciden"';

            }
    });