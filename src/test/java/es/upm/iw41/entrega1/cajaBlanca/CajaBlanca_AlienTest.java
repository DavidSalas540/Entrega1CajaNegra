package es.upm.iw41.entrega1.cajaBlanca;

import main.Commons;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import space_invaders.sprites.Alien;

import static org.junit.jupiter.api.Assertions.*;

public class CajaBlanca_AlienTest {

    private static final int MID_X = 150;
    private static final int MID_Y = 100;
    private static final int OUT_BORDER_RIGHT = 359;
    private static final int OUT_BORDER_UP = 351;
    private static final int OUT_BORDER_DOWN = -1;


    @Test
    @DisplayName("Alien.act - Path CP1")
    void testAct_Condition_CP1(){
        int x = 5;
        Alien alien = new Alien(MID_X, MID_Y);
        alien.act(x);
        int res = MID_X - x;
        boolean result = alien.getX() == res;

        assertTrue(result);
    }


    @Test
    @DisplayName("Alien.initAlien - Path CP1")
    void testinitAlien_Condition_CP1() {
        Alien alien = new Alien(MID_X, MID_Y);
        Alien.Bomb bomb = alien.getBomb();

        assertNotNull(bomb);
    }

    @Test
    @DisplayName("Alien.initAlien - Path CP2")
    void testinitAlien_Condition_CP2() {
        int x = Commons.BOARD_WIDTH;
        Alien alien = new Alien(OUT_BORDER_RIGHT, MID_Y);
        assertEquals(x, alien.getX());
    }

    @Test
    @DisplayName("Alien.initAlien - Path CP3")
    void testinitAlien_Condition_CP3() {
        int x = 0;
        Alien alien = new Alien(OUT_BORDER_DOWN, MID_Y);
        assertEquals(x, alien.getX());
    }

    @Test
    @DisplayName("Alien.initAlien - Path CP4")
    void testinitAlien_Condition_CP4() {
        int y = Commons.BOARD_HEIGHT;
        Alien alien = new Alien(MID_X, OUT_BORDER_UP);
        assertEquals(y, alien.getY());
    }

    @Test
    @DisplayName("Alien.initAlien - Path CP5")
    void testinitAlien_Condition_CP5() {
        int y = 0;
        Alien alien = new Alien(MID_X, OUT_BORDER_DOWN);
        boolean result = alien.getX() == MID_X && alien.getY() == y;

        assertTrue(result);
    }
}
