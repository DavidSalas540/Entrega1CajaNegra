package es.upm.iw41.entrega1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import space_invaders.sprites.Alien;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BombTest {

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

    // METODO initBomb()

    @Test
    @DisplayName("Bomb.initBomb: X en un valor central se inicializa correctamente)")
    void bombInit_BoundariesX1() {
        Alien alien = new Alien(0, 0);
        Alien.Bomb bomb = alien.getBomb();
        try{
            Method metodo = Alien.Bomb.class.getDeclaredMethod("initBomb", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(bomb, CENTRO_X, CENTRO_Y);
            boolean resultado = (bomb.getX() >= BORDER_LEFT && bomb.getX() <= BORDER_RIGHT)
                    && ( bomb.getY() >= BORDER_DOWN && bomb.getY() <= BORDER_UP);
            assertTrue(resultado);
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Bomb.initBomb: X por debajo del límite se ajusta a BORDER_LEFT")
    void bombInit_BoundariesX2() {
        Alien alien = new Alien(0, 0);
        Alien.Bomb bomb = alien.getBomb();
        try{
            Method metodo = Alien.Bomb.class.getDeclaredMethod("initBomb", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(bomb, INSIDE_BORDER_LEFT, CENTRO_Y);
            boolean resultado = bomb.getX() >= BORDER_LEFT && bomb.getX() <= BORDER_RIGHT;
            assertTrue(resultado);
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    @DisplayName("Bomb.initBomb: X en el límite izquierdo se mantiene en BORDER_LEFT")
    void bombInit_BoundariesX3() {
        Alien alien = new Alien(0, 0);
        Alien.Bomb bomb = alien.getBomb();
        try{
            Method metodo = Alien.Bomb.class.getDeclaredMethod("initBomb", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(bomb, BORDER_LEFT,CENTRO_Y);
            assertEquals(BORDER_LEFT, bomb.getX());
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Bomb.initBomb: X por debajo del limite se ajusta en BORDER_RIGTH)")
    void bombInit_BoundariesX4() {
        Alien alien = new Alien(0, 0);
        Alien.Bomb bomb = alien.getBomb();
        try {
            Method metodo = Alien.Bomb.class.getDeclaredMethod("initBomb", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(bomb, INSIDE_BORDER_RIGHT, CENTRO_Y);
            boolean resultado = bomb.getX() >= BORDER_LEFT && bomb.getX() <= BORDER_RIGHT;
            assertTrue(resultado);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    @DisplayName("Bomb.initBomb: X en el límite derecho se mantiene en BORDER_RIGHT")
    void bombInit_BoundariesX5() {
        Alien alien = new Alien(0, 0);
        Alien.Bomb bomb = alien.getBomb();
        try{
            Method metodo = Alien.Bomb.class.getDeclaredMethod("initBomb", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(bomb, BORDER_RIGHT,CENTRO_Y);
            assertEquals(BORDER_RIGHT, bomb.getX());
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Bomb.initBomb: Y en el  se mantiene en BORDER_UP")
    void bombInit_BoundariesY2() {
        Alien alien = new Alien(0, 0);
        Alien.Bomb bomb = alien.getBomb();
        try{
            Method metodo = Alien.Bomb.class.getDeclaredMethod("initBomb", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(bomb, CENTRO_X,BORDER_UP);
            assertEquals(bomb.getX(), BORDER_UP);
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Bomb.initBomb: Y en el límite superior se mantiene inmediatamente debajo de BORDER_UP")
    void bombInit_BoundariesY3() {
        Alien alien = new Alien(0, 0);
        Alien.Bomb bomb = alien.getBomb();
        try{
            Method metodo = Alien.Bomb.class.getDeclaredMethod("initBomb", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(bomb, CENTRO_X,INSIDE_BORDER_UP);
            assertEquals(bomb.getX(), INSIDE_BORDER_UP);
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Bomb.initBomb: Y en el límite inferior se mantiene en BORDER_DOWN")
    void bombInit_BoundariesY4() {
        Alien alien = new Alien(0, 0);
        Alien.Bomb bomb = alien.getBomb();
        try{
            Method metodo = Alien.Bomb.class.getDeclaredMethod("initBomb", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(bomb, CENTRO_X,BORDER_DOWN);
            assertEquals(bomb.getX(), BORDER_DOWN);
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Bomb.initBomb: Y en el límite superior se mantiene inmediatamente encima de BORDER_DOWN")
    void bombInit_BoundariesY5() {
        Alien alien = new Alien(0, 0);
        Alien.Bomb bomb = alien.getBomb();
        try{
            Method metodo = Alien.Bomb.class.getDeclaredMethod("initBomb", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(bomb, CENTRO_X,INSIDE_BORDER_DOWN);
            assertEquals(bomb.getX(), INSIDE_BORDER_DOWN);
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
