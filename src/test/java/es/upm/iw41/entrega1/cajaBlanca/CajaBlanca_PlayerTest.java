package es.upm.iw41.entrega1.cajaBlanca;

import main.Commons;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import space_invaders.sprites.Player;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.*;

public class CajaBlanca_PlayerTest {

    private static KeyEvent key(int id, int keyCode) {
        return new KeyEvent(new Canvas(), id, System.currentTimeMillis(), 0, keyCode, KeyEvent.CHAR_UNDEFINED);
    }

    
    @Test
    @DisplayName("Player.act - Path CP2")
    void testAct_Path_CP2(){
        Player player = new Player();
        int width = Commons.BOARD_WIDTH - 2 * player.getImage().getWidth(null);
        int x = width - 1;
        player.setX(x);
        player.keyPressed(key(KeyEvent.KEY_PRESSED, KeyEvent.VK_RIGHT));
        player.act();

        assertEquals(width, player.getX());
    }


    @Test
    @DisplayName("Player.act - Path CP3")
    void testact_Path_CP3(){
        Player player = new Player();
        int x = 3;
        player.setX(x);
        player.keyPressed(key(KeyEvent.KEY_PRESSED, KeyEvent.VK_LEFT));
        player.act();

        int x_expected = 2;
        assertEquals(x_expected, player.getX());
    }


    @Test
    @DisplayName("Player.initPlayer - Path CP1")
    void testinitPlayer_Path_CP1() {
        Player player = new Player();

        assertNotNull(player.getImage());
    }


    @Test
    @DisplayName("Player.keyPressed - Path CP1")
    void testKeyPressed_Path_CP1() {
        Player player = new Player();
        int x = player.getX();
        player.keyPressed(key(KeyEvent.KEY_PRESSED, KeyEvent.VK_UP));
        player.act();

        assertEquals(x, player.getX());
    }


    @Test
    @DisplayName("Player.keyPressed - Path CP2")
    void testKeyPressed_Path_CP2() {
        Player player = new Player();
        int x = player.getX();
        player.keyPressed(key(KeyEvent.KEY_PRESSED, KeyEvent.VK_LEFT));
        player.act();
        boolean result = player.getX() < x;

        assertTrue(result);
    }

    @Test
    @DisplayName("Player.keyPressed - Path CP3")
    void testKeyPressed_Path_CP3() {
        Player player = new Player();
        int x = player.getX();
        player.keyPressed(key(KeyEvent.KEY_PRESSED, KeyEvent.VK_RIGHT));
        player.act();
        boolean result = player.getX() > x;

        assertTrue(result);
    }


    @Test
    @DisplayName("Player.keyReleased - Path CP1")
    void testKeyReleased_Path_CP1() {
        Player p = new Player();

        p.keyPressed(key(KeyEvent.KEY_PRESSED, KeyEvent.VK_RIGHT));
        p.act();
        int x1 = p.getX();

        p.keyReleased(key(KeyEvent.KEY_RELEASED, KeyEvent.VK_UP));
        p.act();
        int x2 = p.getX();

        assertTrue(x2 > x1);
    }

    @Test
    @DisplayName("Player.keyReleased - Path CP2")
    void testKeyReleased_Path_CP2() {
        Player player = new Player();
        player.keyPressed(key(KeyEvent.KEY_PRESSED, KeyEvent.VK_RIGHT));
        player.act();
        int x1 = player.getX();
        player.keyReleased(key(KeyEvent.KEY_RELEASED, KeyEvent.VK_RIGHT));
        player.act();
        int x2 = player.getX();

        assertEquals(x1, x2);
    }

    @Test
    @DisplayName("Player.keyReleased - Path CP2")
    void testKeyReleased_Path_CP3() {
        Player player = new Player();
        player.keyPressed(key(KeyEvent.KEY_PRESSED, KeyEvent.VK_LEFT));
        player.act();
        int x1 = player.getX();
        player.keyReleased(key(KeyEvent.KEY_RELEASED, KeyEvent.VK_LEFT));
        player.act();
        int x2 = player.getX();

        assertEquals(x1, x2);
    }
}
