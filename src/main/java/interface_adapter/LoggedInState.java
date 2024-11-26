package interface_adapter;

import entity.*;

/**
 * The State information representing the logged-in user.
 */
public class LoggedInState {
    private String username = "";
    private String password = "";
    private String passwordError;
    private Fridge fridge;
    private SavedRecipes favRecipes;
    private TriedRecipes triedRecipes;
    private SavedRecipes savedforlaterRecipes;

    public LoggedInState(LoggedInState copy) {
        username = copy.username;
        password = copy.password;
        passwordError = copy.passwordError;
        fridge = copy.fridge;
        favRecipes = copy.favRecipes;
        triedRecipes = copy.triedRecipes;
        savedforlaterRecipes = copy.savedforlaterRecipes;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public LoggedInState() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getPassword() {
        return password;
    }

    public Fridge getFridge() { return fridge;}

    public void setFridge(Fridge fridge) { this.fridge = fridge;}

    public SavedRecipes getFavRecipes() { return favRecipes;}

    public void setFavRecipes(SavedRecipes favRecipes) {this.favRecipes = favRecipes;}

    public TriedRecipes getTriedRecipes() { return triedRecipes;}

    public void setTriedRecipes(TriedRecipes triedRecipes) {
        this.triedRecipes = triedRecipes;
    }

    public SavedRecipes getSavedforlaterRecipes() {
        return savedforlaterRecipes;
    }

    public void setSavedforlaterRecipes(SavedRecipes savedforlaterRecipes) {
        this.savedforlaterRecipes = savedforlaterRecipes;
    }
}
