package entity;

public class CommonFridgeFactory implements FridgeFactory {
    /**
     * Creates a new CommonFridge.
     * @return the new fridge
     */
    @Override
    public CommonFridge create() {
        return new CommonFridge();
    }
}
