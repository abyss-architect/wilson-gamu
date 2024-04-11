package game.entities.items.potions;
/*
Class for any healing act. It either increases the player's hp by 10 (normal healing potions), or it increases it by a specified amount. There might be some skills that can also use this class to heal the player. 
*/

import game.entities.Entity;

public class HealingPotion extends Potion {
    private int amount;

    public void use(Entity entity) {
        entity.setHP(entity.getHP() + amount);
    }
}