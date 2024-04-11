package game.entities.items;

import game.GameObject;

public abstract class Item extends GameObject {
  // Class fields.
  private String itemName, itemDescription;

  // Default constructor for inheritance purposes.
  protected Item() {

    this.itemName = "";
    this.itemDescription = "";
  }
  
  // Constructor for initializing the class fields.
  protected Item(String itemName, String itemDescription) {
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
  };
}