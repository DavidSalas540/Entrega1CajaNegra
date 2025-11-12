package es.upm.iw41.entrega1.cajaBlanca;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import space_invaders.sprites.Alien;

import static org.junit.jupiter.api.Assertions.*;

public class AlienTest{

    private static final int CENTRO_X = 150;
    private static final int OUT_BORDER_RIGHT = 359; // some docs used 359 as outside
    private static final int CENTRO_Y = 100;
    private static final int OUT_BORDER_UP = 351;
    private static final int OUT_BORDER_DOWN = -1;


    // MÉTODO ACT

    @Test
    @DisplayName("Alien.act - Path CP1")
    void testAct_Condition_CP1(){

    }


    // MÉTODO initAlien

    @Test
    @DisplayName("Alien.initAlien - Path CP1")
    void testinitAlien_Condition_CP1() {
        Alien alien = new Alien(CENTRO_X, CENTRO_Y);
        Alien.Bomb bomb = alien.getBomb();
        assertNotNull(bomb);
    }

    @Test
    @DisplayName("Alien.initAlien - Path CP2")
    void testinitAlien_Condition_CP2() {
        Alien alien = new Alien(OUT_BORDER_RIGHT, CENTRO_Y);
        Alien.Bomb bomb = alien.getBomb();
        assertNotNull(bomb);
    }

    @Test
    @DisplayName("Alien.initAlien - Path CP3")
    void testinitAlien_Condition_CP3() {
        Alien alien = new Alien(OUT_BORDER_DOWN, CENTRO_Y);
        Alien.Bomb bomb = alien.getBomb();
        assertNotNull(bomb);
    }

    @Test
    @DisplayName("Alien.initAlien - Path CP4")
    void testinitAlien_Condition_CP4() {
        Alien alien = new Alien(CENTRO_X, OUT_BORDER_UP);
        Alien.Bomb bomb = alien.getBomb();
        assertNotNull(bomb);
    }

    @Test
    @DisplayName("Alien.initAlien - Path CP5")
    void testinitAlien_Condition_CP5() {
        Alien alien = new Alien(CENTRO_X, OUT_BORDER_DOWN);
        Alien.Bomb bomb = alien.getBomb();
        assertNotNull(bomb);
    }

}

