package main;
/**
 * {@summary <span class="alert-small">⛔🧪 </span> Clase de constantes del juego Space Invaders}
 * En esta clase se definen las constantes utilizadas en el juego, como las dimensiones del tablero,
 * las posiciones iniciales de los alienígenas, la velocidad de movimiento, entre otras.
 * <br><br><span class="alert">⛔🧪 No es necesario probar esta clase mediante pruebas unitarias. </span>
 */
public abstract class Commons {

    public static int BOARD_WIDTH = 358;
    public static int BOARD_HEIGHT = 350;
    public static int BORDER_RIGHT = 30;
    public static int BORDER_LEFT = 5;

    public static int GROUND = 290;
    public static int BOMB_HEIGHT = 5;

    public static int ALIEN_HEIGHT = 12;
    public static int ALIEN_WIDTH = 12;

    public static int ALIEN_ROWS = 4;
    public static int ALIEN_COLUMNS = 6;
    public static int ALIEN_SEPARATOR = 18;
    public static int ALIEN_INIT_X = 150;
    public static int ALIEN_INIT_Y = 5;

    public static int GO_DOWN = 15;
    public static int NUMBER_OF_ALIENS_TO_DESTROY = 24;
    public static int CHANCE = 5;
    public static int DELAY = 17;
    public static int PLAYER_WIDTH = 15;
    public static int PLAYER_HEIGHT = 10;

    public static int SHOT_SPEED = 4;
    public static int BOMB_SPEED = 1;

    private Commons() {}
}
