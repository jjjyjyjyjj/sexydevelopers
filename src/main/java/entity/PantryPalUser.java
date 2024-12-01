package entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = PantryPalUser.class)
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


    public PantryPalUser(String username, String password) {
        this.username = username;
        this.password = password;

        this.fridge = new CommonFridge();
        this.favourited = new FavouritedRecipes();
        this.savedForLater = new SavedForLater();
        this.recipeHistory = new TriedRecipes();
    }

    public PantryPalUser() {}

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

    @Override
    public void setFridge(Fridge fridge) {
        this.fridge = fridge;
    }
}
