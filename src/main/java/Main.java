import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {

		Game game = new Game();

		
		// String test_floor = "@ R R X X X R\n" +
		// 										"R X X X X X R\n" +
		// 										"R R R R R R R\n" +
		// 										"R X X R X X R\n" +
		// 										"R R X R X X R\n" +
		// 										"R R R R X X R\n";

		String test_floor = "@ R R X\n" +
												"X X R X\n" +
												"X R R X\n" +
												"X X R R\n";

		Boolean unknown_mask[][] = {
																	{false, false, false, false},
																	{false, true, true, false},
																	{false, true, true, false},
																	{false, false, false, false}
															 };
		
		Boolean unknown_mask_2[][] = {
																	{false, true, false, false},
																	{false, false, true, true},
																	{false, false, true, true},
																	{false, true, false, true}
															 };
		
		Floor floor = new Floor(test_floor);
		
		// floor.PrintFloor(false);
		// System.out.println();
		// floor.PrintFloor(true);

		Map map = new Map(floor, unknown_mask);
		Map map2 = new Map(floor, unknown_mask_2);
		Player player = new Player();
		map.Use(player);
		map2.Use(player);

		Inventory inv = new Inventory(10);
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(new Weapon());
		items.add(new Weapon());
		items.add(new Weapon());
		items.add(new Weapon());
		items.add(new HealingPotion());
		items.add(new StrengthPotion());
		items.add(new StrengthPotion());
		items.add(new HealingPotion());

		for (Item item : items) {
			if (inv.addItem(item)) 
				UI.PrintLine(UI.GoodText("Added item: " + String.valueOf(item.getClass())));
			else
				UI.PrintLine(UI.BadText("Cannot add item: " + String.valueOf(item.getClass())));
		}
	}

	// @Test
	// void addition() {
	// assertEquals(2, 1 + 1);
	// }
}