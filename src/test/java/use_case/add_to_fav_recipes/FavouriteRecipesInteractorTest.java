package use_case.add_to_fav_recipes;

import data_access.FileUserDataAccessObject;
import entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FavouriteRecipesInteractorTest {
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
        Ingredient milk = ingredientFactory.create("milk", "", 1);
        Ingredient egg = ingredientFactory.create("Eggs",  "", 1);
        
        omlette.add(egg);
        omlette.add(milk);
        omlette.add(bread);

        testRecipe = recipeFactory.create("Bread Omlette", 635964, omlette,
                "https://img.spoonacular.com/recipes/635964-312x231.jpg",
                "https://www.foodista.com/recipe/2M6MVKZT/bread-omlette");
    }
  
   @Test
    void successAddRecipeTest() throws IOException {
        FavouriteRecipesDataAccessInterface userRepository = new FileUserDataAccessObject(testFile.getPath());
        Recipe toFavRecipe = testRecipe;

        // Creates a new user
        User user = userFactory.create("lala", "password");
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


}
