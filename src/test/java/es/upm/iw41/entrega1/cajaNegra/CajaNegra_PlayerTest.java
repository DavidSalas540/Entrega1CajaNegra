package es.upm.iw41.entrega1.cajaNegra;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import space_invaders.sprites.Player;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CajaNegra_PlayerTest {

    private static KeyEvent key(int id, int keyCode) {
        return new KeyEvent(new Canvas(), id, System.currentTimeMillis(), 0, keyCode, KeyEvent.CHAR_UNDEFINED);
    }

    @Test
    @DisplayName("Player.KeyPressed: Left moves to the left")
    void playerKeyPressed_leftMovesLeft() {
        Player player = new Player();
        int x = player.getX();
        player.keyPressed(key(KeyEvent.KEY_PRESSED, KeyEvent.VK_LEFT));
        player.act();
        boolean result = player.getX() < x;

        assertTrue(result);
    }

    @Test
    @DisplayName("Player.KeyPressed: Right moves to the right")
    void playerKeyPressed_rightMovesRight() {
        Player player = new Player();
        int x = player.getX();
        player.keyPressed(key(KeyEvent.KEY_PRESSED, KeyEvent.VK_RIGHT));
        player.act();
        boolean result = player.getX() > x;

        assertTrue(result);
    }

    @Test
    @DisplayName("Player.keyPressed: Invalid key, not affect the movement after act()")
    void playerKeyPressed_invalidNoMove() {
        Player player = new Player();
        int x = player.getX();
        player.keyPressed(key(KeyEvent.KEY_PRESSED, KeyEvent.VK_UP));
        player.act();

        assertEquals(x, player.getX());
    }

    @Test
    @DisplayName("keyReleased RIGHT: stops movement to the right")
    void releaseRightStopsMovement() {
        Player p = new Player();
        p.keyPressed(key(KeyEvent.KEY_PRESSED, KeyEvent.VK_RIGHT));
        p.act();
        int x1 = p.getX();
        p.keyReleased(key(KeyEvent.KEY_RELEASED, KeyEvent.VK_RIGHT));
        p.act();
        int x2 = p.getX();

        assertEquals(x1, x2);
    }

    @Test
    @DisplayName("keyReleased LEFT: stops movement to the left")
    void releaseLeftStopsMovement() {
        Player p = new Player();
        p.keyPressed(key(KeyEvent.KEY_PRESSED, KeyEvent.VK_LEFT));
        p.act();
        int x1 = p.getX();
        p.keyReleased(key(KeyEvent.KEY_RELEASED, KeyEvent.VK_LEFT));
        p.act();
        int x2 = p.getX();

        assertEquals(x1, x2);
    }

    @Test
    @DisplayName("keyReleased invalid key: do not alter the movement status")
    void releaseInvalidKeyNoEffect() {
        Player p = new Player();

        p.keyPressed(key(KeyEvent.KEY_PRESSED, KeyEvent.VK_RIGHT));
        p.act();
        int x1 = p.getX();

        p.keyReleased(key(KeyEvent.KEY_RELEASED, KeyEvent.VK_UP));
        p.act();
        int x2 = p.getX();

        assertTrue(x2 > x1);
    }
}
