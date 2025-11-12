package es.upm.iw41.entrega1.cajaBlanca;


import main.Board;
import main.Commons;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import space_invaders.sprites.Alien;
import space_invaders.sprites.Player;
import space_invaders.sprites.Sprite;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
            Field deaths = Board.class.getDeclaredField("deaths");
            deaths.setAccessible(true);
            deaths.set(board, Commons.NUMBER_OF_ALIENS_TO_DESTROY);
            Method method = Board.class.getDeclaredMethod("update");
            method.setAccessible(true);
            method.invoke(board);
            Field inGame = Board.class.getDeclaredField("inGame");
            inGame.setAccessible(true);

            assertFalse(inGame.getBoolean(board));
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
            Field deaths = Board.class.getDeclaredField("deaths");
            deaths.setAccessible(true);
            deaths.set(board, 0);
            Method method = Board.class.getDeclaredMethod("update");
            method.setAccessible(true);
            method.invoke(board);
            Field inGame = Board.class.getDeclaredField("inGame");
            inGame.setAccessible(true);

            assertTrue(inGame.getBoolean(board));
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

            assertTrue(board.getAliens().isEmpty());
        } catch (NoSuchMethodException | InvocationTargetException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Board.update_bomb - Path CP2")
    void testBoardUpdate_bomb_CP2() {
        Board board = new Board();
        List<Alien> list = new ArrayList<>();
        Alien alien = new Alien(150,300);
        list.add(alien);

        try {
            Field alien_visible = Sprite.class.getDeclaredField("visible");
            alien_visible.setAccessible(true);
            alien_visible.set(alien,false);
            Method method = Board.class.getDeclaredMethod("update_bomb");
            method.setAccessible(true);
            method.invoke(board);

            assertTrue(!alien.isVisible());
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Board.update_bomb - Path CP3")
    void testBoardUpdate_bomb_CP3() {
        Board board = new Board();
        List<Alien> list = new ArrayList<>();
        Alien alien = new Alien(150,300);
        Alien.Bomb bomb = alien.getBomb();
        int y = bomb.getY();
        list.add(alien);
        Player player = board.getPlayer();

        try {
            Field alien_visible = Sprite.class.getDeclaredField("visible");
            alien_visible.setAccessible(true);
            alien_visible.set(alien,true);
            Field bomb_destroyed = Alien.Bomb.class.getDeclaredField("destroyed");
            bomb_destroyed.setAccessible(true);
            bomb_destroyed.set(bomb,true);
            Field player_visible = Sprite.class.getDeclaredField("visible");
            player_visible.setAccessible(true);
            player_visible.set(player,false);
            Method method = Board.class.getDeclaredMethod("update_bomb");
            method.setAccessible(true);
            method.invoke(board);

            assertTrue(!bomb.isDestroyed() && !player.isVisible() && bomb.getY() < y);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Board.update_bomb - Path CP4")
    void testBoardUpdate_bomb_CP4() {
        Board board = new Board();
        List<Alien> list = new ArrayList<>();
        Alien alien = new Alien(150,300);
        Alien.Bomb bomb = alien.getBomb();
        list.add(alien);
        Player player = board.getPlayer();
        bomb.setX(150);
        bomb.setY(300);
        player.setX(150);
        player.setY(300);
        player.setDying(false);
        try {
            Field alien_visible = Sprite.class.getDeclaredField("visible");
            alien_visible.setAccessible(true);
            alien_visible.set(alien,false);
            Field bomb_destroyed = Alien.Bomb.class.getDeclaredField("destroyed");
            bomb_destroyed.setAccessible(true);
            bomb_destroyed.set(bomb,false);
            Field player_visible = Sprite.class.getDeclaredField("visible");
            player_visible.setAccessible(true);
            player_visible.set(player,true);
            Method method = Board.class.getDeclaredMethod("update_bomb");
            method.setAccessible(true);
            method.invoke(board);

            assertTrue(player.isDying());
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }


}
