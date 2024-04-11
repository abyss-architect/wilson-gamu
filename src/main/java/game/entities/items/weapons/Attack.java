package game.entities.items.weapons;

import game.entities.Entity;

public interface Attack {
    void useAttack(Entity receiver);
    void useAttack(Entity receiver, Entity user);
}
