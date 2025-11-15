package es.upm.iw41.entrega1.cajaNegra;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import space_invaders.sprites.Alien;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CajaNegra_BombTest {

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
    @DisplayName("Bomb.initBomb: X1,Y1")
    void bombInit_BoundariesX1() {
        Alien alien = new Alien(0, 0);
        Alien.Bomb bomb = alien.getBomb();

        try{
            Method m = Alien.Bomb.class.getDeclaredMethod("initBomb", int.class, int.class);
            m.setAccessible(true);
            m.invoke(bomb, MID_X, MID_Y);
            boolean result = (bomb.getX() >= BORDER_LEFT && bomb.getX() <= BORDER_RIGHT)
                    && ( bomb.getY() >= BORDER_DOWN && bomb.getY() <= BORDER_UP);

            assertTrue(result);
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    @DisplayName("Bomb.initBomb: X2,Y1")
    void bombInit_BoundariesX2() {
        Alien alien = new Alien(0, 0);
        Alien.Bomb bomb = alien.getBomb();

        try{
            Method m = Alien.Bomb.class.getDeclaredMethod("initBomb", int.class, int.class);
            m.setAccessible(true);
            m.invoke(bomb, INSIDE_BORDER_LEFT, MID_Y);
            boolean result = bomb.getX() >= BORDER_LEFT && bomb.getX() <= BORDER_RIGHT;

            assertTrue(result);
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    @DisplayName("Bomb.initBomb: X3,Y1")
    void bombInit_BoundariesX3() {
        Alien alien = new Alien(0, 0);
        Alien.Bomb bomb = alien.getBomb();

        try{
            Method m = Alien.Bomb.class.getDeclaredMethod("initBomb", int.class, int.class);
            m.setAccessible(true);
            m.invoke(bomb, BORDER_LEFT, MID_Y);

            assertEquals(BORDER_LEFT, bomb.getX());
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    @DisplayName("Bomb.initBomb: X4,Y1")
    void bombInit_BoundariesX4() {
        Alien alien = new Alien(0, 0);
        Alien.Bomb bomb = alien.getBomb();

        try {
            Method m = Alien.Bomb.class.getDeclaredMethod("initBomb", int.class, int.class);
            m.setAccessible(true);
            m.invoke(bomb, INSIDE_BORDER_RIGHT, MID_Y);
            boolean result = bomb.getX() >= BORDER_LEFT && bomb.getX() <= BORDER_RIGHT;

            assertTrue(result);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    @DisplayName("Bomb.initBomb: X5,Y1")
    void bombInit_BoundariesX5() {
        Alien alien = new Alien(0, 0);
        Alien.Bomb bomb = alien.getBomb();

        try{
            Method m = Alien.Bomb.class.getDeclaredMethod("initBomb", int.class, int.class);
            m.setAccessible(true);
            m.invoke(bomb, BORDER_RIGHT, MID_Y);

            assertEquals(BORDER_RIGHT, bomb.getX());
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    @DisplayName("Bomb.initBomb: X1,Y2")
    void bombInit_BoundariesY2() {
        Alien alien = new Alien(0, 0);
        Alien.Bomb bomb = alien.getBomb();

        try{
            Method m = Alien.Bomb.class.getDeclaredMethod("initBomb", int.class, int.class);
            m.setAccessible(true);
            m.invoke(bomb, MID_X,BORDER_UP);

            assertEquals(bomb.getY(), BORDER_UP);
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    @DisplayName("Bomb.initBomb: X1,Y3")
    void bombInit_BoundariesY3() {
        Alien alien = new Alien(0, 0);
        Alien.Bomb bomb = alien.getBomb();

        try{
            Method m = Alien.Bomb.class.getDeclaredMethod("initBomb", int.class, int.class);
            m.setAccessible(true);
            m.invoke(bomb, MID_X,INSIDE_BORDER_UP);

            assertEquals(bomb.getY(), INSIDE_BORDER_UP);
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    @DisplayName("Bomb.initBomb: X1,Y4")
    void bombInit_BoundariesY4() {
        Alien alien = new Alien(0, 0);
        Alien.Bomb bomb = alien.getBomb();

        try{
            Method m = Alien.Bomb.class.getDeclaredMethod("initBomb", int.class, int.class);
            m.setAccessible(true);
            m.invoke(bomb, MID_X,BORDER_DOWN);

            assertEquals(bomb.getY(), BORDER_DOWN);
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    @DisplayName("Bomb.initBomb: X1,Y5")
    void bombInit_BoundariesY5() {
        Alien alien = new Alien(0, 0);
        Alien.Bomb bomb = alien.getBomb();

        try{
            Method m = Alien.Bomb.class.getDeclaredMethod("initBomb", int.class, int.class);
            m.setAccessible(true);
            m.invoke(bomb, MID_X,INSIDE_BORDER_DOWN);

            assertEquals(bomb.getY(), INSIDE_BORDER_DOWN);
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
