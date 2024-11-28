package use_case.try_from_saved;

import entity.Recipe;

public class TryFromSavedInputData {
    private Recipe recipe;

    public TryFromSavedInputData(Recipe recipe){
        this.recipe = recipe;
    }

    Recipe getRecipe(){
        return this.recipe;
    }
}
