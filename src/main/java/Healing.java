/*
Class for any healing act. It either increases the player's hp by 10 (normal healing potions), or it increases it by a specified amount. There might be some skills that can also use this class to heal the player. 
*/

public class Healing implements Usable {
	public void Use(Entity entity) { entity.setHP(entity.getHP() + 10); }
  public void Use(Entity entity, int amount) { entity.setHP(entity.getHP() + amount); }
}