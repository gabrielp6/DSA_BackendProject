package edu.upc.dsa;

import edu.upc.dsa.models.Usuario;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class GameManagerTest {

    @Before
    public void setUp(){
        Usuario u1 = new Usuario("toni11","hola");
        Usuario u2 = new Usuario("juan6","quetal");
        Usuario u3 = new Usuario("miguel18","adios");

        GameManagerImpl.getInstance().registrar("toni11", "hola");
        GameManagerImpl.getInstance().registrar("juan6", "quetal");
        GameManagerImpl.getInstance().registrar("miguel18", "adios");

    }


    @Test
    public void registrar() {
        Usuario u4 = new Usuario("carla21","bien");
        GameManagerImpl.getInstance().registrar("carla21", "bien");
        assertEquals(4, GameManagerImpl.getInstance().usuariosSize());
    }


    @After
    public void tearDown(){
        GameManagerImpl.getInstance().delete();
    }
}
