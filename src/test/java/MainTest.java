import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

import game.entities.Inventory;
import game.items.Item;
import game.items.potions.HealingPotion;
import game.items.weapons.Dagger;
import game.items.weapons.Weapon;
import game.ui.UI;
import game.utils.SpecialString;

public class MainTest {

	public static void main(String[] args) {
		Inventory inv = new Inventory(10);
		inv.setClassMaxItemCount(Weapon.class, 2);
		inv.setClassMaxItemCount(HealingPotion.class, 2);
		ArrayList<Item> items = new ArrayList<>();
		// items.add(new Dagger());
		// items.add(new Dagger());
		// items.add(new Dagger());
		// items.add(new Dagger());
		items.add(new HealingPotion());
		items.add(new HealingPotion());

		for (Item item : items) {
			if (inv.addItem(item)) 
				UI.printLine(SpecialString.goodText("Added item: " + String.valueOf(item.getClass())));
			else
				UI.printLine(SpecialString.badText("Cannot add item: " + String.valueOf(item.getClass())));
		}
	}

    @Test
    public void testOutput() {
		String output = "";

		Inventory inv = new Inventory(10);
		inv.setClassMaxItemCount(Weapon.class, 2);
		inv.setClassMaxItemCount(HealingPotion.class, 2);
		ArrayList<Item> items = new ArrayList<>();
		// items.add(new Dagger());
		// items.add(new Dagger());
		// items.add(new Dagger());
		// items.add(new Dagger());
		items.add(new HealingPotion());
		items.add(new HealingPotion());

		for (Item item : items) {
			if (inv.addItem(item)) 
				output += SpecialString.goodText("Added item: " + String.valueOf(item.getClass()));
			else
				output += SpecialString.badText("Cannot add item: " + String.valueOf(item.getClass()));
		}

        // Define the expected output
        String expectedOutput = 
			"[32mAdded item: class game.entities.items.weapons.Dagger[0m" +
			"[32mAdded item: class game.entities.items.weapons.Dagger[0m" +
			"[31mCannot add item: class game.entities.items.weapons.Dagger[0m" +
			"[31mCannot add item: class game.entities.items.weapons.Dagger[0m" +
			"[32mAdded item: class game.entities.items.potions.HealingPotion[0m" +
			"[32mAdded item: class game.entities.items.potions.HealingPotion[0m";

        // Check if the output matches the expected output
        Assert.assertEquals(expectedOutput, output);
    }
}