/*
Class for the healing potions. It either increases the player's hp by 10 (normal healing potions), or it increases it by a specified amount.
*/

public class HealingPotion implements Usable {
	public void Use(Entity entity) { entity.setHP(entity.getHP() + 10); }
  public void Use(Entity entity, int amount) { entity.setHP(entity.getHP() + amount); }
}