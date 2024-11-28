package use_case.change_quantity;

import entity.Ingredient;
import entity.User;

public class ChangeQuantityOutputData {
    private final Ingredient ingredient;
    private final boolean useCaseFailed;

    public ChangeQuantityOutputData(Ingredient ingredient, boolean useCaseFailed) {
        this.ingredient = ingredient;
        this.useCaseFailed = useCaseFailed;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
