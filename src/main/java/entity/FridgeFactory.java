package entity;

/**
 * Factory for creating fridges.
 */
public interface FridgeFactory {

    /**
     * Creates a new Fridge.
     * @return the new fridge.
     */
    Fridge create();
}
