package game.ui.menu;

import game.utils.SpecialString;

public class MenuItem {
    private SpecialString name;
    private Runnable action;

    public MenuItem(SpecialString name, Runnable action) {
        this.name = name;
        this.action = action;
    }

    public void run() {
        action.run();
    }

    public SpecialString getName() {
        return name;
    }
}
