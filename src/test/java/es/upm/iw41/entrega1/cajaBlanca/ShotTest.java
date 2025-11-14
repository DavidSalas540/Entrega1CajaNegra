package es.upm.iw41.entrega1.cajaBlanca;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import space_invaders.sprites.Shot;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShotTest {

    private static final int MID_X = 150;
    private static final int MID_Y = 100;


    @Test
    @DisplayName("Shot.initShot - Path CP1")
    void testinitShot_Path_CP1() {
        Shot shot = new Shot(MID_X, MID_Y);
        boolean result = shot.getX() > MID_X && shot.getY() < MID_Y;
        assertTrue(result);
    }
}
