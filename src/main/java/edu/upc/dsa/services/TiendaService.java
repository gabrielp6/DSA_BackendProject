package edu.upc.dsa.services;
import edu.upc.dsa.DAO.ObjetoDAO;
import edu.upc.dsa.DAO.ObjetoImplDAO;
import edu.upc.dsa.GameManagerImpl;

import edu.upc.dsa.InventarioManagerImpl;
import edu.upc.dsa.models.Objeto;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Api(value = "/tienda", description = "Servicios de la tienda")
@Path("/tienda")
public class TiendaService {

    private GameManagerImpl gm;
    private InventarioManagerImpl im;
    private final ObjetoDAO objetoDAO;

    public TiendaService() {
        this.gm = GameManagerImpl.getInstance();
        objetoDAO = ObjetoImplDAO.getInstance();
    }



    @GET //Ver catalogo del juego
    @ApiOperation(value = "catalogo", notes = "Devuelve todos los objetos del juego")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Objeto.class, responseContainer="List"),
    })
    @Path("/catalogo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllObjetos() {

        List<Objeto> objetos = this.im.mostrarTodosObjetos();

        GenericEntity<List<Objeto>> entity = new GenericEntity<List<Objeto>>(objetos) {};
        return Response.status(201).entity(entity).build();

    }



    @GET //Obtener inventario de un usuario
    @ApiOperation(value = "Obtener inventario con su nombre", notes = "No")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful",  response= Objeto.class ,responseContainer = "List"),
            @ApiResponse(code = 404, message = "Not found")
    })
    @Path("/getInventario/{nombre}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getInventario(@PathParam("nombre") String nombre){

        List<Objeto> objetos=this.im.mostrarObjetosUsuario(gm.getUser(nombre));
        GenericEntity<List<Objeto>> entity = new GenericEntity<List<Objeto>>(objetos) {};

        if(objetos==null) return Response.status(404).build();
        else return Response.status(201).entity(entity).build();
    }



/*
    @POST //Comprar objeto
    @ApiOperation(value = "comprar objeto", notes = "No")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Objeto.class),
            @ApiResponse(code = 402, message = "No tienes suficiente dinero"),
            @ApiResponse(code = 404, message = "Not found"),
    })
    @Path("/comprarObjeto/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response comprarObjeto(@PathParam("nombre") String nombre){

        if(ObjetoDAO.exists(nombre)) {
           // int id = (int) objetoDAO.readParameterByParameter("id", "name", nombre);
            //Objeto objeto = ObjetoDAO.readByParameter("id", id);

            //if (objeto.getCoste() //> monedas del usuario) {

              //  return Response.status(701).entity(objeto).build();

            }
        }*/


}
