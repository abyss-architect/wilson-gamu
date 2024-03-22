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
	public Floor(String floor_data) {
		SetupFloor(floor_data);
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

  public void SetupFloor(String floor_data) {
    Tuple<Integer, Integer> floor_size = Floor.getFloorDataSize(floor_data);

    this.height = floor_size.getFirst();
    this.width = floor_size.getSecond();
    this.rooms = parseFloorData(floor_data);
  }

  public void PrintFloor(boolean verbose) {
		if (verbose)
			PrintFloorVerbose();
		else
			PrintFloor();
	}

	private void PrintFloor() {
		System.out.println();

		for (Room[] row_rooms : this.rooms) {
			for (Room room : row_rooms) {
				if (room.getRoomType() == RoomType.ROOM) {
					UI.GoodText(room + " ");
				} else {
					UI.UnimportantText(room + " ");
				}
			}

			System.out.println();
		}
	}

	private void PrintFloorVerbose() {
		System.out.println("(" + this.width + " X " + this.height + ")");

		for (int row = 0; row < this.height; row++) {
			for (int col = 0; col < this.width; col++) {
				Room room = this.rooms[row][col];
				System.out.print(room.getLocation() + " " + room + " ");
			}

			System.out.println();
		}
	}



	public static Room[][] parseFloorData(String floor_data) {
		Tuple<Integer, Integer> floor_size = Floor.getFloorDataSize(floor_data);

		int height = floor_size.getFirst();
		int width = floor_size.getSecond();
		Room[][] rooms = new Room[height][width];
		
		String[] floor_rows = floor_data.split("\n");

		for (int row = 0; row < height; row++) {
			String[] row_rooms = floor_rows[row].split(" ");

			for (int col = 0; col < width; col++) {
				Position position = new Position(col, row);

				Room cur_room = new Room(position);
				rooms[row][col] = cur_room;
				
				if (row_rooms[col].equals("R"))
          cur_room.SetRoomType(RoomType.ROOM);
				else if (row_rooms[col].equals("@"))
					cur_room.SetContainsPlayer(true);
				else if (row_rooms[col].equals("X"))
					cur_room.SetRoomType(RoomType.WALL);
				else
					cur_room.SetRoomType(RoomType.MISC);
			}
		}

		return rooms;
	}

	
	public static Tuple<Integer, Integer> getFloorDataSize(String floor_data) {
		Tuple<Integer, Integer> floor_size = new Tuple<Integer, Integer>(0, 0);

		String[] floor_rows = floor_data.split("\n");
		floor_size.SetFirst(floor_rows.length);

		if (floor_size.getFirst() == 0)
			return floor_size;

		String[] row_rooms = floor_rows[0].split(" ");
		floor_size.SetSecond(row_rooms.length);

		return floor_size;
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