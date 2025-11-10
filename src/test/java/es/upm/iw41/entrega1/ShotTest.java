package es.upm.iw41.entrega1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import space_invaders.sprites.Shot;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShotTest {

    private static final int CENTRO_X = 150;
    private static final int BORDER_LEFT = 5;
    private static final int INSIDE_BORDER_LEFT = 6;
    private static final int BORDER_RIGHT = 328;
    private static final int INSIDE_BORDER_RIGHT = 327;
    private static final int CENTRO_Y = 100;
    private static final int BORDER_UP = 350;
    private static final int INSIDE_BORDER_UP = 349;
    private static final int BORDER_DOWN = 0;
    private static final int INSIDE_BORDER_DOWN = 1;

    // METODO initShot()

    // X1,Y1
    @Test
    @DisplayName("Shot.initShot: X en un valor central se inicializa correctamente")
    void shotInit_robustBoundariesX1() {   // = shotInit_robustBoundariesY1()
        Shot shot = new Shot(0, 0);
        try {
            Method metodo = Shot.class.getDeclaredMethod("initShot", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(shot, CENTRO_X, CENTRO_Y);
            boolean resultado = shot.getX() >= BORDER_LEFT && shot.getX() <= BORDER_RIGHT &&
                    shot.getY() <= BORDER_UP && shot.getY() >= BORDER_DOWN;
            assertTrue(resultado);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    // X2,Y1
    @Test
    @DisplayName("Shot.initShot: X por debajo del límite se ajusta a BORDER_LEFT")
    void shotInit_robustBoundariesX2() {
        Shot shot = new Shot(0, 0);
        try {
            Method metodo = Shot.class.getDeclaredMethod("initShot", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(shot, INSIDE_BORDER_LEFT, CENTRO_Y);
            boolean resultado = shot.getX() > BORDER_LEFT;
            assertTrue(resultado);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    // X3,Y1
    @Test
    @DisplayName("Shot.initShot: X en el límite izquierdo se mantiene en BORDER_LEFT")
    void shotInit_robustBoundariesX3() {
        Shot shot = new Shot(0, 0);
        try {
            Method metodo = Shot.class.getDeclaredMethod("initShot", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(shot, BORDER_LEFT, CENTRO_Y);
            assertEquals(BORDER_LEFT,shot.getX());
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    // X4,Y1
    @Test
    @DisplayName("Shot.initShot: X por debajo del límite se ajusta a BORDER_RIGHT")
    void shotInit_robustBoundariesX4() {
        Shot shot = new Shot(0, 0);
        try {
            Method metodo = Shot.class.getDeclaredMethod("initShot", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(shot, INSIDE_BORDER_RIGHT, CENTRO_Y);
            boolean resultado = shot.getX() < BORDER_RIGHT;
            assertTrue(resultado);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    // X5,Y1
    @Test
    @DisplayName("Shot.initShot: X en el límite izquierdo se mantiene en BORDER_RIGHT")
    void shotInit_robustBoundariesX5() {
        Shot shot = new Shot(0, 0);
        try {
            Method metodo = Shot.class.getDeclaredMethod("initShot", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(shot, BORDER_RIGHT, CENTRO_Y);
            assertEquals(BORDER_RIGHT,shot.getX());
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    // X1,Y2
    @Test
    @DisplayName("Shot.initShot: Y en el límite superior se mantiene en BORDER_UP")
    void shotInit_robustBoundariesY2() {
        Shot shot = new Shot(0, 0);
        try {
            Method metodo = Shot.class.getDeclaredMethod("initShot", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(shot, CENTRO_X, BORDER_UP);
            assertEquals(BORDER_UP,shot.getY());
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    // X1,Y3
    @Test
    @DisplayName("Shot.initShot: Y por debajo del límite superior se mantiene en BORDER_UP")
    void shotInit_robustBoundariesY3() {
        Shot shot = new Shot(0, 0);
        try {
            Method metodo = Shot.class.getDeclaredMethod("initShot", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(shot, CENTRO_X, INSIDE_BORDER_UP);
            boolean resultado = shot.getY() < BORDER_UP;
            assertTrue(resultado);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    // X1,Y4
    @Test
    @DisplayName("Shot.initShot: Y por debajo del límite se ajusta a BORDER_DOWN")
    void shotInit_robustBoundariesY4() {
        Shot shot = new Shot(0, 0);
        try {
            Method metodo = Shot.class.getDeclaredMethod("initShot", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(shot, CENTRO_X, INSIDE_BORDER_DOWN);
            assertEquals(INSIDE_BORDER_DOWN,shot.getY());
            boolean resultado = shot.getY() > BORDER_DOWN;
            assertTrue(resultado);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    // X1,Y5
    @Test
    @DisplayName("Shot.initShot: Y en el límite inferior se mantiene en BORDER_DOWN")
    void shotInit_robustBoundariesY5() {
        Shot shot = new Shot(0, 0);
        try {
            Method metodo = Shot.class.getDeclaredMethod("initShot", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(shot, CENTRO_X, BORDER_DOWN);
            assertEquals(BORDER_DOWN,shot.getY());
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
