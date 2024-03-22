import java.util.ArrayList;

// Enum for differentiating for if a room is a regular room, an inacessible spot, or misc (I think).
enum RoomType {
	ROOM,
	WALL,
	MISC
}

public class Room {
	private RoomType room_type; // Type of room.
	private Position location; // Location of room in the overall map.
	private boolean containsPlayer; // Bool to check if the room contains the player.
	private ArrayList<Item> items; // List for holding the amount of items in the room.

  // Room constructor. Accepts just a location (kinda pointless imo).
	public Room(Position location) {
		this.room_type = RoomType.ROOM; 
		this.location = location;
	}

  // 2nd room constructor. Accepts a location and a room type.
	public Room(RoomType room_type, Position location) {
		this.room_type = room_type;
		this.location = location;
	}

  // Class getters.
	public RoomType getRoomType() { return this.room_type; }
  public Position getLocation() { return this.location; }
  public boolean containsPlayer() { return this.containsPlayer; }
  public ArrayList<Item> getItems() { return this.items; }

  // Class setters.
  public void SetRoomType(RoomType room_type) { this.room_type = room_type; }
	public void SetContainsPlayer(boolean containsPlayer) {
		this.containsPlayer = containsPlayer;
	}

  // Method for checking if the player is in the room: containsPlayer = true if the player has entered.
  public void Enter(Entity entity) {
		if (entity instanceof Player) 
			SetContainsPlayer(true);
	}

  // Overriding the toString method to display if the room is an accessible or inacessible room. Accessible rooms will be shown as "R", and 'walls' or inaccesible rooms will be shown as "X".
	@Override
	public String toString() {
		if (this.room_type == RoomType.ROOM) {
			return "R";
		} else if (this.room_type == RoomType.WALL) {
			return "X";
		}

		return "?";
	}
}