package es.upm.iw41.entrega1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import space_invaders.sprites.Alien;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void crearAlienPosicionCorrecta(){
        int x = 10;
        int y = 10;
        Alien alien = new Alien(x,y);
        boolean resultado = alien.getX() == x && alien.getY() == y;
        assertTrue(resultado);
    }
}