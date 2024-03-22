/*
Implemented by: Wilson J. Villegas M.
Last modified: 03/21/2024.

Abstract entity class that every living "entity" in the game will inherit from. An entity will always have a name, an hp value, an mp value, a position in the map, and an inventory to hold items (or no inventory at all).
*/

public abstract class Entity {
  // Class fields.
  private String name;
  private int hp, mp;
  private Position position;
  private Inventory inventory;

  // In case of an NPC, use this constructor
  public Entity(String name, Position position, Inventory inventory) {
    this.name = name;
    this.position = position;
    this.inventory = inventory;
  }

  // In case an entity cannot use magic, use this constructor
  public Entity(String name, int hp, Position position, Inventory inventory) {
    this(name, position, inventory);
    this.position = position;
  }

  // Constructor for specifying each of the fields (mainly for the playable character.)
  public Entity(String name, int hp, int mp, Position position, Inventory inventory) {
    this(name, hp, position, inventory);
    this.mp = mp;
  }

  // Class getters
  public String getName() { return this.name; }
  public int getHP() { return this.hp; }
  public int getMP() { return this.mp; }
  public Position getPosition() { return this.position; }

  // Class setters
  public void setName(String name) { this.name = name; }
  public void setHP(int hp) { this.hp = hp; }
  public void setMP(int mp) { this.mp = mp; }
  public void setPosition(Position position) { this.position = position; }

  // Overriding the toString method to display the entity's hp, and mp.
  @Override
  public String toString() {
    return this.name + " 's HP: " + this.hp + "\n" +
           this.name + " 's MP: " + this.mp + "\n";
  }

}