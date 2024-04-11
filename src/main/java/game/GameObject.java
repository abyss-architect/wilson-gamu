package game;

import game.utils.Location;

public abstract class GameObject {
	private Location location;

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
