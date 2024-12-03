package usecase.remove_ingredient;

import entity.Fridge;

public class RemoveIngredientOutputData {
    private final Fridge fridge;
    private final boolean useCaseFailed;

    public RemoveIngredientOutputData(Fridge fridge, boolean useCaseFailed) {
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