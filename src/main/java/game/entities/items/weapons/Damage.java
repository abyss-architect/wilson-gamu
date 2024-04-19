package game.entities.items.weapons;

import game.entities.Entity;

public class Damage {
    private Entity target;

    public Damage(Entity target) {
        this.target = target;
    }

    public void dealDamage(int damageDealt) { target.setHP(target.getHP() - damageDealt); }
    public void dealStatDamage(int damageDealt, int dmgStatChange) {
        target.setHP(target.getHP() - (damageDealt + dmgStatChange));
    }
    
}
