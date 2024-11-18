package entity;

public class User {
    private String username;
    private String password;

    private Fridge fridge;
    private DietaryPreferences dietaryPreferences;
    private Favourited favourited;
    private SavedForLater savedForLater;
    private RecipeBrowsedHistory recipeHistory;
    private PrepTime prepTime;

    public User(String username, String password) {
        this.username = username;
        this.password = password;

        this.fridge = new Fridge();
        this.dietaryPreferences = new DietaryPreferences();
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

    public DietaryPreferences getDietaryPreferences() {
        return dietaryPreferences;
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

    public String getName() {
        return this.username;
    }

//    private Map<String, Boolean> dietaryPreferences;
//    private Fridge fridge;
//    private int prepTime;
//    private List<Recipe> favouriteRecipes;
//
//    public User(String username, String password, Map<String, Boolean> dietaryPreferences, Fridge fridge, int prepTime, List<Recipe> favoriteRecipes) {
//        this.username = username;
//        this.password = password;
//        this.dietaryPreferences = dietaryPreferences;
//        this.prepTime = this.prepTime;
//        this.fridge = this.fridge;
//        this.favouriteRecipes = new ArrayList<>();
//    }
//
//    public ArrayList getFavouriteRecipes() {
//        return (ArrayList) this.favouriteRecipes;
//    }
}
