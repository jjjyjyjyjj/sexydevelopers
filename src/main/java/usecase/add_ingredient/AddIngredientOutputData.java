package usecase.add_ingredient;

import entity.Fridge;
import entity.User;

/**
 * The output data for Add Ingredient Use Case.
 */
public class AddIngredientOutputData {
    private final Fridge fridge;
    private final boolean useCaseFailed;

    public AddIngredientOutputData(User user, boolean useCaseFailed) {
        this.fridge = user.getFridge();
        this.useCaseFailed = useCaseFailed;
    }

    /**
     * Returns Fridge.
     * @return fridge
     */
    public Fridge getFridge() {
        return fridge;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
