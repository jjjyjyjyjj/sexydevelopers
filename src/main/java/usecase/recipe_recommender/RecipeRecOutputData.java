package usecase.recipe_recommender;

import entity.Recipe;

/**
 * Output Data for the Recipe Recommender Use Case.
 */
public class RecipeRecOutputData {
    private final Recipe nextRecipe;
    private final boolean useCaseFailed;

    public RecipeRecOutputData(Recipe nextRecipe, boolean useCaseFailed) {
        this.nextRecipe = nextRecipe;
        this.useCaseFailed = useCaseFailed;
    }

    /**
     * Returns the recommended recipe.
     * @return recommended recipe
     */
    public Recipe getRecommendedRecipe() {
        return this.nextRecipe;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }

}
