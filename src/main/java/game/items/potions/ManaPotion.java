package game.items.potions;
/*
Class for any mana-increasing act. It either increases the player's mp by 10 (normal mana potions), or it increases it by a specified amount. There might be some skills that can also use this class to increase the player's mana bar. 
*/

import game.entities.Entity;

public class ManaPotion extends Potion {
    private int amount;

    public void use(Entity entity) {
        entity.setMP(entity.getMP() + amount);
    }
}