package edu.upc.dsa.services;
import edu.upc.dsa.DAO.ObjetoDAO;
import edu.upc.dsa.DAO.ObjetoImplDAO;
import edu.upc.dsa.DAO.UsuarioDAO;
import edu.upc.dsa.DAO.UsuarioImplDAO;
import edu.upc.dsa.GameManagerImpl;

import edu.upc.dsa.InventarioManagerImpl;
import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.Usuario;
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
    private final UsuarioDAO usuarioDAO;

    public TiendaService() {
        this.gm = GameManagerImpl.getInstance();
        objetoDAO = ObjetoImplDAO.getInstance();
        usuarioDAO = UsuarioImplDAO.getInstance();
    }



    @GET //Ver catalogo del juego
    @ApiOperation(value = "catalogo", notes = "Devuelve todos los objetos del juego")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Objeto.class, responseContainer="List"),
    })
    @Path("/catalogo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllObjetos() {

       /*
       List<Objeto> objetos = this.im.mostrarTodosObjetos();

        GenericEntity<List<Objeto>> entity = new GenericEntity<List<Objeto>>(objetos) {};
        return Response.status(201).entity(entity).build();

        */
        List<Objeto> listaObjetos = objetoDAO.readAll();
        GenericEntity<List<Objeto>> entity = new GenericEntity<List<Objeto>>(listaObjetos) {};
        return Response.status(200).entity(entity).build();

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



    @POST //Comprar objeto
    @ApiOperation(value = "comprar objeto", notes = "No")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Objeto.class),
            @ApiResponse(code = 402, message = "No tienes suficiente dinero"),
            @ApiResponse(code = 404, message = "Not found"),
    })
    @Path("/comprarObjeto/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response comprarObjeto(@PathParam("nombre") String nombre, @QueryParam("username") String username){

        if(objetoDAO.exists(nombre)) {

            Objeto objeto = objetoDAO.readByParameter("nombre", nombre);
            Usuario usuario = usuarioDAO.readByParameter("username", username);

            if(objeto.getCoste() > usuario.getCoins()){
                    return Response.status(402).build();
            }
            else{

                int monedasActualizadas = usuario.getCoins()-objeto.getCoste();
                usuarioDAO.updateParameterByParameter("coins", monedasActualizadas, "username", username);
                return Response.status(200).build();
            }
            }

        else{
            return Response.status(404).build();
        }
        }



}
