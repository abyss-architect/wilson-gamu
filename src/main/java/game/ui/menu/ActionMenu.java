package game.ui.menu;

import game.ui.UI;
import game.utils.SpecialString;
import game.utils.StringColor;

public class ActionMenu extends Menu {
    public ActionMenu() {
        mapMenuItem("1", new MenuItem(new SpecialString("Attack")
            .setColor(StringColor.RED),
            () -> {
                UI.print(
                    new SpecialString("You attack the enemy!")
                        .setPrintSpeed(0.5f)
                        .setColor(StringColor.RED)
                        .setEndInNewLine(true)
                );

                use();
            }
        ));

        mapMenuItem("2", new MenuItem(new SpecialString("Defend")
            .setColor(StringColor.BLUE),
            () -> {
                UI.print(
                    new SpecialString("You defend against the enemy's attack!")
                        .setPrintSpeed(0.5f)
                        .setColor(StringColor.BLUE)
                        .setEndInNewLine(true)
                );

                use();
            }
        ));

        mapMenuItem("3", new MenuItem(new SpecialString("Use Item")
            .setColor(StringColor.GREEN),
            () -> {
                UI.print(
                    new SpecialString("You use an item!")
                        .setPrintSpeed(0.5f)
                        .setColor(StringColor.GREEN)
                        .setEndInNewLine(true)
                );

                use();
            }
        ));

        mapMenuItem("4", new MenuItem(new SpecialString("Run")
            .setColor(StringColor.YELLOW),
            () -> {
                UI.print(
                    new SpecialString("You run away!")
                        .setPrintSpeed(0.5f)
                        .setColor(StringColor.YELLOW)
                        .setEndInNewLine(true)
                );
            }
        ));
    }
}
