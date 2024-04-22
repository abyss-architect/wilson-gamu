package game.entities.items.weapons;

public class Damage {
    private Damageable target;

    public Damage(Damageable target) {
        this.target = target;
    }

    public Damage addDamage(int damageTaken) {
        target.takeDamage(damageTaken);
        return this;
    }
    
}
