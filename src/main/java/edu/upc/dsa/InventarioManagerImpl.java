package edu.upc.dsa;

import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.Usuario;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class InventarioManagerImpl implements InventarioManager{

    private static GameManager gameManager;
    private static InventarioManager implementation;
    static final Logger logger = Logger.getLogger(GameManagerImpl.class.getName());
    protected List<Objeto> objetos;

    public InventarioManagerImpl(){

        this.objetos = new LinkedList<>();

    }

    public static InventarioManager getInstance()
    {
        if (implementation==null)
            implementation = new InventarioManagerImpl();

        return implementation;
    }

    public static void delete(){
        implementation = null;
        logger.info("Instancia inventario manager borrada");

    }


    @Override
    public boolean Comprar(Objeto o) {

        Usuario user = gameManager.getUser(o.getIdUser());
        int coste = o.getCost();
        int monedasDisponibles = gameManager.getUser(o.getIdUser()).getCoins();

        if (coste > monedasDisponibles) {
            logger.info("No tienes suficiente dinero");
            return false;
        }

        else {
            int monedasActualizadas = (monedasDisponibles - coste);
            user.setCoins(monedasActualizadas);
            // gameManager.actualizarUsuario(user); HARÁ FALTA IMPLEMENTAR

            logger.info("Objeto" + o.getName() + "comprado por" + gameManager.getUser(o.getIdUser()).getUsername());
            return true;

        }
    }

    @Override
    public List<Objeto> mostrarObjetosUsuario(Usuario usuario) {
        return usuario.getObjectsList();
    }

    @Override
    public List<Objeto> mostrarTodosObjetos() {
        return this.objetos;
    }
}
