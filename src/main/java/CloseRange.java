/*
  Created by: Wilson J. Villegas M.
  Last modified: 03/22/2024.

  Close-range class that will be used for all the sword-type weapons, which there will be 3 types of: 
  Dagger,
  Short sword,
  Long sword.
  See their respective classes for details.
*/

public class CloseRange extends Weapon {

  // Constructor.
  public CloseRange(String itemName, String itemDescription, int weaponDamage, int attackSpeed, int attackRange) {
    super(itemName, itemDescription, weaponDamage, attackSpeed, attackRange);
  }  
}