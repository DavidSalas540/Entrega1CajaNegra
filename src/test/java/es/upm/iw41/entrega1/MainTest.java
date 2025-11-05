package es.upm.iw41.entrega1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import space_invaders.sprites.Alien;
import space_invaders.sprites.Alien.Bomb;
import space_invaders.sprites.Player;
import space_invaders.sprites.Shot;
import space_invaders.sprites.Sprite;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


class MainTest {

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


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
}