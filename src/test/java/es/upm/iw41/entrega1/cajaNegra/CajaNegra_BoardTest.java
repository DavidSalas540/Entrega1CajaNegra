package es.upm.iw41.entrega1.cajaNegra;

import main.Board;
import main.Commons;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import space_invaders.sprites.Alien;
import space_invaders.sprites.Shot;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CajaNegra_BoardTest {

    final int SHOT_INIT_X = 179;
    final int SHOT_INIT_Y = 280;
    final int H_SPACE = 6;
    final int V_SPACE = 1;
    final int RIGHT_DIRECTION = 1;

    @Test
    @DisplayName("Test update_aliens 1 direccion borde derecho")
    void testUpdate_aliens1(){
        Board board = new Board();

        board.setDirection(RIGHT_DIRECTION);
        Alien testAlien = new Alien(Commons.BOARD_WIDTH - Commons.BORDER_RIGHT,Commons.ALIEN_INIT_Y);
        board.getAliens().add(testAlien);

        try {
            Method m = Board.class.getDeclaredMethod("update_aliens");
            m.setAccessible(true);
            m.invoke(board);

            boolean result = board.getDirection() == -1 && testAlien.getY() != Commons.ALIEN_INIT_Y;
            assertTrue(result);

        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Test update_aliens 2 invasion")
    void testUpdate_aliens2(){
        Board board = new Board();

        Alien testAlien = new Alien(Commons.ALIEN_INIT_X, Commons.GROUND + Commons.ALIEN_HEIGHT + 1);
        board.getAliens().add(testAlien);

        try {
            Method m = Board.class.getDeclaredMethod("update_aliens");
            m.setAccessible(true);
            m.invoke(board);

            assertFalse(board.isInGame());

        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Test update_bombs 1 direccion bombas")
    void testUpdate_bombs1(){
        Board board = new Board();

        Alien testAlien = new Alien(Commons.ALIEN_INIT_X,Commons.ALIEN_INIT_Y);
        Alien.Bomb testBomb = testAlien.getBomb();
        int prev_y = testBomb.getY();
        board.getAliens().add(testAlien);

        try {
            Method m = Board.class.getDeclaredMethod("update_bomb");
            m.setAccessible(true);
            m.invoke(board);

            assertTrue(prev_y < testBomb.getY());

        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    @DisplayName("Test update_shots 1 movimiento vertical")
    void testUpdate_shots1() {
        Board board = new Board();

        Shot shot = new Shot(SHOT_INIT_X, SHOT_INIT_Y);
        board.setShot(shot);

        try {
            java.lang.reflect.Method m = Board.class.getDeclaredMethod("update_shots");
            m.setAccessible(true);
            m.invoke(board);

            boolean result = board.getShot().getX() == SHOT_INIT_X + H_SPACE && board.getShot().getY() < SHOT_INIT_Y - V_SPACE;
            assertTrue(result);

        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
