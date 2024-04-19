package game.entities.items.potions;
import game.entities.Entity;
import game.entities.items.Item;
import game.entities.items.Usable;
import game.utils.SpecialString;

public abstract class Potion extends Item implements Usable {
    // Class fields.

    // Default constructor for inheritance purposes.
    protected Potion() {
        super();
    }
    
    // Constructor for initializing the class fields.
    protected Potion(SpecialString itemName, SpecialString itemDescription) {
        super(itemName, itemDescription);
    }
    
    public void use(Entity user, Entity target) {
        use(user);
    }
}