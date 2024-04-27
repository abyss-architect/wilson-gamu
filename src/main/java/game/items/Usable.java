package game.items;
/*
  Interface for any usable item in the game. 
  Any item that can be used in the game should implement this interface.
*/

import game.entities.Entity;

public interface Usable {
  public void use(Entity user);
  public void use(Entity user, Entity target);
}