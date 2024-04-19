package game.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SpecialString implements Iterable<SpecialString> {
    private float printSpeed = -1;
    private StringColor color;
    private boolean endInNewLine = false;
    private String text;
    private ArrayList<SpecialString> suffixSpecialStrings = new ArrayList<>();

    public SpecialString() { }

    public SpecialString(String text) {
        this.text = text;
    }

    public SpecialString(SpecialString[] specialStrings) {
        addStrings(specialStrings);
    }

    public static String goodText(String text) {
    	return StringColor.GREEN.getColor() + text + StringColor.RESET.getColor();
    }

    public static String badText(String text) {
    	return StringColor.RED.getColor() + text + StringColor.RESET.getColor();
    }

    public static String importantText(String text) {
    	return StringColor.BLUE.getColor() + text + StringColor.RESET.getColor();
    }

    public static String unimportantText(String text) {
    	return StringColor.BLACK.getColor() + text + StringColor.RESET.getColor();
    }

    public static String question(String text) {
    	return StringColor.PURPLE.getColor() + text + StringColor.RESET.getColor();
    }

    public static SpecialString parse(String text) {
    	return new SpecialString(text);
    }

    @Override
    public Iterator<SpecialString> iterator() {
        // Will return the this object when next is called first and then the suffixSpecialStrings
        return new Iterator<SpecialString>() {
            private int index = 0;
            private int suffixIndex = 0;

            @Override
            public boolean hasNext() {
                return index < count();
            }

            @Override
            public SpecialString next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                if (index == 0 && hasString()) {
                    index++;
                    return SpecialString.this;
                }

                index++;
                return suffixSpecialStrings.get(suffixIndex++);
            }
        };
    }

    public SpecialString setText(String text) {
        this.text = text;
        return this;
    }

    public String getText() {
        return text;
    }

    public SpecialString addString(SpecialString specialString) {
        suffixSpecialStrings.add(specialString);

        if (specialString.getColor() == null)
            specialString.setColor(color);

        if (specialString.getPrintSpeed() < 0) {
            specialString.setPrintSpeed(printSpeed);
        }

        return this;
    }

    public SpecialString addStrings(SpecialString[] specialStrings) {
        for (SpecialString specialString : specialStrings) {
            addString(specialString);
        }

        return this;
    }

    public SpecialString setPrintSpeed(float printSpeed) {
        this.printSpeed = printSpeed;
        return this;
    }

    public float getPrintSpeed() {
        return printSpeed;
    }

    public SpecialString setColor(StringColor color) {
        this.color = color;
        return this;
    }

    public StringColor getColor() {
        return color;
    }

    public SpecialString setEndInNewLine(boolean endInNewLine) {
        this.endInNewLine = endInNewLine;
        return this;
    }

    public boolean endsInNewLine() {
        return endInNewLine;
    }

    public int count() {
        int total = suffixSpecialStrings.size();

        if (text != null)
            total++;

        return total;
    }

    public boolean hasString() {
        return text != null;
    }

    public boolean hasColor() {
        return color != null;
    }

    public String toString() {
        return text;
    }
}
