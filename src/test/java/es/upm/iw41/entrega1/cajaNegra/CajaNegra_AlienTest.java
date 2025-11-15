package es.upm.iw41.entrega1.cajaNegra;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import space_invaders.sprites.Alien;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CajaNegra_AlienTest {

    private static final int MID_X = 150;
    private static final int OUT_BORDER_LEFT = 4;
    private static final int BORDER_LEFT = 5;
    private static final int INSIDE_BORDER_LEFT = 6;
    private static final int OUT_BORDER_RIGHT = 329;
    private static final int BORDER_RIGHT = 328;
    private static final int INSIDE_BORDER_RIGHT = 327;
    private static final int MID_Y = 100;
    private static final int OUT_BORDER_UP = 351;
    private static final int BORDER_UP = 350;
    private static final int INSIDE_BORDER_UP = 349;
    private static final int OUT_BORDER_DOWN = -1;
    private static final int BORDER_DOWN = 0;
    private static final int INSIDE_BORDER_DOWN = 1;


    @Test
    @DisplayName("Alien.act: positionInsideLimits")
    void alienAct_positionInsideLimits() {
        Alien alien = new Alien(MID_X, MID_Y);
        int result_x = BORDER_RIGHT - BORDER_LEFT;
        int dir = result_x - alien.getX();
        alien.act(dir);

        assertEquals(result_x, alien.getX());
    }

    @Test
    @DisplayName("Alien.act: inBorderLeft")
    void alienAct_inBorderLeft() {
        Alien alien = new Alien(MID_X, MID_Y);
        int dir = BORDER_LEFT - alien.getX();
        alien.act(dir);

        assertEquals(BORDER_LEFT, alien.getX());
    }

    @Test
    @DisplayName("Alien.act: inBorderRight")
    void alienAct_inBorderRight() {
        Alien alien = new Alien(MID_X, MID_Y);
        int dir = BORDER_RIGHT - alien.getX();
        alien.act(dir);

        assertEquals(BORDER_RIGHT, alien.getX());
    }

    @Test
    @DisplayName("Alien.act: exceedsBorderLeft")
    void alienAct_exceedsBorderLeft() {
        Alien alien = new Alien(MID_X, MID_Y);
        int dir = (OUT_BORDER_LEFT - alien.getX());
        alien.act(dir);

        assertEquals(BORDER_LEFT, alien.getX());
    }

    @Test
    @DisplayName("Alien.act: exceedsBorderRight")
    void alienAct_exceedsBorderRight() {
        Alien alien = new Alien(MID_X, MID_Y);
        int dir = (OUT_BORDER_RIGHT - alien.getX());
        alien.act(dir);

        assertEquals(BORDER_RIGHT, alien.getX());
    }


    @Test
    @DisplayName("Alien.initAlien: X1,Y1")
    void alienInit_robustBoundariesX1() {
        Alien alien = new Alien(0, 0);

        try {
            Method m = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            m.setAccessible(true);
            m.invoke(alien, MID_X, MID_Y);
            boolean result = alien.getX() >= BORDER_LEFT && alien.getX() <= BORDER_RIGHT && alien.getY() >= BORDER_DOWN && alien.getY() <= BORDER_UP;

            assertTrue(result);
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    @DisplayName("Alien.initAlien: X2,Y1")
    void alienInit_robustBoundariesX2() {
        Alien alien = new Alien(0, 0);

        try{
            Method m = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            m.setAccessible(true);
            m.invoke(alien, OUT_BORDER_LEFT, MID_Y);
            boolean result = alien.getX() < BORDER_LEFT;

            assertTrue(result);
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    @DisplayName("Alien.initAlien: X3,Y1")
    void alienInit_robustBoundariesX3() {
        Alien alien = new Alien(0, 0);

        try{
            Method m = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            m.setAccessible(true);
            m.invoke(alien, BORDER_LEFT, MID_Y);

            assertEquals(BORDER_LEFT, alien.getX());
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    @DisplayName("Alien.initAlien: X4,Y1")
    void alienInit_robustBoundariesX4() {
        Alien alien = new Alien(0, 0);

        try{
            Method m = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            m.setAccessible(true);
            m.invoke(alien, INSIDE_BORDER_LEFT, MID_Y);
            boolean result = alien.getX() >= BORDER_LEFT;

            assertTrue(result);
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    @DisplayName("Alien.initAlien: X5,Y1")
    void alienInit_robustBoundariesX5() {
        Alien alien = new Alien(0, 0);

        try{
            Method m = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            m.setAccessible(true);
            m.invoke(alien, INSIDE_BORDER_RIGHT, MID_Y);
            boolean result = alien.getX() <= BORDER_RIGHT;

            assertTrue(result);
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    @DisplayName("Alien.initAlien: X6,Y1")
    void alienInit_robustBoundariesX6() {
        Alien alien = new Alien(0, 0);

        try{
            Method m = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            m.setAccessible(true);
            m.invoke(alien, BORDER_RIGHT, MID_Y);

            assertEquals(BORDER_RIGHT, alien.getX());
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    @DisplayName("Alien.initAlien: X7,Y1")
    void alienInit_robustBoundariesX7() {
        Alien alien = new Alien(0, 0);

        try{
            Method m = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            m.setAccessible(true);
            m.invoke(alien, OUT_BORDER_RIGHT, MID_Y);
            boolean result = alien.getX() >= BORDER_RIGHT;

            assertTrue(result);
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    @DisplayName("Alien.initAlien: X1,Y2")
    void alienInit_robustBoundariesY2() {
        Alien alien = new Alien(0, 0);

        try{
            Method m = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            m.setAccessible(true);
            m.invoke(alien, MID_X,OUT_BORDER_UP);
            boolean result = alien.getY() > BORDER_UP;

            assertTrue(result);
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    @DisplayName("Alien.initAlien: X1,Y3")
    void alienInit_robustBoundariesY3() {
        Alien alien = new Alien(0, 0);

        try{
            Method m = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            m.setAccessible(true);
            m.invoke(alien, MID_X,BORDER_UP);

            assertEquals(BORDER_UP, alien.getY());
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Alien.initAlien: X1,Y4")
    void alienInit_robustBoundariesY4() {
        Alien alien = new Alien(0, 0);

        try{
            Method m = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            m.setAccessible(true);
            m.invoke(alien, MID_X,INSIDE_BORDER_UP);
            boolean result = alien.getY() <= BORDER_UP;

            assertTrue(result);
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    @DisplayName("Alien.initAlien: X1,Y5")
    void alienInit_robustBoundariesY5() {
        Alien alien = new Alien(0, 0);

        try{
            Method m = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            m.setAccessible(true);
            m.invoke(alien, MID_X,INSIDE_BORDER_DOWN);
            boolean result = alien.getY() > BORDER_DOWN;

            assertTrue(result);
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    @DisplayName("Alien.initAlien: X1,Y6")
    void alienInit_robustBoundariesY6() {
        Alien alien = new Alien(0, 0);

        try{
            Method m = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            m.setAccessible(true);
            m.invoke(alien, MID_X,BORDER_DOWN);

            assertEquals(BORDER_DOWN, alien.getY());
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    @DisplayName("Alien.initAlien: X1,Y7")
    void alienInit_robustBoundariesY7() {
        Alien alien = new Alien(0, 0);

        try{
            Method m = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            m.setAccessible(true);
            m.invoke(alien, MID_X,OUT_BORDER_DOWN);
            boolean result = alien.getY() >= BORDER_DOWN;

            assertTrue(result);
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
