package edu.upc.dsa.DAO;

import edu.upc.dsa.FactorySession;
import edu.upc.dsa.Session;
import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.Usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class UsuarioImplDAO implements UsuarioDAO{

    private static UsuarioDAO instance;
    private final Session session;


    private UsuarioImplDAO() {
        session = FactorySession.openSession();
    }

    public static UsuarioDAO getInstance() {
        if (instance == null) instance = new UsuarioImplDAO();
        return instance;
    }


    @Override
    public boolean create(Usuario usuario) {
        return session.create(usuario);
    }

    @Override
    public boolean registerUser(Usuario usuario) {

        Usuario nuevoUsuario = new Usuario(usuario.getUsername(), usuario.getPassword(), usuario.getEmail());

        return session.create(nuevoUsuario);
    }

    @Override
    public List<Usuario> readAll() {
        Session session = null;
        List<Usuario> listaUsuario = null;
        List<String> params= new LinkedList<>();

        try{

            String query = "SELECT * FROM Usuario;";
            session = FactorySession.openSession();
            //String query = "SELECT * FROM objetos";
            listaUsuario = (List) session.queryObjects(query, Usuario.class, params);
        }
        catch(Exception e) {
            e.printStackTrace();

        }
        finally {
            if(session!=null){
                session.close();
            }
        }
        return listaUsuario;
    }


    @Override
    public Usuario readByParameter(String parameter, Object value) {
        return ((Usuario) session.readByParameter(Usuario.class, parameter, value));
    }

    @Override
    public Object readParameterByParameter(String parameter, String byParameter, Object value) {
        return session.readParameterByParameter(Usuario.class, parameter, byParameter, value);
    }

    @Override
    public boolean exists(String username) {

        if (session.readParameterByParameter(Usuario.class, "username", "username", username) == null)
            return false;
        else
            return true;
    }

    @Override
    public boolean existsEmail(String email) {
        if (session.readByParameter(Usuario.class, "email", email) == null)
            return false;
        else
            return true;
    }

    @Override
    public boolean readPassword(String username, String password) {
        String passwordUsuario = (String) session.readParameterByParameter(Usuario.class, "password", "username", username);
        if (password.equals(passwordUsuario))
            return true;
        else
            return false;
    }

    @Override
    public boolean update(Usuario usuario) {
        return session.update(usuario);
    }

    @Override
    public boolean updateByParameter(Usuario usuario, String parameter, Object value) {
        return session.updateByParameter(usuario, parameter, value);
    }

    @Override
    public boolean updateParameterByParameter(String parameter, Object parameterValue, String byParameter, Object byParameterValue) {
        return session.updateParameterByParameter(Usuario.class, parameter, parameterValue, byParameter, byParameterValue);
    }

    @Override
    public boolean delete(Usuario usuario) {
        return session.delete(usuario);
    }

    @Override
    public boolean deleteByParameter(String parameter, Object value) {
        return session.deleteByParameter(Usuario.class, parameter, value);
    }
}
