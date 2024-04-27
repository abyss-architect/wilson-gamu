package game.ui.menu;

import java.util.HashMap;
import java.util.Map.Entry;

import game.ui.UI;
import game.utils.SpecialString;
import game.utils.StringColor;

public abstract class Menu {
    private HashMap<String, MenuItem> menuDictionary = new HashMap<>();

    public void show() {
        for (Entry<String, MenuItem> entry : menuDictionary.entrySet()) {
            SpecialString menuItemUI = new SpecialString(entry.getKey() + ". ")
                .setPrintSpeed(0.5f)
                .setEndInNewLine(true)
                .addString(menuDictionary.get(entry.getKey()).getName());
            UI.print(menuItemUI);
        }
    }

    public Menu mapMenuItem(String actionString, MenuItem action) {
        menuDictionary.put(actionString, action);
        return this;
    }

    public void runAction(String actionString) {
        menuDictionary.get(actionString).run();
    }

    public void use() {
        show();
        runAction(
            UI.ask(
                new SpecialString("What would you like to do? ")
                    .setPrintSpeed(0.5f)
                    .setColor(StringColor.BRIGHT_BLACK)
            )
        );
    }
}
