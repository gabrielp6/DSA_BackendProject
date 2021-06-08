package edu.upc.dsa.services;
import edu.upc.dsa.DAO.UsuarioImplDAO;
import edu.upc.dsa.GameManagerImpl;
import edu.upc.dsa.models.Credentials;
import edu.upc.dsa.models.Usuario;

import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Api(value = "/auth", description = "no")
@Path("")

public class AuthenticationService {

    private final GameManagerImpl gm;
    private UsuarioImplDAO userDAO;

    public AuthenticationService() {
        this.gm = GameManagerImpl.getInstance();
        if (gm.usuariosSize() == 0) {
            gm.registrar("toni11", "hola", "toni11@hotmail.com");
            gm.registrar("juan6", "quetal", "juan6@gmail.com");
            gm.registrar("miguel18", "adios", "miguel18@outlook.es");
        }
    }


    @POST
    @ApiOperation(value = "añadimos usuario a la lista", notes = "No notes")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuario.class),
            @ApiResponse(code = 404, message = "Usuario ya existente"),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/auth/registrarUsuario")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registrarUsuario(Usuario usuario) {

        /*
        if (usuario.getUsername()==null || usuario.getEmail()==null || usuario.getPassword()==null)
            return Response.status(500).entity(usuario).build();
        else{
        if (userDAO.exists(usuario.getUsername()) && userDAO.existsEmail(usuario.getEmail())) {
            return Response.stauts(400).build();
        } else {
            userDAO.create(usuario);
            return Response.status(201).build();
        }
        }
        */
        System.out.println("usuario:" + usuario);
        if (usuario.getUsername()==null || usuario.getEmail()==null || usuario.getPassword()==null)  return Response.status(500).entity(usuario).build();
        gm.registrar(usuario.getUsername(), usuario.getPassword(), usuario.getEmail());
        return Response.status(201).entity(usuario).build();

    }


    @POST // Comprobar autenticación
    @ApiOperation(value = "Autenticacion", notes = "Autenticacion")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Usuario.class),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 400, message = "Campos necesarios vacíos")
    })
    @Path("/auth/iniciarSesion")
    @Produces(MediaType.APPLICATION_JSON)
    public Response iniciarSesion(Credentials credentials) {

        /*
        if ((credentials.getUsername() == null)||(credentials.getPassword() == null)){
            return Response.status(400).build();
        }

        else{
        if (userDAO.exists(credentials.getUsername())){
            if (userDAO.correctPassword(credentials.getUsername(), credentials.getPassword()))
                return Response.status(200).build();
        }
        else{
            return Response.status(404).build();
        }
        }
         */

        if (gm.logIn(credentials.getUsername(), credentials.getPassword()))
            return Response.status(201).entity(credentials).build();

        else return Response.status(404).build();
    }

}
