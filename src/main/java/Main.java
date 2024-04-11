import java.util.ArrayList;

import game.UI;
import game.entities.Inventory;
import game.entities.Player;
import game.entities.items.Item;
import game.entities.items.Map;
import game.entities.items.potions.HealingPotion;
import game.entities.items.weapons.Dagger;
import game.entities.items.weapons.Weapon;
import game.scene.Floor;

public class Main {
	public static void main(String[] args) {
		// String testFloor = "@ R R X X X R\n" +
		// 										"R X X X X X R\n" +
		// 										"R R R R R R R\n" +
		// 										"R X X R X X R\n" +
		// 						  			"R R X R X X R\n" +
		// 										"R R R R X X R\n";

		String testFloor = 	"@ R R X\n" +
							"X X R X\n" +
							"X R R X\n" +
							"X X R R\n";

		Boolean[][] unknownMask = {
			{false, false, false, false},
			{false, true, true, false},
			{false, true, true, false},
			{false, false, false, false}
		};
		
		Boolean[][] unknownMask2 = {
			{false, true, false, false},
			{false, false, true, true},
			{false, false, true, true},
			{false, true, false, true}
		};
		
		Floor floor = new Floor(testFloor);
		Map map = new Map(floor, unknownMask);
		Map map2 = new Map(floor, unknownMask2);
		Player player = new Player();
		map.use(player);
		map2.use(player);

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
}