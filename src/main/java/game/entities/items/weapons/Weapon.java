package game.entities.items.weapons;
/*
  Implemented by: Wilson J. Villegas M.
  Last modified: 03/22/2024.
  Weapon class that holds the utility functions. A weapon will be used to inflict damage upon an entity.
  Attack speed is how fast a weapon will be able to swing at an entity. Speed ranges from 1 to 20, 1 being slowest and 20 being fastest.
  Attack range is how far an attack can go. Range goes from 0 to 5, 0 being the closest and 5 being the furthest.
*/

import game.entities.Entity;
import game.entities.items.Item;

public abstract class Weapon extends Item implements Attack, Damageable {
    // Class fields.
    private double powerMod, atkSpeedMod, atkRangeMod;
    private int durability;
    
    // Default constructor for inheritance purposes.  
    protected Weapon() { }

    // Method for "using" a weapon, which just means attacking in the context of the game.
	public void useAttack(Damageable target) { 
        Damage d = new Damage(target);
        d.addDamage(1);
        takeDamage(1);
    }

    // Class setters
    public Weapon setStats(double pm, double sm, double rm, int dur) {
        this.powerMod = pm;
        this.atkSpeedMod = sm;
        this.atkRangeMod = rm;
        this.durability = dur;

        return this;
    }

    // Class getters
    public double getPowerMod() { return powerMod; }
    public double getAtkSpeedMod() { return atkSpeedMod; }
    public double getAtkRangeMod() { return atkRangeMod; }
    public int getDurability() { return durability; }

    // Method for any weapon to take damage.
    public void takeDamage(int damageTaken) {
      this.durability -= damageTaken;
    }
}