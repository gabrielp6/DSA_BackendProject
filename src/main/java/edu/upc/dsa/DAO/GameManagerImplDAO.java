package edu.upc.dsa.DAO;

import edu.upc.dsa.FactorySession;
import edu.upc.dsa.Session;
import edu.upc.dsa.models.Credentials;
import edu.upc.dsa.models.Usuario;

import java.util.*;
import java.util.logging.Logger;


public class GameManagerImplDAO implements GameManagerDAO {

    /*
    public HashMap<String, Usuario> listaUsuariosHM;
    public List<Usuario> listaUsuarios;

     */

    private static GameManagerImplDAO implementation;
    static final Logger logger = Logger.getLogger(GameManagerImplDAO.class.getName());

    public static GameManagerImplDAO getInstance() {
        if (implementation == null) {
            implementation = new GameManagerImplDAO();
        }

        return implementation;
    }

    public static void delete() {
        implementation = null;
        logger.info("Instancia game manager borrada");

    }

    /*
    public GameManagerImplDAO() {
        this.listaUsuariosHM = new HashMap<>();
        this.listaUsuarios = new LinkedList<>();
    }
     */

    @Override
    public void registrar(String username, String password, String email) {
        Session session = null;
        int coins =900;
        //int userID = 0;
        try {
            session = FactorySession.openSession();
            Usuario usuario = new Usuario(username, password, email, coins);
            session.save(usuario);
            logger.info("Usuario añadido:" + username);
        }
        catch (Exception e) {
            logger.warning("Error al registrar");
        }
        finally {
            session.close();
        }
        //return userID;
    }


    @Override
    public boolean logIn(String username, String password) {
        Usuario user = listaUsuariosHM.get(username);
        try {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        } catch (NullPointerException nullPointerException) {
            return false;
        }
        return false;
    }

    public int logIn(String username, String password) {
        Session session = null;
        int userID = getUser(username).getIdUsuario();
        Usuario usuario = null;
        try {

            user = (User)session.get(User.class, id);
            if(user==null) throw new UserNotFoundException();
            if(!password.equals(user.getPassword())) throw new PasswordNotMatchException();


            session = FactorySession.openSession();


            Credentials credentials = new Credentials(username, password);
            session.save(credentials);
            logger.info("Usuario logeado:" + username);
        }
        catch (Exception e) {
            logger.warning("Error al registrar");
        }
        finally {
            session.close();
        }
        return userID;
    }

    //implementar logIn
    @Override
    public User logIn(String username, String password) throws UserNotFoundException, PasswordNotMatchException, UserAlreadyConectedException {
        int id = getIdUser(username,password);
        SessionManager session = null;
        User user = null;
        try{
            session = FactorySessionManager.openSession();
            user = (User)session.get(User.class, id);
            if(user==null) throw new UserNotFoundException();
            if(!password.equals(user.getPassword())) throw new PasswordNotMatchException();
        } catch (Exception e) {
            log.error("Error al logearse en el sistema", e);
        }
        finally {
            session.close();
        }
        //si el estado del usuario conectado es false no estará conectado
        if(user.isConnected() == false) {
            //cambiamos el estado booleano a true
            user.setConnected(true);

            try {
                session = FactorySessionManager.openSession();
                session.update(user, id, false);
            } catch (Exception e) {
                throw new UserNotFoundException();
            } finally {
                session.close();
            }
        }
        else{
            throw new UserAlreadyConectedException();
        }
        return user;
    }

















    @Override
    public int usuariosSize() {
        return listaUsuariosHM.size();
    }

    @Override
    public Usuario getUser(String username) {
        for (Usuario usuario : this.listaUsuarios) {
            String nombre = usuario.getUsername();
            if (username.equals(nombre)) {
                logger.info("Usuario " + username + " encontrado");
                return usuario;
            }
        }
        logger.info("Usuario " + username + " no existe");
        return null;
    }

    @Override
    public List<Usuario> getSortedUsersList() {
        List<Usuario> _userList = new ArrayList<>(this.listaUsuariosHM.values());
        if (!listaUsuariosHM.isEmpty()) {
            Collections.sort(_userList, new Comparator<Usuario>() {
                @Override
                public int compare(Usuario o1, Usuario o2) {
                    return o1.getUsername().compareTo(o2.getUsername());
                }
            });
        }
        return _userList;
    }

    @Override
    public int borrarUsuario(String username) {
        int encontrado = 0;

        for (Usuario usuario : this.listaUsuarios) {
            if (usuario.getUsername().equals(username))
                encontrado = 1;
        }
        
        return encontrado;
    }
}
