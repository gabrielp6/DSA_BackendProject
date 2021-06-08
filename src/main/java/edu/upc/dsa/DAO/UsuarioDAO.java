package edu.upc.dsa.DAO;

import edu.upc.dsa.models.Credentials;
import edu.upc.dsa.models.Usuario;

import java.util.List;

public interface UsuarioDAO {

    boolean create(Usuario usuario);
    boolean registerUser(Usuario usuario);

    List<Usuario> readAll();
    Usuario readByParameter(String parameter, Object value);
    Object readParameterByParameter(String parameter, String byParameter, Object value);

    boolean exists(String username);
    boolean existsEmail(String email);
    boolean correctPassword(String username, String password);

    boolean update(Usuario usuario);
    boolean updateByParameter(Usuario usuario, String parameter, Object value);
    boolean updateParameterByParameter(String parameter, Object parameterValue, String byParameter, Object byParameterValue);

    boolean delete(Usuario usuario);
    boolean deleteByParameter(String parameter, Object value);
}
