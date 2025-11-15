package es.upm.iw41.entrega1.cajaNegra;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import space_invaders.sprites.Shot;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CajaNegra_ShotTest {

    private static final int MID_X = 150;
    private static final int BORDER_LEFT = 5;
    private static final int INSIDE_BORDER_LEFT = 6;
    private static final int BORDER_RIGHT = 328;
    private static final int INSIDE_BORDER_RIGHT = 327;
    private static final int MID_Y = 100;
    private static final int BORDER_UP = 350;
    private static final int INSIDE_BORDER_UP = 349;
    private static final int BORDER_DOWN = 0;
    private static final int INSIDE_BORDER_DOWN = 1;


    @Test
    @DisplayName("Shot.initShot: X1,Y1")
    void shotInit_robustBoundariesX1() {
        int x = 0;
        int y = 0;
        Shot shot = new Shot(x, y);

        try {
            Method m = Shot.class.getDeclaredMethod("initShot", int.class, int.class);
            m.setAccessible(true);
            m.invoke(shot, MID_X, MID_Y);
            boolean result = shot.getX() >= BORDER_LEFT && shot.getX() <= BORDER_RIGHT &&
                    shot.getY() <= BORDER_UP && shot.getY() >= BORDER_DOWN;

            assertTrue(result);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    @DisplayName("Shot.initShot: X2,Y1")
    void shotInit_robustBoundariesX2() {
        int x = 0;
        int y = 0;
        Shot shot = new Shot(x, y);

        try {
            Method m = Shot.class.getDeclaredMethod("initShot", int.class, int.class);
            m.setAccessible(true);
            m.invoke(shot, INSIDE_BORDER_LEFT, MID_Y);
            boolean result = shot.getX() > BORDER_LEFT;

            assertTrue(result);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    @DisplayName("Shot.initShot: X3,Y1")
    void shotInit_robustBoundariesX3() {
        int x = 0;
        int y = 0;
        Shot shot = new Shot(x, y);

        try {
            Method m = Shot.class.getDeclaredMethod("initShot", int.class, int.class);
            m.setAccessible(true);
            m.invoke(shot, BORDER_LEFT, MID_Y);

            assertEquals(BORDER_LEFT,shot.getX());
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    @DisplayName("Shot.initShot: X4,Y1")
    void shotInit_robustBoundariesX4() {
        int x = 0;
        int y = 0;
        Shot shot = new Shot(x, y);

        try {
            Method m = Shot.class.getDeclaredMethod("initShot", int.class, int.class);
            m.setAccessible(true);
            m.invoke(shot, INSIDE_BORDER_RIGHT, MID_Y);
            boolean result = shot.getX() < BORDER_RIGHT;

            assertTrue(result);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    @DisplayName("Shot.initShot: X5,Y1")
    void shotInit_robustBoundariesX5() {
        int x = 0;
        int y = 0;
        Shot shot = new Shot(x, y);

        try {
            Method m = Shot.class.getDeclaredMethod("initShot", int.class, int.class);
            m.setAccessible(true);
            m.invoke(shot, BORDER_RIGHT, MID_Y);

            assertEquals(BORDER_RIGHT,shot.getX());
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    @DisplayName("Shot.initShot: X1,Y2")
    void shotInit_robustBoundariesY2() {
        int x = 0;
        int y = 0;
        Shot shot = new Shot(x, y);

        try {
            Method m = Shot.class.getDeclaredMethod("initShot", int.class, int.class);
            m.setAccessible(true);
            m.invoke(shot, MID_X, BORDER_UP);

            assertEquals(BORDER_UP,shot.getY());
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    @DisplayName("Shot.initShot: // X1,Y3")
    void shotInit_robustBoundariesY3() {
        int x = 0;
        int y = 0;
        Shot shot = new Shot(x, y);

        try {
            Method m = Shot.class.getDeclaredMethod("initShot", int.class, int.class);
            m.setAccessible(true);
            m.invoke(shot, MID_X, INSIDE_BORDER_UP);
            boolean result = shot.getY() < BORDER_UP;

            assertTrue(result);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    @DisplayName("Shot.initShot: X1,Y4")
    void shotInit_robustBoundariesY4() {
        int x = 0;
        int y = 0;
        Shot shot = new Shot(x, y);

        try {
            Method m = Shot.class.getDeclaredMethod("initShot", int.class, int.class);
            m.setAccessible(true);
            m.invoke(shot, MID_X, INSIDE_BORDER_DOWN);
            boolean result = shot.getY() > BORDER_DOWN;

            assertTrue(result);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    @DisplayName("Shot.initShot: X1,Y5")
    void shotInit_robustBoundariesY5() {
        int x = 0;
        int y = 0;
        Shot shot = new Shot(x, y);

        try {
            Method m = Shot.class.getDeclaredMethod("initShot", int.class, int.class);
            m.setAccessible(true);
            m.invoke(shot, MID_X, BORDER_DOWN);

            assertEquals(BORDER_DOWN,shot.getY());
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
