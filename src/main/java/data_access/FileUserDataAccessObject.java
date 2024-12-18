package data_access;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import entity.Fridge;
import entity.Ingredient;
import entity.Recipe;
import entity.User;
import usecase.add_ingredient.AddIngredientDataAccessInterface;
import usecase.add_to_fav_recipes.FavouriteRecipesDataAccessInterface;
import usecase.change_password.ChangePasswordUserDataAccessInterface;
import usecase.login.LoginUserDataAccessInterface;
import usecase.logout.LogoutUserDataAccessInterface;
import usecase.recipe_recommender.RecipeRecUserDataAccessInterface;
import usecase.remove_from_fav_recipes.RemoveFavRecipeDataAccessInterface;
import usecase.remove_ingredient.RemoveIngredientDataAccessInterface;
import usecase.save_for_later.SaveForLaterUserDataAccessInterface;
import usecase.signup.SignupUserDataAccessInterface;

/**
 * DAO for user data implemented using a JSON file to persist the data.
 */
public class FileUserDataAccessObject implements SignupUserDataAccessInterface,
        LoginUserDataAccessInterface,
        ChangePasswordUserDataAccessInterface,
        LogoutUserDataAccessInterface,
        RemoveFavRecipeDataAccessInterface,
        SaveForLaterUserDataAccessInterface,
        RecipeRecUserDataAccessInterface,
        FavouriteRecipesDataAccessInterface,
        AddIngredientDataAccessInterface,
        RemoveIngredientDataAccessInterface {
    private final File jsonFile;
    private final Map<String, User> accounts = new HashMap<>();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private String currentUsername;

    public FileUserDataAccessObject(String jsonPath) throws IOException {
        this.jsonFile = new File(jsonPath);

        if (jsonFile.exists() && jsonFile.length() > 0) {
            // Load existing users
            List<User> users = loadUsers();
            for (User user : users) {
                accounts.put(user.getUsername(), user);
            }
        }
        else {
            // Create the file if it doesn't exist
            if (jsonFile.createNewFile()) {
                try (FileWriter writer = new FileWriter(jsonFile)) {
                    // Write an empty JSON array
                    writer.write("[]");
                }
                System.out.println("users.json created successfully.");
            }
            else {
                throw new IOException("Failed to create users.json.");
            }
        }
    }

    private List<User> loadUsers() throws IOException {
        CollectionType listType = objectMapper.getTypeFactory()
                .constructCollectionType(List.class, User.class);
        return objectMapper.readValue(jsonFile, listType);
    }

    private void save() {
        try {
            objectMapper.writeValue(jsonFile, accounts.values());
        }
        catch (IOException e) {
            throw new RuntimeException("Failed to save user data", e);
        }
    }

    @Override
    public User get(String username) {
        return accounts.get(username);
    }

    @Override
    public void setCurrentUsername(String name) {
        this.currentUsername = name;
    }

    @Override
    public String getCurrentUsername() {
        return this.currentUsername;
    }

    @Override
    public boolean existsByName(String username) {
        return accounts.containsKey(username);
    }

    @Override
    public void save(User user) {
        accounts.put(user.getUsername(), user);
        // Save the updated accounts to the JSON file
        save();
    }

    @Override
    public void changePassword(User user) {
        if (user instanceof User) {
            User pantryUser = user;
            accounts.put(pantryUser.getUsername(), pantryUser);
            save();
        }
        else {
            throw new IllegalArgumentException("Unsupported user type.");
        }
    }

    /**
     * Updates the system to update this user's favourite recipes.
     *
     * @param user the user whose favourite recipes list is to be updated
     * @param recipe the recipe that is to be added to favourite recipes
     */

    public void saveFavouriteRecipes(User user, Recipe recipe) {
        user.getFavourited().addRecipe(recipe);
        save();
    }

    /**
     * Updates the system to update this user's favourite recipes.
     *
     * @param user the user whose favourite recipes list is to be updated
     * @param recipe the recipe that is to be removed from favourite recipes
     */
    @Override
    public void updateFavouriteRecipes(User user, Recipe recipe) {
        user.getFavourited().removeRecipe(recipe);
        save();
    }

    @Override
    public void updateSavedRecipes(User user, Recipe recipe) {
        user.getSavedForLater().removeRecipe(recipe);
        save();
    }

    @Override
    public boolean saveRecipeForUser(String userId, String recipeId) {
        return false;
    }

    @Override
    public User getUserById(String userId) {
        return null;
    }

    @Override
    public void updateUserSavedRecipes(User user) {

    }

    @Override
    public boolean existsByRecipe(Recipe toSavedRecipe, User user) {
        return false;
    }

    /**
     * Gets the Ingredients in the User's fridge.
     *
     * @param user Current user
     * @return List of Ingredient user has
     */
    @Override
    public ArrayList<Ingredient> getFridgeIngredients(User user) {
        return user.getFridge().getIngredients();
    }

    @Override
    public void addIngredient(User user, Ingredient ingredient) {

        user.getFridge().addIngredient(ingredient);
        save();
    }

    @Override
    public void removeIngredient(User user, String name) {
        Fridge fridge = user.getFridge();
        fridge.removeIngredient(name);
    }

    @Override
    public boolean existsByIngredient(Ingredient ingredient, User user) {
        User toCheck = accounts.get(user.getUsername());
        Fridge fridge = toCheck.getFridge();
        return fridge.hasIngredient(ingredient);
    }
}
