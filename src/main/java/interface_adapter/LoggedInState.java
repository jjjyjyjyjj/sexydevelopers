package interface_adapter;

import entity.*;

/**
 * The State information representing the logged-in user.
 */
public class LoggedInState {
    private String username = "";
    private String password = "";
    private String passwordError;
    private CommonFridge fridge;
    private FavouritedRecipes favRecipes;
    private TriedRecipes triedRecipes;
    private SavedForLaterRecipes savedforlaterRecipes;

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

    public CommonFridge getFridge() { return fridge;}

    public void setFridge(CommonFridge fridge) { this.fridge = fridge;}

    public FavouritedRecipes getFavRecipes() { return favRecipes;}

    public void setFavRecipes(FavouritedRecipes favRecipes) {this.favRecipes = favRecipes;}

    public TriedRecipes getTriedRecipes() { return triedRecipes;}

    public void setTriedRecipes(TriedRecipes triedRecipes) {
        this.triedRecipes = triedRecipes;
    }

    public SavedForLaterRecipes getSavedforlaterRecipes() {
        return savedforlaterRecipes;
    }

    public void setSavedforlaterRecipes(SavedForLaterRecipes savedforlaterRecipes) {
        this.savedforlaterRecipes = savedforlaterRecipes;
    }
}
