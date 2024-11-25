package use_case.favouriterecipes;

import data_access.FileUserDataAccessObject;
import entity.*;
import org.junit.jupiter.api.Test;
import use_case.favourite_recipes.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class FavouriteRecipesInteractorTest {
    UserFactory userfactory = new CommonUserFactory();
    RecipeFactory recipefactory = new RecipeFactory();
    IngredientFactory ingredientFactory = new IngredientFactory();

    @Test
    void successTest() throws IOException {
        User user = userfactory.create();
        List<Ingredient> omlette = new ArrayList<>();
        Ingredient bread = ingredientFactory.create("bread crumbs", "18879","", "Pasta and Rice");
        Ingredient milk = ingredientFactory.create("milk", "1077","", "Milk, Eggs, Other Dairy");
        Ingredient egg = ingredientFactory.create("Eggs", "1123","", "Milk, Eggs, Other Dairy");
        omlette.add(egg);
        omlette.add(milk);
        omlette.add(bread);

        Recipe toFavRecipe = recipefactory.create("Bread Omlette","635964", omlette,
                "https://img.spoonacular.com/recipes/635964-312x231.jpg" );
        FavouriteRecipesInputData inputData = new FavouriteRecipesInputData(toFavRecipe, user);
        FavouriteRecipesDataAccessInterface userRepository = new FileUserDataAccessObject("users.json");

        // This creates a successPresenter that tests whether the test case is as we expect.
        FavouriteRecipesOutputBoundary successPresenter = new FavouriteRecipesOutputBoundary() {
            @Override
            public void prepareSuccessView(FavouriteRecipesOutputData favrecipes) {
                // 2 things to check: the output data is correct, and the user has been created in the DAO.
                assertEquals("", favrecipes.getfavRecipes());
                assertTrue(userRepository.existsByRecipe(toFavRecipe));
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };

        FavouriteRecipesInputBoundary interactor = new FavouriteRecipesInteractor(userRepository, successPresenter,
                toFavRecipe, user);
        interactor.execute(inputData);
    }
}
