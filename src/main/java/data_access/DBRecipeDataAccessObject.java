package data_access;

import entity.Recipe;
import entity.User;
import use_case.favourite_recipes.FavouriteRecipesDataAccessInterface;

public class DBRecipeDataAccessObject implements FavouriteRecipesDataAccessInterface {
        public DBRecipeDataAccessObject() {
        }

        public void FavouriteRecipes(Recipe recipe) {
        }

        public boolean existsByRecipe(Recipe recipe, User user) {
            return false;
        }
    }
}
