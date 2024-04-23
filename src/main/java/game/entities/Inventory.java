package game.entities;
/*
The purpose of this class is for the player to be able to 'store' any type of items they might pick up. The player should be able to store up to:
2 Weapon-Type Items.
3 Potion-Type Items.
5 Misc-type Items.
The player should be able to 'search' throught their storage, and 'use' any of them. For some items, using might just give a brief inspection of the item, whereas for others it might do other stuff.
*/

import java.util.ArrayList;
import java.util.HashMap;

import game.items.Item;

public class Inventory {
	// private HashMap<Class, HashMap<ArrayList<Item>, Integer>> _inventory; // HashMap for storing the _inventory.
	private ArrayList<Item> _inventory = new ArrayList<>();
	// private HashMap<Class<? extends Item>, Integer> maxItemTypes = new HashMap<Class<? extends Item>, Integer>() {{
	// 	put(Weapon.class, 2);
	// 	put(Potion.class, 3);
	// 	put(ManaPotion.class, 1);
	// }};
	private HashMap<Class<? extends Item>, Integer> maxItemTypes = new HashMap<>();
	private int maxItems;

	public Inventory(int maxItems) {
		this.maxItems = maxItems;
	}

	public boolean addItem(Item item) {
		if (!canAddItem(item))
			return false;

		_inventory.add(item);
		return true;
	}

	public boolean canAddItem(Item item) {
		int maxNumber = getLowestMaxItemCount(item);
		int itemClassCount = getItemClassCount(item.getClass());

		if (itemClassCount < maxNumber)
			return true;

		return false;
	}

	public int getLowestMaxItemCount(Item item) {
		int lowestMax = maxItems;
		for (Class<? extends Item> itemClass : maxItemTypes.keySet()) {
			int maxItem = maxItemTypes.get(itemClass);
			if (itemClass.isInstance(item) && maxItem < lowestMax) {
				lowestMax = maxItem;
			}
		}

		return lowestMax;
	}

	public int getItemClassCount(Class<? extends Item> itemClass) {
		int count = 0;
		
		for (Item item : _inventory) {
			if (item.getClass() == itemClass)
				count++;
		}

		return count;
	}

	public void setClassMaxItemCount(Class<? extends Item> itemClass, int maxCount) {
		maxItemTypes.put(itemClass, maxCount);
	}

	// Overriding the toString method to display an _inventory.
	@Override
	public String toString() {
		String inv = "";
		for (Item item : _inventory)
		inv += item + " | ";

		return inv;
	}
}