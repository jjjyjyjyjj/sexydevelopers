package use_case.triedRecipes;

import data_access.FileUserDataAccessObject;
import entity.*;
import interfaceadapter.triedRecipes.TriedRecipesViewModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for TriedRecipesInteractor.
 */
class TriedRecipesInteractorTest {

    private FileUserDataAccessObject userRepository;
    private TriedRecipesInteractor interactor;
    private File testFile;

    @BeforeEach
    void setUp() throws IOException {
        // Set up a test JSON file for the FileUserDataAccessObject
        testFile = new File("test_users.json");
        userRepository = new FileUserDataAccessObject(testFile.getPath());
        UserFactory userFactory = new PantryPalUserFactory();

        // Add a user to the repository
        User user = userFactory.create("testUser", "password");
        userRepository.save(user);

        // Initialize the interactor
        TriedRecipesViewModel viewModel = new TriedRecipesViewModel();
        interactor = new TriedRecipesInteractor(userRepository, viewModel);
    }

    @AfterEach
    void tearDown() {
        // Delete the test JSON file after each test
        if (testFile.exists()) {
            testFile.delete();
        }
    }

    @Test
    void addRecipeToTriedRecipesSuccessTest() {
        // Arrange
        RecipeFactory recipeFactory = new CommonRecipeFactory();
        Recipe recipe = recipeFactory.create("Pasta", 1, List.of(), "image.png", "recipe_link");

        // Act
        interactor.addRecipeToTriedRecipes("testUser", recipe);

        // Assert
        User user = userRepository.get("testUser");
        assertNotNull(user);
        assertEquals(1, user.getTriedRecipes().getRecipes().size());
        assertEquals("Pasta", user.getTriedRecipes().getRecipes().get(0).getName());
    }

    @Test
    void addRecipeToTriedRecipesUserNotFoundTest() {
        // Arrange
        RecipeFactory recipeFactory = new CommonRecipeFactory();
        Recipe recipe = recipeFactory.create("Pasta", 1, List.of(), "image.png", "recipe_link");

        // Act
        interactor.addRecipeToTriedRecipes("nonExistentUser", recipe);

        // Assert
        User user = userRepository.get("nonExistentUser");
        assertNull(user);
    }

    @Test
    void getTriedRecipesSuccessTest() {
        // Arrange
        RecipeFactory recipeFactory = new CommonRecipeFactory();
        Recipe recipe1 = recipeFactory.create("Pasta", 1, List.of(), "image1.png", "recipe_link1");
        Recipe recipe2 = recipeFactory.create("Pizza", 2, List.of(), "image2.png", "recipe_link2");
        interactor.addRecipeToTriedRecipes("testUser", recipe1);
        interactor.addRecipeToTriedRecipes("testUser", recipe2);

        // Act & Assert
        interactor.getTriedRecipes("testUser", recipes -> {
            assertEquals(2, recipes.size());
            assertEquals("Pasta", recipes.get(0).getName());
            assertEquals("Pizza", recipes.get(1).getName());
        });
    }

    @Test
    void getTriedRecipesUserNotFoundTest() {
        // Act & Assert
        interactor.getTriedRecipes("nonExistentUser", recipes -> {
            assertEquals(0, recipes.size());
        });
    }
}
