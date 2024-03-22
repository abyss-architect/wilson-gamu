/*
  Implemented by: Wilson J. Villegas M.
  Last modified: 03/19/2024.
  Weapon class that holds the utility functions. A weapon will be used to inflict damage upon an entity.
*/

public abstract class Weapon extends Item implements Usable {
  // Class fields.
  private int weaponDamage;

  // Default constructor for inheritance purposes.  
  public Weapon() {
    this.weaponDamage = 5;
  }

  // Constructor.
  public Weapon(String itemName, String itemDescription, int weaponDamage) {
    super(itemName, itemDescription);
    this.weaponDamage = weaponDamage;
  }
  
  // Method for "using" a weapon, which just means attacking in the context of the game.
	public void Use(Entity entity) { 
    entity.setHP(entity.getHP() - weaponDamage); 
  }
}