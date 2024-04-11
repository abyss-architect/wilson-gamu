package game.utils;
public class Location {
	private Position roomPosition;
	private Position floorPosition;

	public Location(Position roomPosition, Position floorPosition) {
		this.roomPosition = roomPosition;
		this.floorPosition = floorPosition;
	}

	public Position getRoomPosition() {
		return this.roomPosition;
	}

	public Position getFloorPosition() {
		return this.floorPosition;
	}

	public void setRoomPosition(Position roomPosition) {
		this.roomPosition = roomPosition;
	}

	public void setFloorPosition(Position floorPosition) {
		this.floorPosition = floorPosition;
	}

}
