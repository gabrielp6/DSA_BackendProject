package edu.upc.dsa.DAO;

import edu.upc.dsa.models.Inventario;
import edu.upc.dsa.models.Objeto;
import io.swagger.models.auth.In;

import java.util.List;

public interface InventarioDAO {

    boolean create(Inventario inventario);

    Inventario readByParameter(String parameter, Object value);
    Object readParameterByParameter(String parameter, String byParameter, Object value);

    boolean update(Inventario inventario);
    boolean updateByParameter(Inventario inventario, String parameter, Object value);

    boolean delete(Inventario inventario);
    boolean deleteByParameter(String parameter, Object value);
}
