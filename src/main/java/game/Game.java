package game;

import game.entities.Player;
import game.utils.SpecialString;
import game.utils.StringColor;

public class Game {

    // Banner
    private static String banner =
        " _     _  ___   ___      _______  _______  __    _    _______  _______  __   __  __   __ \n" +
        "| | _ | ||   | |   |    |       ||       ||  |  | |  |       ||   _   ||  |_|  ||  | |  |\n" +
        "| || || ||   | |   |    |  _____||   _   ||   |_| |  |    ___||  |_|  ||       ||  | |  |\n" +
        "|       ||   | |   |    | |_____ |  | |  ||       |  |   | __ |       ||       ||  |_|  |\n" +
        "|       ||   | |   |___ |_____  ||  |_|  ||  _    |  |   ||  ||       ||       ||       |\n" +
        "|   _   ||   | |       | _____| ||       || | |   |  |   |_| ||   _   || ||_|| ||       |\n" +
        "|__| |__||___| |_______||_______||_______||_|  |__|  |_______||__| |__||_|   |_||_______|";
    private static SpecialString bannerSpecialString = new SpecialString(banner)
        .setPrintSpeed(1)
        .setColor(StringColor.GREEN)
        .setEndInNewLine(true);

    public static final String PLAYER_ICON = "@";
    public static final String ROOM_ICON = "R";
    public static final String WALL_ICON = "X";
    public static final String UNKNOWN_ICON = "?";

    public static Player player = new Player();

    private static Game game = null;

    private Game() { }

    public static Game getInstance() {
        if (game == null) {
            game = new Game();
        }

        return game;
    }

    public static void start() {
        printBanner();
    }

    public static void printBanner() {
        UI.print(bannerSpecialString);
    }

    public static void update() { }

}