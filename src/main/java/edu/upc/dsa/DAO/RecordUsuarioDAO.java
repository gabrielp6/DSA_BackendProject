package edu.upc.dsa.DAO;

import edu.upc.dsa.models.Partida;
import edu.upc.dsa.models.RecordUsuario;

import java.util.List;

public interface RecordUsuarioDAO {

    boolean create(RecordUsuario record);

    List<RecordUsuario> readAll();
    RecordUsuario readByParameter(String parameter, Object value);

    boolean update(RecordUsuario record);
    boolean updateByParameter(RecordUsuario record, String parameter, Object value);
    boolean updateParameterByParameter(String parameter, Object parameterValue, String byParameter, Object byParameterValue);

    boolean delete(RecordUsuario record);
    boolean deleteByParameter(String parameter, Object value);
}
