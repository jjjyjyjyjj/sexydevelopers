package use_case.add_ingredient;

import entity.Fridge;

public class AddIngredientOutputData {
    private final Fridge fridge;
    private final boolean useCaseFailed;

    public AddIngredientOutputData(User user, boolean useCaseFailed) {
        this.fridge = user.getFridge();
        this.useCaseFailed = useCaseFailed;
    }

    public Fridge getFridge() {
        return fridge;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
