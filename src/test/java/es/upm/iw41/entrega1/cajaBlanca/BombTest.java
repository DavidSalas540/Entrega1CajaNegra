package es.upm.iw41.entrega1.cajaBlanca;

import main.Commons;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import space_invaders.sprites.Alien;
import space_invaders.sprites.Alien.Bomb;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BombTest {
    private static final int CENTRO_X = 150;
    private static final int CENTRO_Y = 100;

    @Test
    @DisplayName("Bomb.initBomb - Path CP1")
    void testinitBomb_Path_CP1() {
        Alien alien = new Alien(CENTRO_X,CENTRO_Y);
        Alien.Bomb bomb = alien.getBomb();

        assertNotNull(bomb);
    }

    @Test
    @DisplayName("Bomb.initBomb - Path CP2")
    void testinitBomb_Path_CP2() {
        int x_false = Commons.BOARD_WIDTH + 1;
        int y_false = Commons.BOARD_HEIGHT + 1;
        Alien alien = new Alien(x_false,y_false);
        Alien.Bomb bomb = alien.getBomb();

        assertNotNull(bomb);
    }

    @Test
    @DisplayName("Bomb.initBomb - Condition CP3")
    void testinitBomb_Condition_CP3() {
        int x = Commons.BOARD_WIDTH;
        int y = Commons.BOARD_HEIGHT;
        Alien alien = new Alien(Commons.BOARD_WIDTH,Commons.BOARD_HEIGHT);
        Alien.Bomb bomb = alien.getBomb();

        boolean result = bomb.getX() == x+1 && bomb.getY() == y+1;
        assertTrue(result);
    }

    @Test
    @DisplayName("Bomb.initBomb - Condition CP4")
    void testinitBomb_Condition_CP4() {
        int y_false = Commons.BOARD_HEIGHT + 1;
        Alien alien = new Alien(Commons.BOARD_WIDTH,y_false);
        Alien.Bomb bomb = alien.getBomb();

        boolean result = bomb.getX() == Commons.BOARD_WIDTH && bomb.getY() == Commons.BOARD_HEIGHT;
        assertTrue(result);
    }

    @Test
    @DisplayName("Bomb.initBomb - Condition CP5")
    void testinitBomb_Condition_CP5() {
        int x_false = Commons.BOARD_WIDTH + 1;
        Alien alien = new Alien(x_false,Commons.BOARD_HEIGHT);
        Alien.Bomb bomb = alien.getBomb();

        boolean result = bomb.getX() == Commons.BOARD_WIDTH && bomb.getY() == Commons.BOARD_HEIGHT;
        assertTrue(result);
    }

    @Test
    @DisplayName("Bomb.initBomb - Condition CP6")
    void testinitBomb_Condition_CP6() {
        int x_false = Commons.BOARD_WIDTH + 1;
        int y_false = Commons.BOARD_HEIGHT + 1;
        Alien alien = new Alien(x_false,y_false);
        Alien.Bomb bomb = alien.getBomb();

        boolean result = bomb.getX() == Commons.BOARD_WIDTH && bomb.getY() == Commons.BOARD_HEIGHT;
        assertTrue(result);
    }
}
