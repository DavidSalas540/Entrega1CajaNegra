package es.upm.iw41.entrega1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import space_invaders.sprites.Alien;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlienTest {

    private static final int CENTRO_X = 150;
    private static final int OUT_BORDER_LEFT = 4;
    private static final int BORDER_LEFT = 5;
    private static final int INSIDE_BORDER_LEFT = 6;
    private static final int OUT_BORDER_RIGHT = 329;
    private static final int BORDER_RIGHT = 328;
    private static final int INSIDE_BORDER_RIGHT = 327;
    private static final int CENTRO_Y = 100;
    private static final int OUT_BORDER_UP = 351;
    private static final int BORDER_UP = 350;
    private static final int INSIDE_BORDER_UP = 349;
    private static final int OUT_BORDER_DOWN = -1;
    private static final int BORDER_DOWN = 0;
    private static final int INSIDE_BORDER_DOWN = 1;

    // METODO act()

    @Test
    @DisplayName("Alien.act: clamp al borde izquierdo exacto")
    void alienAct_llegaAlBordeIzquierdo() {
        Alien alien = new Alien(CENTRO_X, CENTRO_Y);
        int dir = BORDER_LEFT - alien.getX();
        alien.act(dir);
        assertEquals(BORDER_LEFT, alien.getX());
    }

    @Test
    @DisplayName("Alien.act: clamp al borde derecho exacto")
    void alienAct_llegaAlBordeDerecho() {
        Alien alien = new Alien(CENTRO_X, CENTRO_Y);
        int dir = BORDER_RIGHT - alien.getX();
        alien.act(dir);
        assertEquals(BORDER_RIGHT, alien.getX());
    }

    @Test
    @DisplayName("Alien.act: excede por la izquierda → clamp a borde izquierdo")
    void alienAct_excedeIzquierda() {
        Alien alien = new Alien(CENTRO_X, CENTRO_Y);
        int dir = (OUT_BORDER_LEFT - alien.getX());
        alien.act(dir);
        assertEquals(BORDER_LEFT, alien.getX());
    }

    @Test
    @DisplayName("Alien.act: excede por la derecha → clamp a borde derecho")
    void alienAct_excedeDerecha() {
        Alien alien = new Alien(CENTRO_X, CENTRO_Y);
        int dir = (OUT_BORDER_RIGHT - alien.getX());
        alien.act(dir);
        assertEquals(BORDER_RIGHT, alien.getX());
    }



    //METODO initAlien()

    @Test
    @DisplayName("Alien.initAlien: X en un valor central se inicializa correctamente)")
    void alienInit_robustBoundariesX1() {   // = alienInit_robustBoundariesY1()
        Alien alien = new Alien(0, 0);
        try {
            Method metodo = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(alien, CENTRO_X, CENTRO_Y);
            boolean resultado = alien.getX() >= BORDER_LEFT && alien.getX() <= BORDER_RIGHT && alien.getY() >= BORDER_DOWN && alien.getY() <= BORDER_UP;
            assertTrue(resultado);
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Alien.initAlien: X por debajo del límite se ajusta a BORDER_LEFT")
    void alienInit_robustBoundariesX2() {
        int limite_izquierdo = 4;
        Alien alien = new Alien(0, 0);
        try{
            Method metodo = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(alien, OUT_BORDER_LEFT, CENTRO_Y);
            assertEquals(BORDER_LEFT, alien.getX());
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Alien.initAlien: X en el límite izquierdo se mantiene en BORDER_LEFT")
    void alienInit_robustBoundariesX3() {
        Alien alien = new Alien(0, 0);
        try{
            Method metodo = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(alien, BORDER_LEFT,CENTRO_Y);
            assertEquals(BORDER_LEFT, alien.getX());
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Alien.initAlien: X justo por encima de BORDER_LEFT es válido")
    void alienInit_robustBoundariesX4() {
        Alien alien = new Alien(0, 0);
        try{
            Method metodo = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(alien, INSIDE_BORDER_LEFT,CENTRO_Y);
            boolean resultado = alien.getX() >= BORDER_LEFT;
            assertTrue(resultado);
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Alien.initAlien: X justo por debajo de RIGHT_LIMIT es válido")
    void alienInit_robustBoundariesX5() {
        Alien alien = new Alien(0, 0);
        try{
            Method metodo = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(alien, INSIDE_BORDER_RIGHT,CENTRO_Y);
            boolean resultado = alien.getX() <= BORDER_RIGHT;
            assertTrue(resultado);
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Alien.initAlien: X en el límite derecho se mantiene en RIGHT_LIMIT")
    void alienInit_robustBoundariesX6() {
        Alien alien = new Alien(0, 0);
        try{
            Method metodo = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(alien, BORDER_RIGHT,CENTRO_Y);
            assertEquals(BORDER_RIGHT, alien.getX());
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Alien.initAlien: X por encima del límite se ajusta a RIGHT_LIMIT)")
    void alienInit_robustBoundariesX7() {
        Alien alien = new Alien(0, 0);
        try{
            Method metodo = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(alien, OUT_BORDER_RIGHT,CENTRO_Y);
            assertEquals(BORDER_RIGHT, alien.getX());
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Alien.initAlien: Y por encima del límite superior que se ajusta a BORDER_UP)")
    void alienInit_robustBoundariesY2() {
        Alien alien = new Alien(0, 0);
        try{
            Method metodo = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(alien, CENTRO_X,OUT_BORDER_UP);
            assertEquals(BORDER_UP, alien.getY());
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Alien.initAlien: Y en el límite superior se mantiene en BORDER_UP)")
    void alienInit_robustBoundariesY3() {
        Alien alien = new Alien(0, 0);
        try{
            Method metodo = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(alien, CENTRO_X,BORDER_UP);
            assertEquals(BORDER_UP, alien.getY());
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Alien.initAlien: Y inferior al límite se ajusta a BORDER_UP)")
    void alienInit_robustBoundariesY4() {
        Alien alien = new Alien(0, 0);
        try{
            Method metodo = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(alien, CENTRO_X,INSIDE_BORDER_UP);
            boolean resultado = alien.getY() <= BORDER_UP;
            assertTrue(resultado);
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Alien.initAlien: Y por encima del límite inferior se ajusta a BORDER_DOWN)")
    void alienInit_robustBoundariesY5() {
        Alien alien = new Alien(0, 0);
        try{
            Method metodo = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(alien, CENTRO_X,OUT_BORDER_DOWN);
            boolean resultado = alien.getY() >= BORDER_DOWN;
            assertTrue(resultado);
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Alien.initAlien: Y en el límite inferior se ajusta a BORDER_DOWN)")
    void alienInit_robustBoundariesY6() {
        Alien alien = new Alien(0, 0);
        try{
            Method metodo = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(alien, CENTRO_X,BORDER_DOWN);
            boolean resultado = alien.getY() >= BORDER_DOWN;
            assertTrue(resultado);
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Alien.initAlien: Y por debajo del límite inferior se ajusta a BORDER_DOWN)")
    void alienInit_robustBoundariesY7() {
        Alien alien = new Alien(0, 0);
        try{
            Method metodo = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(alien, CENTRO_X,INSIDE_BORDER_DOWN);
            boolean resultado = alien.getY() >= BORDER_DOWN;
            assertTrue(resultado);
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
