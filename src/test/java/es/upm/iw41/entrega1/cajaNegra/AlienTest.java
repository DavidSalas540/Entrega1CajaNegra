package es.upm.iw41.entrega1.cajaNegra;

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
    @DisplayName("Alien.act: Posición entre borde izquierdo y derecho")
    void alienAct_posicionEntreBordes() {
        Alien alien = new Alien(CENTRO_X, CENTRO_Y);
        int result_x = BORDER_RIGHT - BORDER_LEFT;
        int dir = result_x - alien.getX();
        alien.act(dir);
        assertEquals(result_x, alien.getX());
    }

    @Test
    @DisplayName("Alien.act: Prueba de límite exacto en borde izquierdo")
    void alienAct_llegaAlBordeIzquierdo() {
        Alien alien = new Alien(CENTRO_X, CENTRO_Y);
        int dir = BORDER_LEFT - alien.getX();
        alien.act(dir);
        assertEquals(BORDER_LEFT, alien.getX());
    }

    @Test
    @DisplayName("Alien.act: Prueba de límite exacto en borde derecho")
    void alienAct_llegaAlBordeDerecho() {
        Alien alien = new Alien(CENTRO_X, CENTRO_Y);
        int dir = BORDER_RIGHT - alien.getX();
        alien.act(dir);
        assertEquals(BORDER_RIGHT, alien.getX());
    }

    @Test
    @DisplayName("Alien.act: excede borde izquierdo")
    void alienAct_excedeIzquierda() {
        Alien alien = new Alien(CENTRO_X, CENTRO_Y);
        int dir = (OUT_BORDER_LEFT - alien.getX());
        alien.act(dir);
        assertEquals(BORDER_LEFT, alien.getX());
    }

    @Test
    @DisplayName("Alien.act: excede borde derecho")
    void alienAct_excedeDerecha() {
        Alien alien = new Alien(CENTRO_X, CENTRO_Y);
        int dir = (OUT_BORDER_RIGHT - alien.getX());
        alien.act(dir);
        assertEquals(BORDER_RIGHT, alien.getX());
    }


    //METODO initAlien()

    // X1,Y1
    @Test
    @DisplayName("Alien.initAlien: X en un valor central se inicializa correctamente)")
    void alienInit_robustBoundariesX1() {
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

    //X2,Y1
    @Test
    @DisplayName("Alien.initAlien: X excede BORDER_LEFT")
    void alienInit_robustBoundariesX2() {
        Alien alien = new Alien(0, 0);
        try{
            Method metodo = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(alien, OUT_BORDER_LEFT, CENTRO_Y);
            boolean resultado = alien.getX() < BORDER_LEFT;
            assertTrue(resultado);
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    // X3,Y1
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

    //X4,Y1
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

    //X5,Y1
    @Test
    @DisplayName("Alien.initAlien: X dentro de BORDER_RIGHT es válido")
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

    //X6,Y1
    @Test
    @DisplayName("Alien.initAlien: X en el límite derecho se mantiene en BORDER_RIGHT")
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

    //X7,Y1
    @Test
    @DisplayName("Alien.initAlien: X por encima de BORDER_RIGHT)")
    void alienInit_robustBoundariesX7() {
        Alien alien = new Alien(0, 0);
        try{
            Method metodo = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(alien, OUT_BORDER_RIGHT,CENTRO_Y);
            boolean resultado = alien.getX() >= BORDER_RIGHT;
            assertTrue(resultado);
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    // X1,Y2
    @Test
    @DisplayName("Alien.initAlien: Y por encima del límite superior que se ajusta a BORDER_UP)")
    void alienInit_robustBoundariesY2() {
        Alien alien = new Alien(0, 0);
        try{
            Method metodo = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(alien, CENTRO_X,OUT_BORDER_UP);
            boolean resultado = alien.getY() > BORDER_UP;
            assertTrue(resultado);
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    // X1,Y3
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

    // X1,Y4
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

    // X1,Y5
    @Test
    @DisplayName("Alien.initAlien: Valor Y dentro del borde inferior (1) se ajusta a 0")
    void alienInit_robustBoundariesY5() {
        Alien alien = new Alien(0, 0);
        try{
            Method metodo = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(alien, CENTRO_X,INSIDE_BORDER_DOWN);
            boolean resultado = alien.getY() > BORDER_DOWN;
            assertTrue(resultado);
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    // X1,Y6
    @Test
    @DisplayName("Alien.initAlien: Y en el límite inferior se ajusta a BORDER_DOWN)")
    void alienInit_robustBoundariesY6() {
        Alien alien = new Alien(0, 0);
        try{
            Method metodo = Alien.class.getDeclaredMethod("initAlien", int.class, int.class);
            metodo.setAccessible(true);
            metodo.invoke(alien, CENTRO_X,BORDER_DOWN);
            assertEquals(BORDER_DOWN, alien.getY());
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    // X1,Y7
    @Test
    @DisplayName("Alien.initAlien: Valor Y fuera del borde inferior (-1) se ajusta a 0")
    void alienInit_robustBoundariesY7() {
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
}
