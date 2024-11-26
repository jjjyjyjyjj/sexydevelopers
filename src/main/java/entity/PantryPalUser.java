package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PantryPalUser implements User {
    @JsonProperty ("username")
    private String username;

    @JsonProperty ("password")
    private String password;

    @JsonProperty ("fridge")
    private Fridge fridge;

    @JsonProperty ("favourited")
    private SavedRecipes favourited;

    @JsonProperty ("savedForLater")
    private SavedRecipes savedForLater;

    @JsonProperty ("recipeHistory")
    private SavedRecipes recipeHistory;

    @JsonProperty ("prepTime")
    private PrepTime prepTime;

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

    public Fridge getFridge() {
        return fridge;
    }

    public SavedRecipes getFavourited() {
        return favourited;
    }

    public SavedRecipes getSavedForLater() {
        return savedForLater;
    }

    public SavedRecipes getTriedRecipes() {
        return recipeHistory;
    }

    public PrepTime getPrepTime() {
        return prepTime;
    }

}
