package usecase.recipe_recommender;

import entity.Recipe;

public class RecipeRecOutputData {
    private final Recipe nextRecipe;
    private final boolean useCaseFailed;

    public RecipeRecOutputData(Recipe nextRecipe, boolean useCaseFailed) {
        this.nextRecipe = nextRecipe;
        this.useCaseFailed = useCaseFailed;
    }

    public Recipe getRecommendedRecipe() {
        return this.nextRecipe;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }

}
