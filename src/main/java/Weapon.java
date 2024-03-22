/*
  Implemented by: Wilson J. Villegas M.
  Last modified: 03/22/2024.
  Weapon class that holds the utility functions. A weapon will be used to inflict damage upon an entity.
  Attack speed is how fast a weapon will be able to swing at an entity. Speed ranges from 1 to 20, 1 being slowest and 20 being fastest.
  Attack range is how far an attack can go. Range goes from 0 to 5, 0 being the closest and 5 being the furthest.
*/

public class Weapon extends Item implements Usable {
  // Class fields.
  private int weaponDamage;
  private int attackSpeed;
  private int attackRange;
  

  // Default constructor for inheritance purposes.  
  public Weapon() {
    this.weaponDamage = 5;
    this.attackSpeed = 10;
    this.attackRange = 1;
  }

  // Constructor.
  public Weapon(String itemName, String itemDescription, int weaponDamage, int attackSpeed, int attackRange) {
    super(itemName, itemDescription);
    this.weaponDamage = weaponDamage;
    this.attackSpeed = attackSpeed;
    this.attackRange = attackRange;
  }
  
  // Method for "using" a weapon, which just means attacking in the context of the game.
	public void Use(Entity entity) { 
    entity.setHP(entity.getHP() - weaponDamage); 
  }
}