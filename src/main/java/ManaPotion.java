/*
Class for any mana-increasing act. It either increases the player's mp by 10 (normal mana potions), or it increases it by a specified amount. There might be some skills that can also use this class to increase the player's mana bar. 
*/

public class ManaPotion extends Potion implements Usable {
	public void Use(Entity entity) {
		entity.setMP(entity.getMP() + 10);
	}
  public void Use(Entity entity, int amount) {
    entity.setMP(entity.getMP() + amount);
  }
}