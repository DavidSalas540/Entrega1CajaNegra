package es.upm.iw41.entrega1.cajaBlanca;

import main.Commons;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import space_invaders.sprites.Alien;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BombTest {
    private static final int MID_X = 150;
    private static final int MID_Y = 100;


    @Test
    @DisplayName("Bomb.initBomb - Path CP1")
    void testinitBomb_Path_CP1() {
        Alien alien = new Alien(MID_X, MID_Y);
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
}
