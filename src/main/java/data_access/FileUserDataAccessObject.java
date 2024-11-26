package data_access;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import entity.*;
import use_case.change_password.ChangePasswordUserDataAccessInterface;
import use_case.favourite_recipes.FavouriteRecipesDataAccessInterface;
import use_case.login.LoginUserDataAccessInterface;
import use_case.logout.LogoutUserDataAccessInterface;
import use_case.signup.SignupUserDataAccessInterface;

import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DAO for user data implemented using a JSON file to persist the data.
 */
public class FileUserDataAccessObject implements SignupUserDataAccessInterface,
        LoginUserDataAccessInterface,
        ChangePasswordUserDataAccessInterface,
        LogoutUserDataAccessInterface,
        FavouriteRecipesDataAccessInterface {

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
        } else {
            // Create the file if it doesn't exist
            if (jsonFile.createNewFile()) {
                try (FileWriter writer = new FileWriter(jsonFile)) {
                    writer.write("[]"); // Write an empty JSON array
                }
                System.out.println("users.json created successfully.");
            } else {
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
        } catch (IOException e) {
            throw new RuntimeException("Failed to save user data", e);
        }
    }

    @Override
    public void save(User user) {
        accounts.put(user.getUsername(), user);
        save();
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
        if (user instanceof User) {
            User pantryUser = user;
            accounts.put(pantryUser.getUsername(), pantryUser);
            save(); // Save the updated accounts to the JSON file
        } else {
            throw new IllegalArgumentException("Unsupported user type.");
        }
    }

    @Override
    public void changePassword(User user) {
        if (user instanceof User) {
            User pantryUser = user;
            accounts.put(pantryUser.getUsername(), pantryUser);
            save();
        } else {
            throw new IllegalArgumentException("Unsupported user type.");
        }
    }

    /**
     * Updates the system to update this user's favourite recipes.
     *
     * @param user the user whose favourite recipes list is to be updated
     * @param recipe the recipe that is to be added to favourite recipes
     */
    @Override
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
}
