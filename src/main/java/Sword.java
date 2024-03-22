/*
  Created by: Wilson J. Villegas M.
  Last modified: 03/22/2024.

  Sword class that will be used for all the sword-type weapons, which there will be 3 types of: 
  Dagger,
  Short sword,
  Long sword.
*/
enum SwordTypes {
  DAGGER,
  SHORT_SWORD,
  LONG_SWORD
}

public class Sword extends Weapon {
  // Class fields.
  private SwordTypes swordType;

  // Constructor.
  public Sword(SwordTypes swordType, String itemName, String itemDescription, int weaponDamage, int attackSpeed, int attackRange) {
    super(itemName, itemDescription, weaponDamage, attackSpeed, attackRange);
    this.swordType = swordType;
    setSwordAttributes(swordType);
  }  

  public void setSwordAttributes(SwordTypes swordType) {
    switch (swordType) {
      case DAGGER:
        limitAttackSpeed(12, 20);
        limitAttackRange(0);
        break;
      case SHORT_SWORD:
        limitAttackSpeed(8, 18);
        limitAttackRange(0, 2);
        break;
      case LONG_SWORD:
        limitAttackSpeed(6, 16);
        System.out.println("Test3");
        break;
    }
  }  
}