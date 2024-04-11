import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

import game.UI;
import game.entities.Inventory;
import game.entities.items.Item;
import game.entities.items.potions.HealingPotion;
import game.entities.items.weapons.Dagger;
import game.entities.items.weapons.Weapon;

public class MainTest {

	public static void main(String[] args) {
		Inventory inv = new Inventory(10);
		inv.setClassMaxItemCount(Weapon.class, 2);
		inv.setClassMaxItemCount(HealingPotion.class, 2);
		ArrayList<Item> items = new ArrayList<>();
		items.add(new Dagger());
		items.add(new Dagger());
		items.add(new Dagger());
		items.add(new Dagger());
		items.add(new HealingPotion());
		items.add(new HealingPotion());

		for (Item item : items) {
			if (inv.addItem(item)) 
				UI.printLine(UI.goodText("Added item: " + String.valueOf(item.getClass())));
			else
				UI.printLine(UI.badText("Cannot add item: " + String.valueOf(item.getClass())));
		}
	}

    @Test
    public void testOutput() {
		String output = "";

		Inventory inv = new Inventory(10);
		inv.setClassMaxItemCount(Weapon.class, 2);
		inv.setClassMaxItemCount(HealingPotion.class, 2);
		ArrayList<Item> items = new ArrayList<>();
		items.add(new Dagger());
		items.add(new Dagger());
		items.add(new Dagger());
		items.add(new Dagger());
		items.add(new HealingPotion());
		items.add(new HealingPotion());

		for (Item item : items) {
			if (inv.addItem(item)) 
				output += UI.goodText("Added item: " + String.valueOf(item.getClass()));
			else
				output += UI.badText("Cannot add item: " + String.valueOf(item.getClass()));
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