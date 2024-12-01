package use_case.recipe_recommender;

import entity.Recipe;
import entity.SavedRecipes;
import entity.User;

import java.util.ArrayList;
import java.util.List;

public class RecipeRecOutputData {
    //private final ArrayList<Recipe> recRecipes;
    private final boolean useCaseFailed;

    public RecipeRecOutputData(User user, boolean useCaseFailed) {
        //this.recRecipes = user.getFavourited();
        this.useCaseFailed = useCaseFailed;
    }

    //public ArrayList<Recipe> getrecRecipes() {
    // return recRecipes;


    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }

    public List<Recipe> getRecommendedRecipes() {
        return List.of();
    }
}
