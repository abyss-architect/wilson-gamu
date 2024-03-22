import java.util.HashMap;

public class Map implements ItemInterface {
	private Floor floor;
	private Boolean[][] unknown_mask;
	
	public Map(Floor floor) {
		this.floor = floor;
	}

	public Map(Floor floor, Boolean[][] unknown_mask) {
		this.floor = floor;
		this.unknown_mask = unknown_mask;
	}

	public void Use(Entity entity) {
		DisplayMap(false);
	}
	
	public void DisplayMap(boolean verbose) {
		if (verbose)
			DisplayMapVerbose();
		else
			DisplayMap();
	}

	private void DisplayMap() {
		String output = "";

		String map_title = "[MAP]";
		String border = "╔" + map_title + "═".repeat(this.floor.getWidth() * 2 - 1 - map_title.length()) + "╗\n";

		output += border;

		Room[][] rooms = this.floor.getRooms();

		int row_num = 0;

		for (Room[] row_rooms : rooms) {
			output += "║";

			int last_col = row_rooms.length - 1;
			int col_num = 0;
			
			for (Room room : row_rooms) {
				if (this.unknown_mask[row_num][col_num]) {
					output += UI.Question(UI.unknown_icon);
				} else {
					if (room.containsPlayer()) {
						output += UI.ImportantText(UI.player_icon);
					} else if (room.getRoomType() == RoomType.ROOM) {
						output += UI.GoodText(UI.room_icon);
					} else {
						output += UI.UnimportantText(String.valueOf(room));
					}
				}

				if (col_num < last_col)
					output += " ";
				
				col_num++;
			}

			output += "║\n";

			row_num++;
		}

		String bottom_border = "╚" + "═".repeat(this.floor.getWidth() * 2 - 1) + "╝";

		output += bottom_border;

		UI.PrintLine(output);
		
		DisplayMapLegend();
	}

	private void DisplayMapVerbose() {
		// System.out.println("(" + this.width + " X " + this.height + ")");

		// for (int row = 0; row < this.height; row++) {
		// 	for (int col = 0; col < this.width; col++) {
		// 		Room room = this.rooms[row][col];
		// 		System.out.print(room.getLocation() + " " + room + " ");
		// 	}

		// 	System.out.println();
		// }
	}

	private void DisplayMapLegend() {
		// HashMap<String, String> legend = new HashMap<String, String>();
		// legend.put("Player", Game.player_icon);
		// legend.put("Room", Game.room_icon);
		// legend.put("Wall", Game.wall_icon);
		String output = "";
		
		output += UI.ImportantText(UI.player_icon + " : Player\n");
		output += UI.GoodText(UI.room_icon + " : Room\n");
		output += UI.UnimportantText(UI.wall_icon + " : Wall\n");
		output += UI.Question(UI.unknown_icon + " : Unknown\n");

		UI.PrintLine(output);
	}
}