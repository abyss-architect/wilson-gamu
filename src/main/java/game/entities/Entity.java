package game.entities;
/*
Implemented by: Wilson J. Villegas M.
Last modified: 03/21/2024.

Abstract entity class that every living "entity" in the game will inherit from. An entity will always have a name, an hp value, an mp value, a location in the map, and an inventory to hold items (or no inventory at all).
*/

import game.GameObject;
import game.Tickable;

public abstract class Entity extends GameObject implements Tickable {
  // Class fields.
  private String name;
  private int hp, mp;
  private Inventory inventory;

  protected Entity() { }

  // Class getters
  public String getName() { return this.name; }
  public int getHP() { return this.hp; }
  public int getMP() { return this.mp; }

  // Class setters
  public void setName(String name) { this.name = name; }
  public void setHP(int hp) { this.hp = hp; }
  public void setMP(int mp) { this.mp = mp; }

  // Overriding the toString method to display the entity's hp, and mp.
  @Override
  public String toString() {
    return this.name + " 's HP: " + this.hp + "\n" +
           this.name + " 's MP: " + this.mp + "\n";
  }
}