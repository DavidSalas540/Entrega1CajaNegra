package es.upm.iw41.entrega1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import space_invaders.sprites.Player;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTest {

    private static KeyEvent key(int id, int keyCode) {
        return new KeyEvent(new Canvas(), id, System.currentTimeMillis(), 0, keyCode, KeyEvent.CHAR_UNDEFINED);
    }

    @Test
    @DisplayName("Player.KeyPressed: flecha izquierda, movimiento hacia la izquierda")
    void playerKeyPressed_leftMovesLeft() {
        Player player = new Player();
        int x = player.getX();
        player.keyPressed(key(KeyEvent.KEY_PRESSED, KeyEvent.VK_LEFT));
        player.act();
        boolean resultado = player.getX() < x;
        assertTrue(resultado);
    }

    @Test
    @DisplayName("Player.keyPressed: flecha derecha, movimiento hacia la derecha")
    void playerKeyPressed_rightMovesRight() {
        Player player = new Player();
        int x = player.getX();
        player.keyPressed(key(KeyEvent.KEY_PRESSED, KeyEvent.VK_RIGHT));
        player.act();
        boolean resultado = player.getX() > x;
        assertTrue(resultado);
    }

    @Test
    @DisplayName("Player.keyPressed: tecla inválida, no afecta al movimiento tras act()")
    void playerKeyPressed_invalidNoMove() {
        Player player = new Player();
        int x = player.getX();
        player.keyPressed(key(KeyEvent.KEY_PRESSED, KeyEvent.VK_UP));
        player.act();
        assertEquals(x, player.getX());
    }

    @Test
    @DisplayName("keyReleased RIGHT: detiene el movimiento a la derecha")
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
    @DisplayName("keyReleased LEFT: detiene el movimiento a la izquierda")
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
    @DisplayName("keyReleased tecla inválida: no altera el estado del movimiento")
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
