package use_case.favouriterecipes;

import data_access.FileUserDataAccessObject;
import entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.favourite_recipes.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FavouriteRecipesInteractorTest {
    private File testFile;
    private CommonRecipe testRecipe;
    PantryPalUserFactory userFactory = new PantryPalUserFactory();
    CommonRecipeFactory recipeFactory = new CommonRecipeFactory();
    CommonIngredientFactory ingredientFactory = new CommonIngredientFactory();


    @BeforeEach
    void setUp() throws IOException {
        // Set up a test JSON file for the FileUserDataAccessObject
        testFile = new File("test_users.json");

        // Creates a new recipe
        List<Ingredient> omlette = new ArrayList<>();
        Ingredient bread = ingredientFactory.create("bread crumbs", "18879", "", "Pasta and Rice");
        Ingredient milk = ingredientFactory.create("milk", "1077", "", "Milk, Eggs, Other Dairy");
        Ingredient egg = ingredientFactory.create("Eggs", "1123", "", "Milk, Eggs, Other Dairy");
        omlette.add(egg);
        omlette.add(milk);
        omlette.add(bread);

        testRecipe = (CommonRecipe) recipeFactory.create("Bread Omlette", 635964, omlette,
                "https://img.spoonacular.com/recipes/635964-312x231.jpg",
                "https://www.foodista.com/recipe/2M6MVKZT/bread-omlette");
    }

    @Test
    void successAddRecipeTest() throws IOException {
        FavouriteRecipesDataAccessInterface userRepository = new FileUserDataAccessObject(testFile.getPath());
        CommonRecipe toFavRecipe = testRecipe;

        // Creates a new user
        PantryPalUser user = userFactory.create("lala", "password");
        userRepository.save(user);

        //For a success test, we need to add the recipe to the favourite recipe list.
        FavouriteRecipesInputData inputData = new FavouriteRecipesInputData(toFavRecipe, user);
        user.getFavourited().addRecipe(toFavRecipe);
        userRepository.saveFavouriteRecipes(user, toFavRecipe);

        // This creates a successPresenter that tests whether the test case is as we expect.
        FavouriteRecipesOutputBoundary successPresenter = new FavouriteRecipesOutputBoundary() {
            @Override
            public void prepareSuccessView(FavouriteRecipesOutputData favrecipes) {
                // 2 things to check: the output data is correct, and the user has been created in the DAO.
                List<Recipe> favouriteRecipe = new ArrayList<>();
                favouriteRecipe.add(toFavRecipe);

                assertEquals(favouriteRecipe, favrecipes.getfavRecipes());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };

        FavouriteRecipesInputBoundary interactor = new FavouriteRecipesInteractor(userRepository, successPresenter);
        interactor.execute(inputData);
    }

    void successRemoveRecipeTest() throws IOException {
        FavouriteRecipesDataAccessInterface userRepository = new FileUserDataAccessObject(testFile.getPath());
        CommonRecipe toRemoveRecipe = testRecipe;

        // Creates a new user
        PantryPalUser user1 = userFactory.create("rara", "passworD");
        userRepository.save(user1);
        user1.getFavourited().addRecipe(toRemoveRecipe);

        //For a success test, we need to add the recipe to the favourite recipe list.
        FavouriteRecipesInputData inputData = new FavouriteRecipesInputData(toRemoveRecipe, user1);
        user1.getFavourited().removeRecipe(toRemoveRecipe);
        userRepository.updateFavouriteRecipes(user1, toRemoveRecipe);

        // This creates a successPresenter that tests whether the test case is as we expect.
        FavouriteRecipesOutputBoundary successPresenter = new FavouriteRecipesOutputBoundary() {
            @Override
            public void prepareSuccessView(FavouriteRecipesOutputData favrecipes) {
                // 2 things to check: the output data is correct, and the user has been created in the DAO.
                List<Recipe> favouriteRecipe = new ArrayList<>();

                assertEquals(favouriteRecipe, favrecipes.getfavRecipes());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };

        FavouriteRecipesInputBoundary interactor = new FavouriteRecipesInteractor(userRepository, successPresenter);
        interactor.remove(inputData, toRemoveRecipe);
    }
}
