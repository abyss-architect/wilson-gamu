package game.entities.items.weapons;

import game.entities.Entity;
import game.entities.items.Item;

public class Damage {
    private Entity target;
    private Weapon weapon;

    public Damage(Entity target) {
        this.target = target;
    }

    public Damage(Weapon weapon) {
        this.weapon = weapon;
    }

    public Damage addDamage(int damageDealt) { 
        target.setHP(target.getHP() - damageDealt); 
        return this;
    }
    public Damage addDamagetoWeapon(int damageDealt) {
        weapon.setDurability(weapon.getDurability() - damageDealt);
        return this;
    }
    public void dealStatDamage(int damageDealt, int dmgStatChange) {
        target.setHP(target.getHP() - (damageDealt + dmgStatChange));
    }
    
}
