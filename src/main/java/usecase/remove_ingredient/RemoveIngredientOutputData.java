package usecase.remove_ingredient;

import entity.Fridge;
import entity.User;

public class RemoveIngredientOutputData {
    private final Fridge fridge;
    private final boolean useCaseFailed;

    public RemoveIngredientOutputData(User user, boolean useCaseFailed) {
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
