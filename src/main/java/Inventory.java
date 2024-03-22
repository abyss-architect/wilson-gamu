/*
The purpose of this class is for the player to be able to 'store' any type of items they might pick up. The player should be able to store up to:
2 Weapon-Type Items.
3 Potion-Type Items.
5 Misc-type Items.
The player should be able to 'search' throught their storage, and 'use' any of them. For some items, using might just give a brief inspection of the item, whereas for others it might do other stuff.
*/

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
  // Private fields.
  
  // Constructor.

	// private HashMap<Class, HashMap<ArrayList<Item>, Integer>> inventory; // HashMap for storing the inventory.
	private ArrayList<Item> inventory = new ArrayList<Item>();
	private HashMap<Class<? extends Item>, Integer> max_item_types = new HashMap<Class<? extends Item>, Integer>() {{
		put(Weapon.class, 2);
		put(Potion.class, 3);
		put(ManaPotion.class, 1);
	}};
	private int max_items;

	public Inventory(int max_items) {
		this.max_items = max_items;
	}

	public boolean addItem(Item item) {
		if (!canAddItem(item))
			return false;

		inventory.add(item);
		return true;
	}

	public boolean canAddItem(Item item) {
		int max_number = getLowestMaxItemCount(item);
		int item_class_count = getItemClassCount(item.getClass());

		if (item_class_count < max_number)
			return true;

		return false;
	}

	public int getLowestMaxItemCount(Item item) {
		int lowest_max = max_items;
		for (Class<? extends Item> item_class : max_item_types.keySet()) {
			int max_item = max_item_types.get(item_class);
			if (item_class.isInstance(item) && max_item < lowest_max) {
				lowest_max = max_item;
			}
		}

		return lowest_max;
	}

	public int getItemClassCount(Class<? extends Item> item_class) {
		int count = 0;
		
		for (Item item : inventory) {
			if (item.getClass() == item_class)
				count++;
		}

		return count;
	}

  // Overriding the toString method to display an inventory.
  @Override
  public String toString() {
    String inv = "";
    for (Item item : inventory)
      inv += item + " | ";

    return inv;
  }
}