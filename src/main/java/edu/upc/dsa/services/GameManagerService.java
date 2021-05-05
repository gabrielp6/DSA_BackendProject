package edu.upc.dsa.services;
import edu.upc.dsa.GameManagerImpl;
import edu.upc.dsa.models.Usuario;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;


@Api(value = "/Game", description = "Endpoint to Game Service")
@Path("Game")


public class GameManagerService {

    private GameManagerImpl gm;

    public GameManagerService() {
        this.gm = GameManagerImpl.getInstance();
        if (gm.usuariosSize() == 0) {
            gm.registrar("toni11", "hola");
            gm.registrar("juan6", "quetal");
            gm.registrar("miguel18", "adios");
        }
    }


    @POST /* Añadimos un nuev usuario */
    @ApiOperation(value = "añadimos usuario a la lista", notes = "No notes")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuario.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/addUsuario/{username}/{contraseña}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response nuevoUsuario(@PathParam("username") String username, @PathParam("contraseña") String contraseña) {

        Usuario usuario = new Usuario(username, contraseña);
        gm.registrar(username, contraseña);
        return Response.status(201).entity(usuario).build();

    }


    @GET /* Obtener lista de usuarios registrados */
    @ApiOperation(value = "Lista de usuarios", notes = "No notes")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Usuario.class ,responseContainer = "List"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/listaUsuarios")
    public Response OrderLista() {
        //implementar
        return null;
    }
}
