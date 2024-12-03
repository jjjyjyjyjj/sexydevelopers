package use_case.add_ingredient;

import entity.Fridge;


public class AddIngredientOutputData {
    private final Fridge fridge;
    private final boolean useCaseFailed;

        this.useCaseFailed = useCaseFailed;
    }

    public Fridge getFridge() {
        return fridge;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
