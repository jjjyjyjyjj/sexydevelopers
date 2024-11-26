package interface_adapter.favourite_recipes;

import java.util.ArrayList;
import java.util.List;

public class FavouriteRecipesState {
    private String username = "" ;
    private String errorMessage;
    private List<String> favRecipes = new ArrayList<>();

    public String getUsername() {
            return username;
        }
        public String getErrorMessage() {
            return errorMessage;
        }

        public List<String> getfavRecipes() {
            return favRecipes;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        public void setFavRecipes(List<String> triedRecipes) {
            this.favRecipes = favRecipes;
        }
    }

