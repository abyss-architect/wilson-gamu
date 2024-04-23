package game.entities;
import game.Tickable;
import game.items.weapons.Attack;

public class Player extends Entity implements Attack {
    // Local variables
    private int baseDamage = 5;
    private int speed = 5;

    // Placeholder constructor for the player class. Will update once I understand better how the positioning & inventory system work.
    public Player() { 

    }

    public void tick() {
        // Placeholder for the player's tick method.
    }

    public void setDamage(int baseDamage) { this.baseDamage = baseDamage; }
    public void useAttack(Entity target) { target.setHP(target.getHP() - baseDamage); }
    public void useAttack(Entity target, Entity user) { }
}