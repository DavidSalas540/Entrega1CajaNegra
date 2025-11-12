package es.upm.iw41.entrega1.cajaBlanca;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import space_invaders.sprites.Shot;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShotTest {

    private static final int CENTRO_X = 150;
    private static final int BORDER_LEFT = 5;
    private static final int BORDER_RIGHT = 328;
    private static final int CENTRO_Y = 100;
    private static final int BORDER_UP = 350;
    private static final int BORDER_DOWN = 0;

    // METODO initShot(int x, int y)

    @Test
    @DisplayName("Shot.initShot - Path CP1")
    void testinitShot_Path_CP1() {
        Shot shot = new Shot(CENTRO_X, CENTRO_Y);
        boolean resultado = shot.getX() >= BORDER_LEFT && shot.getX() <= BORDER_RIGHT &&
                shot.getY() <= BORDER_UP && shot.getY() >= BORDER_DOWN;
        assertTrue(resultado);
    }
}
