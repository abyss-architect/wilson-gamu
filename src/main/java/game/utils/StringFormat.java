package game.utils;

public enum StringFormat {
    BOLD("\u001B[1m"),
    ITALIC("\u001B[3m"),
    UNDERLINE("\u001B[4m"),
    STRIKETHROUGH("\u001B[9m");

    private final String format;

    StringFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
