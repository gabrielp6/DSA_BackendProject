package edu.upc.dsa.services;
import edu.upc.dsa.DAO.*;
import edu.upc.dsa.GameManagerImpl;
import edu.upc.dsa.models.Partida;
import edu.upc.dsa.models.RecordUsuario;
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


@Api(value = "/estadisticas", description = "no")
@Path("/estadisticas")

public class EstadisticasService {

    private final GameManagerImpl gm;
    private final UsuarioDAO usuarioDAO;
    private final PartidaDAO partidaDAO;
    private final RecordUsuarioDAO recordDAO;

    public EstadisticasService() {
        this.gm = GameManagerImpl.getInstance();
        this.usuarioDAO = UsuarioImplDAO.getInstance();
        this.partidaDAO = PartidaImplDAO.getInstance();
        this.recordDAO = RecordUsuarioImplDAO.getInstance();

        if (gm.usuariosSize() == 0) {
            gm.registrar("toni11", "hola", "toni11@hotmail.com");
            gm.registrar("juan6", "quetal", "juan6@gmail.com");
            gm.registrar("miguel18", "adios", "miguel18@outlook.es");
        }
    }


    @GET
    @ApiOperation(value = "Todas las partidas jugadas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Partida.class, responseContainer="List"),
            @ApiResponse(code = 404, message = "No hay partidas")
    })
    @Path("/todasPartidas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPartidas() {

        List<Partida> listaPartidas = partidaDAO.readAll();

        if (listaPartidas == null){
            return Response.status(404).build();
        }

        else {
            GenericEntity<List<Partida>> entity = new GenericEntity<List<Partida>>(listaPartidas) {};
            return Response.status(200).entity(entity).build();
        }
    }



    @GET
    @ApiOperation(value = "Todas las partidas de un jugador")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Partida.class, responseContainer="List"),
            @ApiResponse(code = 404, message = "Usuario no encontrado")
    })
    @Path("/{username}/game")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPartidasUsuario(@PathParam("username") String username) {

        if (usuarioDAO.exists(username)) {

            List<Partida> listaPartidasUsuario = partidaDAO.readAllByParameter("username", username);

            GenericEntity<List<Partida>> entity = new GenericEntity<List<Partida>>(listaPartidasUsuario) {};
            return Response.status(200).entity(entity).build();

        }
        else {
            return Response.status(404).build();
        }
    }

    @GET
    @ApiOperation(value = "Mejor partida de un jugador")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Partida.class, responseContainer="List"),
            @ApiResponse(code = 404, message = "Usuario no encontrado")
    })
    @Path("/{username}/game")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRecordUsuario(@PathParam("username") String username) {

        if (usuarioDAO.exists(username)) {

            RecordUsuario record = recordDAO.readByParameter("username", username);

            GenericEntity<RecordUsuario> entity = new GenericEntity<RecordUsuario>(record) {};
            return Response.status(200).entity(entity).build();

        }
        else {
            return Response.status(404).build();
        }
    }

    @GET //Es una lista con la mejor partida de cada uno
    @ApiOperation(value = "Records de cada jugador")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Partida.class, responseContainer="List"),
            @ApiResponse(code = 404, message = "Resultados no encontrados")
    })
    @Path("/{username}/game")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRecords() {

        List<RecordUsuario> listaRecords = recordDAO.readAll();

        if (listaRecords == null) {
            return Response.status(404).build();
        }

        else {
            GenericEntity<List<RecordUsuario>> entity = new GenericEntity<List<RecordUsuario>>(listaRecords) {};
            return Response.status(200).entity(entity).build();
        }
    }
}