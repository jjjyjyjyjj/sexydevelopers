package use_case.saveforlater;

import api.getRecipeInformation;
import data_access.FileUserDataAccessObject;
import entity.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SaveForLaterInteractorTest {
    UserFactory userfactory = new PantryPalUserFactory();
    RecipeFactory recipefactory = new CommonRecipeFactory();
    IngredientFactory ingredientFactory = new CommonIngredientFactory();

    @Test
    void successTest() throws IOException {

        // Creating ingredients list
        List<Ingredient> bananaChocPudding = new ArrayList<>();
        Ingredient avocado = ingredientFactory.create("avocado", 9037, "", "Produce");
        Ingredient peanutButter = ingredientFactory.create("peanut butter", 16098, "", "Nut butters, Jams, and Honey");
        Ingredient banana = ingredientFactory.create("bananas", 9040, "", "Produce");
        bananaChocPudding.add(avocado);
        bananaChocPudding.add(peanutButter);
        bananaChocPudding.add(banana);

        // Creating our input data and user repository
        String link = new getRecipeInformation().getRecipeURL(634048, false, false, false);
        Recipe toSavedRecipe = recipefactory.create("Banana Chocolate Pudding", 634048, bananaChocPudding,
                "https://img.spoonacular.com/recipes/634048-312x231.jpg", link);

        // Adding user to DAO
        User user = userfactory.create("Carolina", "Lina123");
        SaveForLaterInputData inputData = new SaveForLaterInputData(user, toSavedRecipe);
        SaveForLaterUserDataAccessInterface userRepository = new FileUserDataAccessObject("users.json");

        // This creates a successPresenter that tests whether the test case is as we expect.
        SaveForLaterOutputBoundary successPresenter = new SaveForLaterOutputBoundary() {
            @Override
            public void prepareSuccessView(SaveForLaterOutputData outputData) {
                assertEquals("", outputData.getSavedForLater());
                assertTrue(userRepository.existsByRecipe(toSavedRecipe, user));
            }

            @Override
            public void prepareFailureView(String errorMessage) {
                fail("Use case failure is unexpected.");
            }
        };


        SaveForLaterInputBoundary interactor = new SaveForLaterInteractor(userRepository, successPresenter, toSavedRecipe);
        interactor.execute(inputData);
    };
}
