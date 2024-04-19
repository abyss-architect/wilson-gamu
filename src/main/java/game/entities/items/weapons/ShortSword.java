package game.entities.items.weapons;

public class ShortSword extends CloseRange {
    public ShortSword(int damage, int range, int speed) {
        this.setItem("Short sword", "Just a regular dagger.");
        this.setWeaponDamage(damage);
        this.setAttackRange(range);
        this.setAttackSpeed(speed);
    }
}