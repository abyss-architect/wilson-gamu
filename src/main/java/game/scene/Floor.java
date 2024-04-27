package game.scene;

import game.utils.Position;
import game.utils.SpecialString;
import game.utils.Tuple;

public class Floor {
	private int width;
	private int height;
	private Room[][] rooms;

  // Constructor.
	public Floor() {
		
	}
  
  // Deep-Copy constructor.
	public Floor(Floor floor) {
		this.width = floor.width;
		this.height = floor.height;
		this.rooms = floor.rooms;
	}

  // Constructor for setting up a room using a String instead (Thick idea Justyn).
	public Floor(String floorData) {
		setupFloor(floorData);
	}
  
/*
  // Make this so that it creates a floor with all walls or empty rooms
	public Floor(int width, int height) {
	this.width = width;
	this.height = height;
	 }
*/
  
  // Class getters.
  public Room[][] getRooms() { return this.rooms; }
  public int getWidth() { return this.width; }
  public int getHeight() { return this.height; }

  public void setupFloor(String floorData) {
    Tuple<Integer, Integer> floorSize = Floor.getFloorDataSize(floorData);

    this.height = floorSize.getFirst();
    this.width = floorSize.getSecond();
    this.rooms = parseFloorData(floorData);
  }

  public void printFloor(boolean verbose) {
		if (verbose)
			printFloorVerbose();
		else
			printFloor();
	}

	private void printFloor() {
		System.out.println();

		for (Room[] rowRooms : this.rooms) {
			for (Room room : rowRooms) {
				if (room.getRoomType() == RoomType.ROOM) {
					SpecialString.goodText(room + " ");
				} else {
					SpecialString.unimportantText(room + " ");
				}
			}

			System.out.println();
		}
	}

	private void printFloorVerbose() {
		System.out.println("(" + this.width + " X " + this.height + ")");

		for (int row = 0; row < this.height; row++) {
			for (int col = 0; col < this.width; col++) {
				Room room = this.rooms[row][col];
				System.out.print(room.getLocation() + " " + room + " ");
			}

			System.out.println();
		}
	}



	public static Room[][] parseFloorData(String floorData) {
		Tuple<Integer, Integer> floorSize = Floor.getFloorDataSize(floorData);

		int height = floorSize.getFirst();
		int width = floorSize.getSecond();
		Room[][] rooms = new Room[height][width];
		
		String[] floorRows = floorData.split("\n");

		for (int row = 0; row < height; row++) {
			String[] rowRooms = floorRows[row].split(" ");

			for (int col = 0; col < width; col++) {
				Position position = new Position(col, row);

				Room curRoom = new Room(position);
				rooms[row][col] = curRoom;
				
				if (rowRooms[col].equals("R"))
          curRoom.setRoomType(RoomType.ROOM);
				else if (rowRooms[col].equals("@"))
					curRoom.setContainsPlayer(true);
				else if (rowRooms[col].equals("X"))
					curRoom.setRoomType(RoomType.WALL);
				else
					curRoom.setRoomType(RoomType.MISC);
			}
		}

		return rooms;
	}

	
	public static Tuple<Integer, Integer> getFloorDataSize(String floorData) {
		Tuple<Integer, Integer> floorSize = new Tuple<>(0, 0);

		String[] floorRows = floorData.split("\n");
		floorSize.setFirst(floorRows.length);

		if (floorSize.getFirst() == 0)
			return floorSize;

		String[] rowRooms = floorRows[0].split(" ");
		floorSize.setSecond(rowRooms.length);

		return floorSize;
	}

	public boolean isValidPosition(Position position) {
		if (position.getX() < 0 || position.getX() >= this.width)
			return false;
		if (position.getY() < 0 || position.getY() >= this.height)
			return false;

		return true;
	}

	public Room getRoomAtPosition(Position position) {
		if (!isValidPosition(position))
			return null;
		
		return this.rooms[position.getY()][position.getX()];
	}

	public boolean isRoom(Position position) {
		if (!isValidPosition(position))
			return false;

		Room room = getRoomAtPosition(position);
		
		return room.getRoomType() == RoomType.ROOM;
	}
  
}