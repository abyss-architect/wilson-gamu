package game;
public class UI {
	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_BLACK = "\u001B[30m";
	private static final String ANSI_BRIGHT_BLACK = "\u001B[90m";
	private static final String ANSI_RED = "\u001B[31m";
	private static final String ANSI_GREEN = "\u001B[32m";
	private static final String ANSI_YELLOW = "\u001B[33m";
	private static final String ANSI_BLUE = "\u001B[34m";
	private static final String ANSI_PURPLE = "\u001B[35m";
	private static final String ANSI_CYAN = "\u001B[36m";
	private static final String ANSI_WHITE = "\u001B[37m";

	public static final String PLAYER_ICON = "@";
	public static final String ROOM_ICON = "R";
	public static final String WALL_ICON = "X";
	public static final String UNKNOWN_ICON = "?";

	public static String goodText(String text) {
		return ANSI_GREEN + text + ANSI_RESET;
	}

	public static String badText(String text) {
		return ANSI_RED + text + ANSI_RESET;
	}

	public static String importantText(String text) {
		return ANSI_BLUE + text + ANSI_RESET;
	}
	
	public static String unimportantText(String text) {
		return ANSI_BRIGHT_BLACK + text + ANSI_RESET;
	}

	public static String question(String text) {
		return ANSI_PURPLE + text + ANSI_RESET;
	}
	
	public static void print(String text) {
		System.out.print(text);
	}
	
	public static void printLine(String text) {
		System.out.println(text);
	}
	
	public static void clear() {
		System.out.print("\033[H\033[2J");
	}
	
	public static void pause() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void pause(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}