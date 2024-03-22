public abstract class Item {
  // Class fields.
  private String itemName, itemDescription;

  // Default constructor for inheritance purposes.
  public Item() {
    this.itemName = "";
    this.itemDescription = "";
  }
  
  // Constructor for initializing the class fields.
  public Item(String itemName, String itemDescription) {
    this.itemName = itemName;
    this.itemDescription = itemDescription;
  }

  // Overriding the toString method to display the item's name.
  @Override
  public String toString() {
    return this.itemName;
  }

  // Method for displaying the item's name & description. Output to console should
  // be handled by the UI class.
  public String displayItem() {
    return this.itemName + ":\n" + this.itemDescription;
  }
}