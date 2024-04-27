package game;

import java.util.ArrayList;

public class TickManager {
    private static ArrayList<Tickable> tickables = new ArrayList<>();

    public static void register(Tickable tickable) {
        tickables.add(tickable);
    }

    public static void unregister(Tickable tickable) {
        tickables.remove(tickable);
    }

    public static void runTicks() {
        for (Tickable tickable : tickables) {
            tickable.tick();
        }
    }
}
