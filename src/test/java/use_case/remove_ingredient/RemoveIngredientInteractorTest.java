package use_case.remove_ingredient;

import data_access.FileUserDataAccessObject;
import entity.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.add_ingredient.AddIngredientInputData;

import java.io.File;
import java.io.IOException;

public class RemoveIngredientInteractorTest {
    private File testFile;
    UserFactory userFactory = new PantryPalUserFactory();
    FridgeFactory fridgeFactory;
    IngredientFactory ingredientFactory = new CommonIngredientFactory();

    @BeforeEach
    void setUp() {
        // Set up a test JSON file for the FileUserDataAccessObject
        testFile = new File("test_remove.json");
    }
    @Test
    void successTest() throws IOException {
        RemoveIngredientDataAccessInterface userRepository = new FileUserDataAccessObject(testFile.getPath());
        User user = userFactory.create("rosie", "pswrd");
        userRepository.save(user);
        Ingredient ingredient = ingredientFactory.create("flour", "tbsp", 1);
        RemoveIngredientInputData inputData = new RemoveIngredientInputData("flour", user);
        userRepository.addIngredient(user, ingredient);

        // This creates a successPresenter that tests whether the test case is as we expect.
        RemoveIngredientOutputBoundary successPresenter = new RemoveIngredientOutputBoundary() {
            @Override
            public void prepareSuccessView(RemoveIngredientOutputData fridge) {
                Assertions.assertFalse(fridge.getFridge().hasIngredient(ingredient));
                Assertions.assertFalse(userRepository.existsByIngredient(ingredient, user));
            }
            @Override
            public void prepareFailView(String error) {
                Assertions.fail("Use case failure is unexpected");}
        };

        RemoveIngredientInputBoundary interactor = new RemoveIngredientInteractor(userRepository, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    void failTest() throws IOException {
        RemoveIngredientDataAccessInterface userRepository = new FileUserDataAccessObject(testFile.getPath());
        User user = userFactory.create("rosie", "pswrd");
        userRepository.save(user);
        RemoveIngredientInputData inputData = new RemoveIngredientInputData("flour", user);

        RemoveIngredientOutputBoundary successPresenter = new RemoveIngredientOutputBoundary() {
            @Override
            public void prepareSuccessView(RemoveIngredientOutputData fridge) {
                Assertions.fail("Use case success is unexpected");}
            @Override
            public void prepareFailView(String error) {
                Assertions.assertEquals("this ingredient does not exist", error);
            }
        };

        RemoveIngredientInputBoundary interactor = new RemoveIngredientInteractor(userRepository, successPresenter);
        interactor.execute(inputData);
    }
}

