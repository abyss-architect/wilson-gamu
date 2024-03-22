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

	public static String player_icon = "@";
	public static String room_icon = "R";
	public static String wall_icon = "X";
	public static String unknown_icon = "?";

	public static String GoodText(String text) {
		return ANSI_GREEN + text + ANSI_RESET;
	}

	public static String BadText(String text) {
		return ANSI_RED + text + ANSI_RESET;
	}

	public static String ImportantText(String text) {
		return ANSI_BLUE + text + ANSI_RESET;
	}
	
	public static String UnimportantText(String text) {
		return ANSI_BRIGHT_BLACK + text + ANSI_RESET;
	}

	public static String Question(String text) {
		return ANSI_PURPLE + text + ANSI_RESET;
	}
	
	public static void Print(String text) {
		System.out.print(text);
	}
	
	public static void PrintLine(String text) {
		System.out.println(text);
	}
	
	public static void Clear() {
		System.out.print("\033[H\033[2J");
	}
	
	public static void Pause() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void Pause(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}