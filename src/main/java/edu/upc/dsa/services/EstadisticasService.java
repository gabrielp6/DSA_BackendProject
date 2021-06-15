package edu.upc.dsa.services;
import edu.upc.dsa.DAO.*;
import edu.upc.dsa.GameManagerImpl;
import edu.upc.dsa.models.*;

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



    @POST
    @ApiOperation(value = "añadimos partida", notes = "No notes")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Partida.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/añadirPartida")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registrarPartida(CredentialsPartida credentialsPartida) {

        Partida partida = new Partida(credentialsPartida.getUsername(), credentialsPartida.getEnemigosMatados(), credentialsPartida.getTiempo(), credentialsPartida.getMonedasRecogidas());
        if (credentialsPartida.getUsername() == null)
            return Response.status(500).build();
        else {
            partidaDAO.create(partida);
            /*RecordUsuario recordUsuario = recordDAO.readByParameter("username", partida.getUsername());
            if(partida.getPuntuacionFinal() > recordUsuario.getPuntuacionFinal()){
                recordDAO.delete(recordUsuario);
                RecordUsuario nuevoRecord = new RecordUsuario(partida.getUsername(), partida.getEnemigosMatados(), partida.getTiempo(), partida.getMonedasRecogidas(), partida.getPuntuacionFinal());
                recordDAO.create(nuevoRecord);
            }*/
            return Response.status(200).entity(partida).build();
            }
    }


    @GET
    @ApiOperation(value = "Todas las partidas jugadas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Partida.class, responseContainer="List")
    })
    @Path("/todasPartidas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPartidas() {

        List<Partida> listaPartidas = partidaDAO.getAllPartida();

        GenericEntity<List<Partida>> entity = new GenericEntity<List<Partida>>(listaPartidas) {};
        return Response.status(200).entity(entity).build();
    }




    @GET
    @ApiOperation(value = "Todas las partidas de un jugador")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Partida.class, responseContainer="List"),
            @ApiResponse(code = 404, message = "Usuario no encontrado")
    })
    @Path("/partidasUsuario/{username}")
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
    @Path("/recordUsuario/{username}")
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
            @ApiResponse(code = 200, message = "Successful", response = RecordUsuario.class, responseContainer="List"),
            @ApiResponse(code = 404, message = "Resultados no encontrados")
    })
    @Path("/records")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRecords() {

        List<RecordUsuario> listaRecords = recordDAO.getAll();

        if (listaRecords == null) {
            return Response.status(404).build();
        }

        else {
            GenericEntity<List<RecordUsuario>> entity = new GenericEntity<List<RecordUsuario>>(listaRecords) {};
            return Response.status(200).entity(entity).build();
        }
    }
}