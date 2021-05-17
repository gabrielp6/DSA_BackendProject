package edu.upc.dsa.services;
import edu.upc.dsa.GameManagerImpl;
import edu.upc.dsa.models.Usuario;

import io.swagger.annotations.*;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;


@Api(value = "/game", description = "Endpoint to Game Service")
@Path("/game")

public class GameManagerService {

    private final GameManagerImpl gm;

    public GameManagerService() {
        this.gm = GameManagerImpl.getInstance();
        if (gm.usuariosSize() == 0) {
            gm.registrar("toni11", "hola", "toni11@hotmail.com");
            gm.registrar("juan6", "quetal", "juan6@gmail.com");
            gm.registrar("miguel18", "adios", "miguel18@outlook.es");
        }
    }


    @POST /* Añadimos un nuev usuario */
    @ApiOperation(value = "añadimos usuario a la lista", notes = "No notes")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuario.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")///addUsuario/{username}/{contraseña}/{email}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response nuevoUsuario(Usuario usuario) {

        if (usuario.getUsername()==null || usuario.getEmail()==null || usuario.getContraseña()==null)  return Response.status(500).entity(usuario).build();
        gm.registrar(usuario.getUsername(), usuario.getContraseña(), usuario.getEmail());
        return Response.status(201).entity(usuario).build();

    }

    @GET // Obtener lista de usuarios registrados ordenados alfabeticamente
    @ApiOperation(value = "Lista de usuarios", notes = "Lista de usuarios ordenados alfabeticamente")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Usuario.class ,responseContainer = "List"),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/listaUsuarios")
    public Response orderLista() {
        List<Usuario> usersList = this.gm.getSortedUsersList();
        GenericEntity<List<Usuario>> entity = new GenericEntity<List<Usuario>>(usersList) {};
        return Response.status(201).entity(entity).build();
    }

    @POST // Comprobar autenticación
    @ApiOperation(value = "Autenticacion", notes = "Autenticacion")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Usuario.class),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/checkLogin/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkLogin(Usuario user) {

            if (gm.logIn(user.getUsername(), user.getContraseña())) return Response.status(201).build();

            else return Response.status(404).build();
    }


}
