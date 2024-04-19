package game;

import game.utils.SpecialString;
import game.utils.StringColor;

public class UI {
	public static void print(String text) {
		System.out.print(text);
	}

	public static void print(SpecialString specialString) {
		for (SpecialString s : specialString) {
			String text = s.toString();
			long printStep = (long) ((s.getPrintSpeed() / text.length()) * 1000);

			if (s.hasColor())
				System.out.print(s.getColor().getColor());

			for (char c : text.toCharArray()) {
				System.out.print(c);
				try {
					Thread.sleep(printStep);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			if (s.hasColor())
				System.out.print(StringColor.RESET.getColor());
			
			if (s.endsInNewLine())
				System.out.println();
		}

		if (specialString.endsInNewLine())
			System.out.println();
	}
	
	public static void printLine(String text) {
		System.out.println(text);
	}
	
	public static void clear() {
		System.out.print("\033[H\033[2J");
	}
}