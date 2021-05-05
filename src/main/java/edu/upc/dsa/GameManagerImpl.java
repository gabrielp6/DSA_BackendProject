package edu.upc.dsa;

import edu.upc.dsa.models.Usuario;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;


public class GameManagerImpl implements GameManager{

    public HashMap<String, Usuario> listaUsuariosHM;
    public List<Usuario> listaUsuarios;

    private static GameManagerImpl implementation;
    static final Logger logger = Logger.getLogger(GameManagerImpl.class.getName());

    public static GameManagerImpl getInstance()
    {
        if (implementation==null)
            implementation = new GameManagerImpl();

        return implementation;
    }

    public static void delete(){
        implementation = null;
        logger.info("Instancia game manager borrada");

    }

    public GameManagerImpl() {
        this.listaUsuariosHM = new HashMap<String, Usuario>();
        this.listaUsuarios = new LinkedList<>();
    }

    @Override
    public void registrar(String username, String contraseña) {
        Usuario usuario = new Usuario(username, contraseña);

        listaUsuariosHM.put(username, usuario);

        int idAsignado = listaUsuariosHM.size();
        usuario.setIdUsuario(idAsignado);

        logger.info("usuario añadido:" + username);
    }

    @Override
    public int usuariosSize() {
        return listaUsuariosHM.size();
    }


    @Override
    public Usuario getUser(String username) {
        for (Usuario usuario: this.listaUsuarios){
            String nombre = usuario.getUsername();
            if (username.equals(nombre)) {
                logger.info("Usuario "+ username +" encontrado");
                return usuario;
            }
        }
        logger.info("Usuario "+ username +" no existe");
        return null;
    }
}
