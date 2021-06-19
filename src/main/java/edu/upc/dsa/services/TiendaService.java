package edu.upc.dsa.services;
import edu.upc.dsa.DAO.*;
import edu.upc.dsa.GameManagerImpl;

import edu.upc.dsa.InventarioManagerImpl;
import edu.upc.dsa.models.*;
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
    private final InventarioDAO inventarioDAO;

    public TiendaService() {
        this.gm = GameManagerImpl.getInstance();
        objetoDAO = ObjetoImplDAO.getInstance();
        inventarioDAO = InventarioImplDAO.getInstance();
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

        List<Objeto> listaObjetos = objetoDAO.readAll();
        GenericEntity<List<Objeto>> entity = new GenericEntity<List<Objeto>>(listaObjetos) {};
        return Response.status(200).entity(entity).build();

    }


    @POST //Comprar objeto
    @ApiOperation(value = "comprar objeto", notes = "No")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 402, message = "No tienes suficiente dinero"),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 405, message = "Objeto not found")
    })
    @Path("/comprarObjeto")
    @Produces(MediaType.APPLICATION_JSON)
    public Response comprarObjeto(CredentialsCompra credentialsCompra){

        String nombre = credentialsCompra.getNombreObjeto();
        String username = credentialsCompra.getUsername();
        int monedasRestantes = credentialsCompra.getMonedasActualizadas();

        if (usuarioDAO.exists(username)) {
            if (objetoDAO.exists(nombre)) {
                Objeto objeto = objetoDAO.readByParameter("nombre", nombre);
                Usuario usuario = usuarioDAO.readByParameter("username", username);
                Inventario inventario = inventarioDAO.readByParameter("username", username);

                if (objeto.getCoste() > usuario.getCoins()) {
                    return Response.status(402).build();
                } else {
                    int suma = 0;
                    if (nombre.equals("escudoOro")) {
                        suma = inventario.getEscudoOro() + 1;
                        usuarioDAO.updateParameterByParameter("vida", usuario.getVida() + 50, "username", username);
                    }
                    if (nombre.equals("escudoPlata")) {
                        suma = inventario.getEscudoPlata() + 1;
                        usuarioDAO.updateParameterByParameter("vida", usuario.getVida() + 20, "username", username);
                    }
                    if (nombre.equals("escudoMadera")) {
                        suma = inventario.getEscudoMadera() + 1;
                        usuarioDAO.updateParameterByParameter("vida", usuario.getVida() + 10, "username", username);
                    }
                    if (nombre.equals("flechaOro")) {
                        suma = inventario.getFlechaOro() + 1;
                        usuarioDAO.updateParameterByParameter("fuerza", usuario.getFuerza() + 5, "username", username);
                    }
                    if (nombre.equals("flechaPlata")) {
                        suma = inventario.getFlechaPlata() + 1;
                        usuarioDAO.updateParameterByParameter("fuerza", usuario.getFuerza() + 3, "username", username);
                    }
                    if (nombre.equals("flechaMadera")) {
                        suma = inventario.getFlechaMadera() + 1;
                        usuarioDAO.updateParameterByParameter("fuerza", usuario.getFuerza() + 1, "username", username);
                    }
                    if (nombre.equals("manzana")) {
                        suma = inventario.getManzana() + 1;
                    }
                    if (nombre.equals("pocionRoja")) {
                        suma = inventario.getPocionRoja() + 1;
                    }
                    if (nombre.equals("pocionAzul")) {
                        suma = inventario.getPocionAzul() + 1;
                    }

                    inventarioDAO.updateParameterByParameter(nombre, suma, "username", username);
                    monedasRestantes = usuario.getCoins() - objeto.getCoste();
                    credentialsCompra.setMonedasActualizadas(monedasRestantes);
                    usuarioDAO.updateParameterByParameter("coins", monedasRestantes, "username", username);
                    return Response.status(200).entity(credentialsCompra).build();
                }
            } else {
                return Response.status(405).build();
            }
        }
        else
            return Response.status(404).build();
        }


    @POST //Consumir objeto
    @ApiOperation(value = "Consumir objeto", notes = "No")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 402, message = "No tienes suficientes unidades"),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 405, message = "Objeto not found")
    })
    @Path("/consumirObjeto")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consumirObjeto(CredentialsCompra credentialsCompra){

        String nombre = credentialsCompra.getNombreObjeto();
        String username = credentialsCompra.getUsername();

        if (usuarioDAO.exists(username)) {
            if (objetoDAO.exists(nombre)) {
                Objeto objeto = objetoDAO.readByParameter("nombre", nombre);
                Usuario usuario = usuarioDAO.readByParameter("username", username);
                Inventario inventario = inventarioDAO.readByParameter("username", username);

                if (nombre.equals("manzana")) {
                    if (inventario.getManzana() == 0)
                        return Response.status(402).build();
                    else {
                        int resta = inventario.getManzana() - 1;
                        inventarioDAO.updateParameterByParameter(nombre, resta, "username", username);
                        return Response.status(200).build();
                    }
                }


                if (nombre.equals("pocionRoja")) {
                        if (inventario.getPocionRoja() == 0)
                            return Response.status(402).build();
                        else {
                            int resta = inventario.getPocionRoja() - 1;
                            inventarioDAO.updateParameterByParameter(nombre, resta, "username", username);
                            return Response.status(200).build();
                        }
                }


                if (nombre.equals("pocionAzul")) {
                    if (inventario.getPocionRoja() == 0)
                        return Response.status(402).build();
                    else {
                        int resta = inventario.getPocionAzul() - 1;
                        inventarioDAO.updateParameterByParameter(nombre, resta, "username", username);
                        return Response.status(200).build();
                    }
                }
                else
                return Response.status(405).build();
            }
            else {
                return Response.status(405).build();
            }
        }
        else
            return Response.status(404).build();
    }


    @GET //obtener inventario de un usuario
    @ApiOperation(value = "obtener inventario de un usuario", notes = "No")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Inventario.class),
            @ApiResponse(code = 404, message = "Usuario no encontrado")
    })
    @Path("/obtenerInventarioUsuario/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInventarioUsuario(@PathParam("username") String username) {

        Inventario inventario = inventarioDAO.readByParameter("username", username);

        if(inventario == null){
            return Response.status(404).build();
        }
        else {
            GenericEntity<Inventario> entity = new GenericEntity<Inventario>(inventario) {};
            return Response.status(200).entity(entity).build();
        }
    }

}
