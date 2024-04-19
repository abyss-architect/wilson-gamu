package game.entities.items;

import game.GameObject;
import game.utils.SpecialString;

public abstract class Item extends GameObject {
  // Class fields.
  private SpecialString itemName = new SpecialString();
  private SpecialString itemDescription = new SpecialString();

  // Default constructor for inheritance purposes.
  protected Item() { }
  
  // Constructor for initializing the class fields.
  protected Item(SpecialString itemName, SpecialString itemDescription) {
    this.itemName = itemName;
    this.itemDescription = itemDescription;
  }

  // Overriding the toString method to display the item's name.
  @Override
  public String toString() {
    return this.itemName + "\n" + this.itemDescription;
  }

  // Abstract Method for displaying the item's name & description. Output to console should
  // be handled by the UI class.
  public String displayItem() {
    return this.toString();
  }

  // Class setter
  public void setItem(SpecialString itemName, SpecialString itemDescription) {
    this.itemName = itemName;
    this.itemDescription = itemDescription;
  }
}