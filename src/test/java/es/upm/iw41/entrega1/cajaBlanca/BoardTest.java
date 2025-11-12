package es.upm.iw41.entrega1.cajaBlanca;


import main.Board;
import main.Commons;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import space_invaders.sprites.Alien;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardTest {

    @Test
    @DisplayName("Board.gameInit - Path CP1")
    void testBoardGameInit_Path_CP1() {
        Board board = new Board();
        // Crea el objeto board y ejecuta la funcion gameInit
        assertNotNull(board.getAliens());
        assertNotNull(board.getPlayer());
        assertNotNull(board.getShot());
    }

    @Test
    @DisplayName("Board.update - Path CP1")
    void testBoardUpdate_Path_CP1() {
        Board board = new Board();

        try {
            Field variable = Board.class.getDeclaredField("deaths");
            variable.setAccessible(true);
            variable.set(board, Commons.NUMBER_OF_ALIENS_TO_DESTROY);
            Method method = Board.class.getDeclaredMethod("update");
            method.setAccessible(true);
            method.invoke(board);

            assertNotNull(board);
        }catch (NoSuchMethodException | InvocationTargetException |
                IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Board.update - Path CP2")
    void testBoardUpdate_Path_CP2() {
        Board board = new Board();

        try {
            Field variable = Board.class.getDeclaredField("deaths");
            variable.setAccessible(true);
            variable.set(board, 0);
            Method method = Board.class.getDeclaredMethod("update");
            method.setAccessible(true);
            method.invoke(board);

            assertNotNull(board);
        }catch (NoSuchMethodException | InvocationTargetException |
                IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Board.update_aliens - Path CP1")
    void testBoardUpdate_aliens_CP1() {

    }

    @Test
    @DisplayName("Board.update_bomb - Path CP1")
    void testBoardUpdate_bomb_CP1() {
        Board board = new Board();
        List<Alien> empty_list = new ArrayList<>();
        board.setAliens(empty_list);
        try {
            Method method = Board.class.getDeclaredMethod("update_bomb");
            method.setAccessible(true);
            method.invoke(board);
        } catch (NoSuchMethodException | InvocationTargetException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Board.update_bomb - Path CP2")
    void testBoardUpdate_bomb_CP2() {
        Board board = new Board();

        try {
            Method method = Board.class.getDeclaredMethod("update_bomb");
            method.setAccessible(true);
            method.invoke(board);
        } catch (NoSuchMethodException | InvocationTargetException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


}
