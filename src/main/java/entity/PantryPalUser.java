package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PantryPalUser implements User {
    @JsonProperty ("username")
    private String username;

    @JsonProperty ("password")
    private String password;

    @JsonProperty ("fridge")
    private CommonFridge fridge;

    @JsonProperty ("favourited")
    private FavouritedRecipes favourited;

    @JsonProperty ("savedForLater")
    private SavedForLater savedForLater;

    @JsonProperty ("savedRecipeFactory")
    private SavedRecipeFactory savedRecipeFactory;
    private TriedRecipes recipeHistory;

    public PantryPalUser(String username, String password) {
        this.username = username;
        this.password = password;
   
        this.fridge = new CommonFridge();
        this.favourited = new FavouritedRecipes();
        this.savedForLater = new SavedForLater();
        this.recipeHistory = new TriedRecipes();
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public CommonFridge getFridge() {
        return fridge;
    }

    public FavouritedRecipes getFavourited() {
        return favourited;
    }

    public SavedForLater getSavedForLater() {
        return savedForLater;
    }

    public TriedRecipes getTriedRecipes() {
        return recipeHistory;
    }

}
