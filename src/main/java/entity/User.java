package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty ("username")
    private String username;

    @JsonProperty ("password")
    private String password;

    @JsonProperty ("fridge")
    private Fridge fridge;

    @JsonProperty ("favourited")
    private Favourited favourited;

    @JsonProperty ("savedForLater")
    private SavedForLater savedForLater;

    @JsonProperty ("recipeHistory")
    private RecipeBrowsedHistory recipeHistory;

    @JsonProperty ("prepTime")
    private PrepTime prepTime;

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;

        this.fridge = new Fridge();
        this.favourited = new Favourited();
        this.savedForLater = new SavedForLater();
        this.recipeHistory = new RecipeBrowsedHistory();
        this.prepTime = new PrepTime(30);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Fridge getFridge() {
        return fridge;
    }

    public Favourited getFavourited() {
        return favourited;
    }

    public SavedForLater getSavedForLater() {
        return savedForLater;
    }

    public RecipeBrowsedHistory getRecipeHistory() {
        return recipeHistory;
    }

    public PrepTime getPrepTime() {
        return prepTime;
    }

}
