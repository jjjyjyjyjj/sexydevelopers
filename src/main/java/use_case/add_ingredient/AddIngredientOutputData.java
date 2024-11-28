package use_case.add_ingredient;

import entity.Fridge;
import entity.User;

public class AddIngredientOutputData {
    private final Fridge fridge;
    private final boolean useCaseFailed;

    public AddIngredientOutputData(Fridge fridge, boolean useCaseFailed) {
        this.fridge = fridge;
        this.useCaseFailed = useCaseFailed;
    }

    public Fridge getFridge() {
        return fridge;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
