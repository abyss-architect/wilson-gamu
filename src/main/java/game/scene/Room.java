package game.scene;
import java.util.ArrayList;

import game.entities.Entity;
import game.entities.Player;
import game.items.Item;
import game.utils.Position;

// Enum for differentiating for if a room is a regular room, an inacessible spot, or misc (I think).

public class Room {
	private RoomType roomType; // Type of room.
	private Position location; // Location of room in the overall map.
	private boolean containsPlayer; // Bool to check if the room contains the player.
	private ArrayList<Item> items; // List for holding the amount of items in the room.

	// Room constructor. Accepts just a location (kinda pointless imo).
	public Room(Position location) {
		this.roomType = RoomType.ROOM; 
		this.location = location;
	}

	// 2nd room constructor. Accepts a location and a room type.
	public Room(RoomType roomType, Position location) {
		this.roomType = roomType;
		this.location = location;
	}

	// Class getters.
	public RoomType getRoomType() { return this.roomType; }
	public Position getLocation() { return this.location; }
	public boolean containsPlayer() { return this.containsPlayer; }
	public ArrayList<Item> getItems() { return this.items; }

	// Class setters.
	public void setRoomType(RoomType roomType) { this.roomType = roomType; }
	public void setContainsPlayer(boolean containsPlayer) {
		this.containsPlayer = containsPlayer;
	}

	// Method for checking if the player is in the room: containsPlayer = true if the player has entered.
	public void enter(Entity entity) {
		if (entity instanceof Player) 
			setContainsPlayer(true);
	}

	// Overriding the toString method to display if the room is an accessible or inacessible room. Accessible rooms will be shown as "R", and 'walls' or inaccesible rooms will be shown as "X".
	@Override
	public String toString() {
		if (this.roomType == RoomType.ROOM) {
			return "R";
		} else if (this.roomType == RoomType.WALL) {
			return "X";
		}

		return "?";
	}
}