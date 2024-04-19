package game.entities.items.weapons;

import game.entities.Entity;
import game.utils.SpecialString;

public class Dagger extends CloseRange { 
    
    // Constructor for dagger-type weapons
    public Dagger(int damage, int range, int speed) {
        this.setItem(
            new SpecialString("Dagger"),
            new SpecialString("Just a regular dagger")
        );
        this.setWeaponDamage(damage);
        this.setAttackRange(range);
        this.setAttackSpeed(speed);
    }

    // Quick Stab skill.
    public void quickStab(Entity target) {
        this.setWeaponStats(getWeaponDamage() - 1, getAttackSpeed() + 5, getAttackRange());
        this.useAttack(target);
        this.setWeaponStats(getWeaponDamage() + 1, getAttackSpeed() - 5, getAttackRange());
    }
}