package game.entities.items.weapons;

import game.entities.Entity;

public class Dagger extends CloseRange { 
    // Local variables
    private int[] quickStabStats = new int[] {1, 5, 0};
    
    // Constructor for dagger-type weapons
    public Dagger(int damage, int range, int speed) {
        this.setItem("Dagger", "Just a regular dagger");
        this.setWeaponDamage(damage);
        this.setAttackRange(range);
        this.setAttackSpeed(speed);
    }

    // Quick Stab skill.
    public void quickStab(Entity target) {
        Damage d = new Damage(target);
        d.dealStatDamage(this.getWeaponDamage(), -1);

    }
}