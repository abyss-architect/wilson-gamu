package game.entities.items;
import java.util.HashMap;

import game.UI;
import game.entities.Entity;
import game.scene.Floor;
import game.scene.Room;
import game.scene.RoomType;

public class Map extends Item {
	private Floor floor;
	private Boolean[][] unknownMask;
	
	public Map(Floor floor) {
		this.floor = floor;
	}

	public Map(Floor floor, Boolean[][] unknownMask) {
		this.floor = floor;
		this.unknownMask = unknownMask;
	}

	public void use(Entity entity) {
		displayMap(false);
	}
	
	public void displayMap(boolean verbose) {
		if (verbose)
			displayMapVerbose();
		else
			displayMap();
	}

	private void displayMap() {
		String output = "";

		String mapTitle = "[MAP]";
		String border = "╔" + mapTitle + "═".repeat(this.floor.getWidth() * 2 - 1 - mapTitle.length()) + "╗\n";

		output += border;

		Room[][] rooms = this.floor.getRooms();

		int rowNum = 0;

		for (Room[] rowRooms : rooms) {
			output += "║";

			int lastCol = rowRooms.length - 1;
			int colNum = 0;
			
			for (Room room : rowRooms) {
				if (this.unknownMask[rowNum][colNum]) {
					output += UI.question(UI.UNKNOWN_ICON);
				} else {
					if (room.containsPlayer()) {
						output += UI.importantText(UI.PLAYER_ICON);
					} else if (room.getRoomType() == RoomType.ROOM) {
						output += UI.goodText(UI.ROOM_ICON);
					} else {
						output += UI.unimportantText(String.valueOf(room));
					}
				}

				if (colNum < lastCol)
					output += " ";
				
				colNum++;
			}

			output += "║\n";

			rowNum++;
		}

		String bottomBorder = "╚" + "═".repeat(this.floor.getWidth() * 2 - 1) + "╝";

		output += bottomBorder;

		UI.printLine(output);
		
		displayMapLegend();
	}

	private void displayMapVerbose() {
		// System.out.println("(" + this.width + " X " + this.height + ")");

		// for (int row = 0; row < this.height; row++) {
		// 	for (int col = 0; col < this.width; col++) {
		// 		Room room = this.rooms[row][col];
		// 		System.out.print(room.getLocation() + " " + room + " ");
		// 	}

		// 	System.out.println();
		// }
	}

	private void displayMapLegend() {
		// HashMap<String, String> legend = new HashMap<String, String>();
		// legend.put("Player", Game.PLAYER_ICON);
		// legend.put("Room", Game.ROOM_ICON);
		// legend.put("Wall", Game.WALL_ICON);
		String output = "";
		
		output += UI.importantText(UI.PLAYER_ICON + " : Player\n");
		output += UI.goodText(UI.ROOM_ICON + " : Room\n");
		output += UI.unimportantText(UI.WALL_ICON + " : Wall\n");
		output += UI.question(UI.UNKNOWN_ICON + " : Unknown\n");

		UI.printLine(output);
	}

	public String displayItem() {
		return super.toString();
	}
}