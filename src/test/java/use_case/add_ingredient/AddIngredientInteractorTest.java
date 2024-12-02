package use_case.add_ingredient;

import data_access.FileUserDataAccessObject;
import entity.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class AddIngredientInteractorTest {

    @Test
    void successTest() throws IOException {
        UserFactory userFactory = new PantryPalUserFactory();
        User user = userFactory.create("rosie", "pswrd");
        Fridge fridge = user.getFridge();
        IngredientFactory ingredientFactory = new CommonIngredientFactory();
        Ingredient ingredient = IngredientFactory.create("flour", "tbsp", 1);
        AddIngredientInputData inputData = new AddIngredientInputData("flour", "tbsp", 1, fridge);
        AddIngredientDataAccessInterface userRepository = new FileUserDataAccessObject("test_add.json");

        // This creates a successPresenter that tests whether the test case is as we expect.
        AddIngredientOutputBoundary successPresenter = new AddIngredientOutputBoundary() {
            @Override
            public void prepareSuccessView(AddIngredientOutputData fridge) {
                assertTrue(fridge.getFridge().hasIngredient(ingredient));
                assertTrue(userRepository.existsByIngredient(ingredient, user));
            }
            @Override
            public void prepareFailView(String error) {fail("Use case failure is unexpected");}
        };
    }
}
