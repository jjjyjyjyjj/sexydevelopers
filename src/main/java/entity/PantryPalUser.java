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
    private SavedForLaterRecipes savedForLater;

    @JsonProperty ("recipeHistory")
    private TriedRecipes recipeHistory;

    @JsonProperty ("prepTime")
    private PrepTime prepTime;

    public PantryPalUser() {}

    public PantryPalUser(String username, String password) {
        this.username = username;
        this.password = password;

        this.fridge = new CommonFridge();
        this.favourited = new FavouritedRecipes();
        this.savedForLater = new SavedForLaterRecipes();
        this.recipeHistory = new TriedRecipes();
        this.prepTime = new PrepTime(30);
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

    public SavedForLaterRecipes getSavedForLater() {
        return savedForLater;
    }

    public TriedRecipes getRecipeHistory() {
        return recipeHistory;
    }

    public PrepTime getPrepTime() {
        return prepTime;
    }

}
