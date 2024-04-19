package game.entities.items.weapons;

import game.entities.Entity;
import game.utils.SpecialString;

public class LongSword extends CloseRange {

    public LongSword(int damage, int range, int speed) {
        this.setItem(
            new SpecialString("LongSword"),
            new SpecialString("Just a regular longsword")
        );
        this.setWeaponDamage(damage);
        this.setAttackRange(range);
        this.setAttackSpeed(speed);
    }

    public void heavySwing(Entity target) {
        this.setWeaponStats(getWeaponDamage() + 5, getAttackSpeed() - 2, getAttackRange() + 1);
    }
}