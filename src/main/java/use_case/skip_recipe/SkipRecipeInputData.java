package use_case.skip_recipe;

import entity.Recipe;

public class SkipRecipeInputData {
    private Recipe recipe;

    public SkipRecipeInputData(Recipe recipe){
        this.recipe = recipe;
    }

    Recipe getRecipe(){
        return this.recipe;
    }
}
