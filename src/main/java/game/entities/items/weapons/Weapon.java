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

public abstract class Weapon extends Item implements Attack {
    // Class fields.
    private int weaponDamage;
    private int attackSpeed;
    private int attackRange;
    
    // Default constructor for inheritance purposes.  
    protected Weapon() { }

    // Method for "using" a weapon, which just means attacking in the context of the game.
	  public void useAttack(Entity target) { 
      Damage d = new Damage(target);
      d.dealDamage(weaponDamage);
    }
    public void useAttack(Entity target, Entity user) { 
      useAttack(target);
    }

    // Class setters
    public void setWeaponStats(int damage, int speed, int range) {
      this.weaponDamage = damage;
      this.attackSpeed = speed;
      this.attackRange = range;
    }
    public Weapon setWeaponDamage(int weaponDamage) { 
      this.weaponDamage = weaponDamage; 
      return this;
    }
    public Weapon setAttackSpeed(int attackSpeed) { 
      this.attackSpeed = attackSpeed; 
      return this;
    }
    public Weapon setAttackRange(int attackRange) {
      this.attackRange = attackRange; 
      return this;
    }

    // Class getters
    public int getWeaponDamage() { return weaponDamage; }
    public int getAttackSpeed() { return attackSpeed; }
    public int getAttackRange() { return attackRange; }
}