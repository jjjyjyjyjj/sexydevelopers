package entity;

public class CommonFridgeFactory implements FridgeFactory {
    /**
     * Creates a new CommonFridge.
     * @return the new fridge
     */
    public CommonFridge create() {
        return new CommonFridge();
    }
}
