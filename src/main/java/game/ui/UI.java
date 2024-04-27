package game.ui;

import game.utils.SpecialString;
import game.utils.StringColor;
import game.utils.StringFormat;

public class UI {
	private static SpecialString defaultIllegalResponseMessage = new SpecialString("Invalid response. Please try again.")
		.setColor(StringColor.BRIGHT_BLACK)
		.addFormat(StringFormat.ITALIC)
		.setEndInNewLine(true);

	public static void print(String text) {
		System.out.print(text);
	}

	public static void printLine(String text) {
		System.out.println(text);
	}

	public static void print(SpecialString specialString) {
		for (SpecialString s : specialString) {
			String text = s.toString();
			long printStep = (long) ((s.getPrintSpeed() / text.length()) * 1000);

			if (printStep < 1)
				printStep = 0;

			if (s.hasColor())
				System.out.print(s.getColor().getColor());

			if (s.hasFormats())
				for (StringFormat stringFormat : s.getFormats())
					System.out.print(stringFormat.getFormat());

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

			if (s != specialString && s.endsInNewLine())
				System.out.println();
		}

		if (specialString.endsInNewLine())
			System.out.println();
	}
	
	public static void clear() {
		System.out.print("\033[H\033[2J");
	}

	public static String ask(SpecialString question) {
		print(question);
		return System.console().readLine();
	}

	public static String ask(SpecialString question, String[] illegalResponses) {
		String response = ask(question);

		for (String illegalResponse : illegalResponses) {
			if (response.equals(illegalResponse)) {
				print(defaultIllegalResponseMessage);
				return ask(question, illegalResponses);
			}
		}

		return response;
	}
}