package entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Our users.
 */
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

    @JsonProperty ("triedRecipes")
    private SavedRecipes triedRecipes;

    public PantryPalUser(String username, String password) {
        this.username = username;
        this.password = password;

        this.fridge = new CommonFridge();
        this.favourited = new FavouritedRecipes();
        this.savedForLater = new SavedForLater();
        this.triedRecipes = new TriedRecipes();
    }

    public PantryPalUser() {

    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Returns current user's fridge.
     * @return user's fridge
     */
    public Fridge getFridge() {
        return fridge;
    }

    @Override
    public void setFridge(Fridge fridge) {
        this.fridge = fridge;
    }

    /**
     * Returns current user's favourited recipes.
     * @return user's favourited recipes
     */
    public SavedRecipes getFavourited() {
        return favourited;
    }

    /**
     * Returns current user's saved recipes.
     * @return user's saved recipes
     */
    public SavedRecipes getSavedForLater() {
        return savedForLater;
    }

    /**
     * Returns current user's tried recipes.
     * @return user's tried recipes
     */
    public SavedRecipes getTriedRecipes() {
        return triedRecipes;
    }
}
