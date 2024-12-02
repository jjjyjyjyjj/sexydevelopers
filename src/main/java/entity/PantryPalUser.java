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
    private CommonFridge fridge;

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

    public PantryPalUser() {}

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

    @Override
    public void setFridge(Fridge fridge) {

    }

    @Override
    public void setFridge(CommonFridge fridge) {
        this.fridge = fridge;
    }

    public SavedRecipes getFavourited() {
        return favourited;
    }

    public SavedRecipes getSavedForLater() {
        return savedForLater;
    }

    public SavedRecipes getTriedRecipes() {
        return triedRecipes;
    }
}
