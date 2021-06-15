package edu.upc.dsa.services;
import edu.upc.dsa.DAO.*;
import edu.upc.dsa.GameManagerImpl;
import edu.upc.dsa.models.*;

import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Api(value = "/auth", description = "no")
@Path("")

public class AuthenticationService {

    private final GameManagerImpl gm;
    private UsuarioDAO usuarioDAO;
    private InventarioDAO inventarioDAO;
    private RecordUsuarioDAO recordUsuarioDAO;

    public AuthenticationService() {
        this.gm = GameManagerImpl.getInstance();
        this.usuarioDAO = UsuarioImplDAO.getInstance();
        this.inventarioDAO = InventarioImplDAO.getInstance();
        this.recordUsuarioDAO = RecordUsuarioImplDAO.getInstance();
        if (gm.usuariosSize() == 0) {
            gm.registrar("toni11", "hola", "toni11@hotmail.com");
            gm.registrar("juan6", "quetal", "juan6@gmail.com");
            gm.registrar("miguel18", "adios", "miguel18@outlook.es");
        }
    }


    @POST
    @ApiOperation(value = "añadimos usuario a la lista", notes = "No notes")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Usuario.class),
            @ApiResponse(code = 404, message = "Usuario ya existente"),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/auth/registrarUsuario")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registrarUsuario(CredentialsRegister credentialsRegister) {

        Usuario usuario = new Usuario(credentialsRegister.getUsername(), credentialsRegister.getPassword(), credentialsRegister.getEmail());
        Inventario inventario = new Inventario(credentialsRegister.getUsername());
        RecordUsuario recordUsuario = new RecordUsuario(credentialsRegister.getUsername(), 0, 0, 0, 0);
        if (credentialsRegister.getUsername().isEmpty() || credentialsRegister.getEmail().isEmpty() || credentialsRegister.getPassword().isEmpty())
            return Response.status(500).build();
        else {
            if (usuarioDAO.exists(credentialsRegister.getUsername()) || usuarioDAO.existsEmail(credentialsRegister.getEmail())) {
                return Response.status(400).build();
            } else {
                usuarioDAO.create(usuario);
                inventarioDAO.create(inventario);
                recordUsuarioDAO.create(recordUsuario);
                return Response.status(200).entity(usuario).build();
            }
        }
    }


    @POST // Comprobar autenticación
    @ApiOperation(value = "Autenticacion", notes = "Autenticacion")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Usuario.class),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 405, message = "Nombre y contraseña no coinciden"),
            @ApiResponse(code = 500, message = "Campos necesarios vacíos")
    })
    @Path("/auth/iniciarSesion")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response iniciarSesion(CredentialsLogIn credentialsLogIn) {
        String username = credentialsLogIn.getUsername();
        Usuario usuario = usuarioDAO.readByParameter("username", username);
        if ((credentialsLogIn.getUsername().isEmpty()) || (credentialsLogIn.getPassword().isEmpty())) {
            return Response.status(500).build();
        }

        if (usuarioDAO.exists(credentialsLogIn.getUsername())){
            if (usuarioDAO.readPassword(credentialsLogIn.getUsername(), credentialsLogIn.getPassword())) {
                return Response.status(200).entity(usuario).build();
            }
            else
                return Response.status(405).build();
        }
        else
            return Response.status(404).build();

    }
}
