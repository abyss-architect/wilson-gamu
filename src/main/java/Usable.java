/*
  Interface for any usable item in the game. 
  Any item that can be used in the game should implement this interface.
*/

public interface Usable {
  public void Use(Entity entity);
}