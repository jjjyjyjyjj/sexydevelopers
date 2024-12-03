package use_case.remove_from_fav_recipes;

import data_access.FileUserDataAccessObject;
import entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class RemoveFavRecipeInteractorTest {
    private File testFile;
    private Recipe testRecipe;
    UserFactory userFactory = new PantryPalUserFactory();
    RecipeFactory recipeFactory = new CommonRecipeFactory();
    IngredientFactory ingredientFactory = new CommonIngredientFactory();


    @BeforeEach
    void setUp() throws IOException {
        // Set up a test JSON file for the FileUserDataAccessObject
        testFile = new File("test_users.json");

        // Creates a new recipe
        List<Ingredient> omlette = new ArrayList<>();
        Ingredient bread = ingredientFactory.create("bread crumbs", "", 1);
        Ingredient milk = ingredientFactory.create("milk",  "", 1);
        Ingredient egg = ingredientFactory.create("Eggs",  "", 1);
        omlette.add(egg);
        omlette.add(milk);
        omlette.add(bread);

        testRecipe = (Recipe) recipeFactory.create("Bread Omlette", 635964, omlette,
                "https://img.spoonacular.com/recipes/635964-312x231.jpg",
                "https://www.foodista.com/recipe/2M6MVKZT/bread-omlette");
    }

    @Test
    void successRemoveRecipeTest() throws IOException {
        RemoveFavRecipeDataAccessInterface userRepository = new FileUserDataAccessObject(testFile.getPath());
        Recipe toRemoveRecipe = testRecipe;

        // Creates a new user
        User user1 = userFactory.create("rara", "passworD");
        userRepository.save(user1);
        user1.getFavourited().addRecipe(toRemoveRecipe);

        //For a success test, we need to remove the target recipe from the list.
        RemoveFavRecipeInputData inputData = new RemoveFavRecipeInputData(toRemoveRecipe, user1);
        user1.getFavourited().removeRecipe(toRemoveRecipe);
        userRepository.updateFavouriteRecipes(user1, toRemoveRecipe);

        // This creates a successPresenter that tests whether the test case is as we expect.
        RemoveFavRecipeOutputBoundary successPresenter = new RemoveFavRecipeOutputBoundary() {
            @Override
            public void prepareSuccessView(RemoveFavRecipeOutputData favrecipes) {
                // 2 things to check: the output data is correct, and the user has been created in the DAO.
                List<Recipe> favouriteRecipe = new ArrayList<>();

                assertEquals(favouriteRecipe, favrecipes.getfavRecipes());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };

        RemoveFavRecipeInputBoundary interactor = new RemoveFavRecipeInteractor(userRepository, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    void failureRecipeDoesNotExistTest() throws IOException {
        RemoveFavRecipeDataAccessInterface userRepository = new FileUserDataAccessObject(testFile.getPath());
        Recipe toRemoveRecipe = testRecipe;

        // Creates a new user
        User user2 = userFactory.create("lala", "pa55word");
        userRepository.save(user2);

        RemoveFavRecipeInputData inputData = new RemoveFavRecipeInputData(toRemoveRecipe, user2);

        // This creates a successPresenter that tests whether the test case is as we expect.
        RemoveFavRecipeOutputBoundary failurePresenter = new RemoveFavRecipeOutputBoundary() {
            @Override
            public void prepareSuccessView(RemoveFavRecipeOutputData favrecipes) {
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Recipe does not exist.", error);
            }
        };

        RemoveFavRecipeInputBoundary interactor = new RemoveFavRecipeInteractor(userRepository, failurePresenter);
        interactor.execute(inputData);
    }
}
