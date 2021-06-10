package edu.upc.dsa.services;
import edu.upc.dsa.DAO.UsuarioDAO;
import edu.upc.dsa.DAO.UsuarioImplDAO;
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


@Api(value = "/user", description = "no")
@Path("/user")

public class UserService {

    private final GameManagerImpl gm;
    private final UsuarioDAO usuarioDAO;

    public UserService() {
        this.gm = GameManagerImpl.getInstance();
        this.usuarioDAO = UsuarioImplDAO.getInstance();

        if (gm.usuariosSize() == 0) {
            gm.registrar("toni11", "hola", "toni11@hotmail.com");
            gm.registrar("juan6", "quetal", "juan6@gmail.com");
            gm.registrar("miguel18", "adios", "miguel18@outlook.es");
        }
    }



    @GET // Obtener lista de usuarios registrados
    @ApiOperation(value = "Lista de usuarios", notes = "Lista de usuarios")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response= Usuario.class ,responseContainer = "List"),
            @ApiResponse(code = 404, message = "No hay usuarios")
    })
    @Path("/listaUsuarios")
    public Response orderLista() {

        List<Usuario> listaUsuarios = usuarioDAO.readAll();

        if(listaUsuarios == null){
            return Response.status(404).build();
        }
        else {
            GenericEntity<List<Usuario>> entity = new GenericEntity<List<Usuario>>(listaUsuarios) {};
            return Response.status(201).entity(entity).build();
        }

        /*
        List<Usuario> usersList = this.gm.getSortedUsersList();
        GenericEntity<List<Usuario>> entity = new GenericEntity<List<Usuario>>(usersList) {};
        return Response.status(201).entity(entity).build();

         */
    }


    @DELETE //Borrar usuario
    @ApiOperation(value = "Borrar Usuario", notes = "No")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Usuarrio Not Found")
    })
    @Path("/borrarUsuario/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response borrarUsuario(@PathParam("username") String username) {


        if (usuarioDAO.exists(username)) {
            usuarioDAO.deleteByParameter("username", username);
            return Response.status(200).build();
        }

        else {
            return Response.status(404).build();
        }

        /*
        int usuario = this.gm.borrarUsuario(user.getUsername());
        if(usuario == 0) return Response.status(404).build();
         */
    }


    @GET //obtener un usuario
    @ApiOperation(value = "obtener usuario", notes = "No")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuario.class),
            @ApiResponse(code = 404, message = "Usuario no encontrado")
    })
    @Path("/obtenerUsuario/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuario(@PathParam("username") String username) {

        Usuario usuario = usuarioDAO.readByParameter("username", username);

        if(usuario == null){
            return Response.status(404).build();
        }
        else {
            GenericEntity<Usuario> entity = new GenericEntity<Usuario>(usuario) {};
            return Response.status(201).entity(entity).build();
        }
        /*
        Usuario u = this.gm.getUser(username);
        if (u == null) return Response.status(404).build();
        else  return Response.status(201).entity(u).build();

         */
    }
}
