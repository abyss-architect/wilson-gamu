package game.entities;
import game.entities.items.weapons.Attack;
import game.entities.items.weapons.Damage;
import game.entities.items.weapons.Damageable;

public class Player extends Entity implements Attack, Damageable {
    // Local variables
    private int baseDamage = 5,
    baseRange = 1,
    baseAtkSpeed = 3,
    baseMovSpeed = 3;

    // Placeholder constructor for the player class. Will update once I understand better how the positioning & inventory system work.
    public Player() { 

    }

    public void tick() {
        // Placeholder for the player's tick method.
    }

    // Class setters
    public void setDamage(int baseDamage) { this.baseDamage = baseDamage; }

    // useAttack()
    public void useAttack(Damageable target) { 
        Damage d = new Damage(target);
        d.addDamage(baseDamage);
        takeDamage(2);
    }

    // takeDamage()
    public void takeDamage(int damageTaken) {
        super.setHP(super.getHP() - damageTaken);       
    }
}