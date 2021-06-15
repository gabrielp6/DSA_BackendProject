package edu.upc.dsa.DAO;

import edu.upc.dsa.models.Partida;

import java.util.List;

public interface PartidaDAO {

    boolean create(Partida partida);

    List<Partida> readAll();
    List<Partida> readAllByParameter(String parameter, Object value);
    Partida readByParameter(String parameter, Object value);
    List<Partida> getAllPartida();

    boolean update(Partida partida);
    boolean updateByParameter(Partida partida, String parameter, Object value);
    boolean updateParameterByParameter(String parameter, Object parameterValue, String byParameter, Object byParameterValue);

    boolean delete(Partida partida);
    boolean deleteByParameter(String parameter, Object value);
}
