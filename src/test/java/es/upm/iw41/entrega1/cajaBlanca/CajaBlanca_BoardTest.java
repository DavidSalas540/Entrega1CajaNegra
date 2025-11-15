package es.upm.iw41.entrega1.cajaBlanca;


import main.Board;
import main.Commons;
import org.junit.jupiter.api.BeforeEach;
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

public class CajaBlanca_BoardTest {

    private final int ALIEN_ROWS = 4;
    private final int ALIEN_COLUMNS = 6;
    private final int BORDER_LEFT = 5;
    private final int MID_X = 150;
    private final int MID_Y = 300;


    @BeforeEach
    void setUp() {
        Commons.ALIEN_ROWS = ALIEN_ROWS;
        Commons.ALIEN_COLUMNS = ALIEN_COLUMNS;
        Commons.BORDER_LEFT = BORDER_LEFT;
    }


    @Test
    @DisplayName("Board.gameInit - Path CP1")
    void testBoardGameInit_Path_CP1() {
        Board board = new Board();
        boolean correct = !board.getAliens().isEmpty() && board.getPlayer() != null && board.getShot() != null;

        assertTrue(correct);
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
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Board.update - Path CP2")
    void testBoardUpdate_Path_CP2() {
        Board board = new Board();
        int zero_deaths = 0;

        try {
            Field deaths = Board.class.getDeclaredField("deaths");
            deaths.setAccessible(true);
            deaths.set(board, zero_deaths);
            Method method = Board.class.getDeclaredMethod("update");
            method.setAccessible(true);
            method.invoke(board);
            Field inGame = Board.class.getDeclaredField("inGame");
            inGame.setAccessible(true);

            assertTrue(inGame.getBoolean(board));
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    @DisplayName("Board.update_aliens - Path CP1")
    void testBoardUpdate_aliens_CP1() {
        Board board = new Board();
        List<Alien> empty_list = new ArrayList<>();
        board.setAliens(empty_list);
        try {
            Method method = Board.class.getDeclaredMethod("update_aliens");
            method.setAccessible(true);
            method.invoke(board);
            boolean correct = board.getAliens().isEmpty();

            assertTrue(correct);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }


    @Test
    @DisplayName("Board.update_aliens - Path CP4")
    void testBoardUpdate_aliens_CP4() {
        Board board = new Board();
        board.getAliens().clear();
        int dir = -1;
        board.setDirection(dir);
        int initialX = Commons.BOARD_WIDTH - Commons.BORDER_RIGHT;
        int initialY = Commons.ALIEN_INIT_Y;

        Alien testAlien = new Alien(initialX, initialY);
        testAlien.die();
        board.getAliens().add(testAlien);

        try {
            Method method = Board.class.getDeclaredMethod("update_aliens");
            method.setAccessible(true);
            method.invoke(board);

        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        Alien finalAlienState = board.getAliens().getFirst();
        int expectedY = initialY + Commons.GO_DOWN;

        boolean correct = board.getDirection() == -1 && expectedY == finalAlienState.getY()
                && initialX == finalAlienState.getX();
        assertTrue(correct);
    }


    @Test
    @DisplayName("Board.update_aliens - Path CP7")
    void testBoardUpdate_aliens_CP7() {
        Board board = new Board();
        int dir = 0;
        board.setDirection(dir);
        board.getAliens().clear();
        int initialX = BORDER_LEFT ;
        int initialY = MID_Y;
        Alien testAlien = new Alien(initialX, initialY);
        testAlien.die();
        board.getAliens().add(testAlien);
        int initialDirection = 1;
        board.setDirection(initialDirection);

        try {
            Method method = Board.class.getDeclaredMethod("update_aliens");
            method.setAccessible(true);
            method.invoke(board);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Alien finalAlienState = board.getAliens().getFirst();

        boolean correcto = initialDirection == board.getDirection()
                && initialY == finalAlienState.getY()
                && initialX == finalAlienState.getX();
        assertTrue(correcto);
    }


    @Test
    @DisplayName("Board.update_aliens - Path CP8")
    void testBoardUpdate_aliens_CP8() {

        Board board = new Board();

        board.getAliens().clear();

        int initialX = MID_X;
        int dir = 1;
        board.setDirection(dir);

        int initialY = Commons.GROUND + Commons.ALIEN_HEIGHT + 1;

        Alien testAlien = new Alien(initialX, initialY);

        board.getAliens().add(testAlien);
        try {
            Method method = Board.class.getDeclaredMethod("update_aliens");
            method.setAccessible(true);
            method.invoke(board);

        } catch (NoSuchMethodException | InvocationTargetException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        Alien finalAlienState = board.getAliens().getFirst();

        boolean correcto = initialX != finalAlienState.getX() && initialY == finalAlienState.getY();

        assertTrue(correcto);
    }


    @Test
    @DisplayName("Board.update_aliens - Path CP9")
    void testBoardUpdate_aliens_CP9() {
        Board board = new Board();
        board.getAliens().add(new Alien(Commons.ALIEN_INIT_X  , Commons.ALIEN_INIT_Y));
        Player player = new Player();
        board.setPlayer(player);
        int x = board.getAliens().getFirst().getX();
        int y = board.getAliens().getFirst().getY();

        try {
            Method method = Board.class.getDeclaredMethod("update_aliens");
            method.setAccessible(true);
            method.invoke(board);

            boolean correcto = x > Commons.BORDER_LEFT && x < Commons.BOARD_WIDTH - Commons.BORDER_RIGHT
                    && board.getAliens().getFirst().isVisible() && y < Commons.GROUND + Commons.ALIEN_HEIGHT;

            assertTrue(correcto);
        } catch (NoSuchMethodException | InvocationTargetException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
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
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    @DisplayName("Board.update_bomb - Path CP2")
    void testBoardUpdate_bomb_CP2() {
        Board board = new Board();
        List<Alien> list = new ArrayList<>();
        Alien alien = new Alien(MID_X, MID_Y);
        list.add(alien);
        board.setAliens(list);

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
        int alien_y = 0;
        Board board = new Board();
        List<Alien> list = new ArrayList<>();
        Alien alien = new Alien(MID_X,alien_y);
        Alien.Bomb bomb = alien.getBomb();
        int y = bomb.getY();
        list.add(alien);
        board.setAliens(list);
        Player player = board.getPlayer();

        try {
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
        int player_x = 0;
        int player_y = 0;
        Board board = new Board();
        List<Alien> list = new ArrayList<>();
        Alien alien = new Alien(MID_X, MID_Y);
        Alien.Bomb bomb = alien.getBomb();
        list.add(alien);
        board.setAliens(list);
        Player player = board.getPlayer();
        player.setX(player_x);
        player.setY(player_y);
        player.setDying(false);

        try {
            Field alien_visible = Sprite.class.getDeclaredField("visible");
            alien_visible.setAccessible(true);
            alien_visible.set(alien,false);
            Field bomb_destroyed = Alien.Bomb.class.getDeclaredField("destroyed");
            bomb_destroyed.setAccessible(true);
            bomb_destroyed.set(bomb,false);
            Method method = Board.class.getDeclaredMethod("update_bomb");
            method.setAccessible(true);
            method.invoke(board);

            assertTrue(!player.isDying());
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Board.update_bomb - Path CP5")
    void testBoardUpdate_bomb_CP5(){
        Board board = new Board();
        List<Alien> list = new ArrayList<>();
        Alien alien = new Alien(MID_X, MID_Y);
        Alien.Bomb bomb = alien.getBomb();
        list.add(alien);
        board.setAliens(list);
        Player player = board.getPlayer();
        player.setX(MID_X);
        player.setY(MID_Y);
        player.setDying(false);

        try {
            Field alien_visible = Sprite.class.getDeclaredField("visible");
            alien_visible.setAccessible(true);
            alien_visible.set(alien,false);
            Field bomb_destroyed = Alien.Bomb.class.getDeclaredField("destroyed");
            bomb_destroyed.setAccessible(true);
            bomb_destroyed.set(bomb,false);
            Method method = Board.class.getDeclaredMethod("update_bomb");
            method.setAccessible(true);
            method.invoke(board);

            assertTrue(player.isDying());
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Board.update_bomb - Path CP6")
    void testBoardUpdate_bomb_CP6(){
        Board board = new Board();
        List<Alien> list = new ArrayList<>();
        Alien alien = new Alien(MID_X, MID_Y);
        Alien.Bomb bomb = alien.getBomb();
        list.add(alien);
        board.setAliens(list);
        Player player = board.getPlayer();

        try{
            Field bomb_destroyed = Alien.Bomb.class.getDeclaredField("destroyed");
            bomb_destroyed.setAccessible(true);
            bomb_destroyed.set(bomb,false);
            Field player_visible = Sprite.class.getDeclaredField("visible");
            player_visible.setAccessible(true);
            player_visible.set(player,false);
            Method method = Board.class.getDeclaredMethod("update_bomb");
            method.setAccessible(true);
            method.invoke(board);

            assertTrue(bomb.getY() < MID_Y);
        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Board.update_bomb - Path CP7")
    void testBoardUpdate_bomb_CP7(){
        Board board = new Board();
        List<Alien> list = new ArrayList<>();
        Alien alien = new Alien(MID_X,Commons.GROUND);
        Alien.Bomb bomb = alien.getBomb();
        list.add(alien);
        board.setAliens(list);
        Player player = board.getPlayer();

        try{
            Field bomb_destroyed = Alien.Bomb.class.getDeclaredField("destroyed");
            bomb_destroyed.setAccessible(true);
            bomb_destroyed.set(bomb,false);
            Field player_visible = Sprite.class.getDeclaredField("visible");
            player_visible.setAccessible(true);
            player_visible.set(player,false);
            Method method = Board.class.getDeclaredMethod("update_bomb");
            method.setAccessible(true);
            method.invoke(board);

            assertTrue(bomb.getY() < Commons.GROUND && bomb.isDestroyed());
        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    @DisplayName("Board.update_shots - Path CP1")
    void testBoardUpdate_shots_CP1(){
        try{
            Board board = new Board();
            Field shot_visible = Sprite.class.getDeclaredField("visible");
            shot_visible.setAccessible(true);
            shot_visible.set(board.getShot(),false);
            Method method = Board.class.getDeclaredMethod("update");
            method.setAccessible(true);
            method.invoke(board);

            assertFalse(board.getShot().isVisible());
        } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    @DisplayName("Board.update_shots - Path CP2")
    void testBoardUpdate_shots_CP2(){
        try {
            Board board = new Board();
            List<Alien> empty_list = new ArrayList<>();
            board.setAliens(empty_list);
            board.getShot().setY(Commons.SHOT_SPEED * 2);
            int expected_y = board.getShot().getY() - Commons.SHOT_SPEED;

            Method method = Board.class.getDeclaredMethod("update_shots");
            method.setAccessible(true);
            method.invoke(board);
            boolean result = board.getShot().getX() == expected_y && board.getShot().getY() == expected_y;

            assertTrue(result);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e){
            throw new RuntimeException(e);
        }
    }


    @Test
    @DisplayName("Board.update_shots - Path CP3")
    void testBoardUpdate_shots_CP3(){
        try{
            Board board = new Board();
            List<Alien> empty_list = new ArrayList<>();
            board.setAliens(empty_list);
            int y = -1;
            board.getShot().setY(y);
            Method method = Board.class.getDeclaredMethod("update_shots");
            method.setAccessible(true);
            method.invoke(board);

            assertFalse(board.getShot().isVisible());
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e){
            throw new RuntimeException(e);
        }
    }


    @Test
    @DisplayName("Board.update_shots - Path CP4")
    void testBoardUpdate_shots_CP4(){
        try {
            Board board = new Board();
            List<Alien> list = new ArrayList<>();
            Alien alien = new Alien(MID_X, MID_Y);
            list.add(alien);
            board.setAliens(list);
            board.getShot().setY(alien.getY());
            board.getShot().setX(alien.getX());
            int expected_y = alien.getY() - Commons.SHOT_SPEED;

            Method method = Board.class.getDeclaredMethod("update_shots");
            method.setAccessible(true);
            method.invoke(board);

            boolean result = board.getShot().getX() == expected_y && board.getShot().getY() == expected_y
                    && board.getAliens().getFirst().isDying();

            assertTrue(result);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e){
            throw new RuntimeException(e);
        }
    }


    @Test
    @DisplayName("Board.update_shots - Path CP5")
    void testBoardUpdate_shots_CP5(){
        try{
            Board board = new Board();
            board.getAliens().add(new Alien(MID_X, MID_Y));
            int y = -1;
            board.getShot().setY(y);


            Field alien_visible = Sprite.class.getDeclaredField("visible");
            alien_visible.setAccessible(true);
            alien_visible.set(board.getAliens().getFirst(),false);


            Method method = Board.class.getDeclaredMethod("update_shots");
            method.setAccessible(true);
            method.invoke(board);

            boolean correct = !board.getShot().isVisible();

            assertTrue(correct);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException | NoSuchFieldException e ) {
            throw new RuntimeException(e);
        }
    }


    @Test
    @DisplayName("Board.update_shots - Path CP6")
    void testBoardUpdate_shots_CP6(){
        try {
            Board board = new Board();
            List<Alien> list = new ArrayList<>();
            int y_expected = 3;
            Alien alien = new Alien(MID_X,y_expected);
            list.add(alien);
            board.setAliens(list);
            board.getShot().setY(alien.getY());
            board.getShot().setX(alien.getX());

            Method method = Board.class.getDeclaredMethod("update_shots");
            method.setAccessible(true);
            method.invoke(board);

            boolean correct = !board.getShot().isVisible();

            assertTrue(correct);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e){
            throw new RuntimeException(e);
        }
    }
}
