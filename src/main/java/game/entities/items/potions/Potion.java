package game.entities.items.potions;
import game.entities.Entity;
import game.entities.items.Item;
import game.entities.items.Usable;

public abstract class Potion extends Item implements Usable {
    // Class fields.

    // Default constructor for inheritance purposes.
    protected Potion() {
        super("", "");
    }
    
    // Constructor for initializing the class fields.
    protected Potion(String itemName, String itemDescription) {
        super(itemName, itemDescription);
    }
    
    public void use(Entity user, Entity target) {
        use(user);
    }
}