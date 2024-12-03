package use_case.add_ingredient;

import data_access.FileUserDataAccessObject;
import entity.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class AddIngredientInteractorTest {
    private File testFile;
    UserFactory userFactory = new PantryPalUserFactory();
    FridgeFactory fridgeFactory;
    IngredientFactory ingredientFactory = new CommonIngredientFactory();

    @BeforeEach
    void setUp() {
        // Set up a test JSON file for the FileUserDataAccessObject
        testFile = new File("test_add.json");
    }
    @Test
    void successTest() throws IOException {
        AddIngredientDataAccessInterface userRepository = new FileUserDataAccessObject(testFile.getPath());
        User user = userFactory.create("rosie", "pswrd");
        userRepository.save(user);
        Ingredient ingredient = ingredientFactory.create("flour", "tbsp", 1);
        AddIngredientInputData inputData = new AddIngredientInputData("flour", "tbsp", 1, user);

        // This creates a successPresenter that tests whether the test case is as we expect.
        AddIngredientOutputBoundary successPresenter = new AddIngredientOutputBoundary() {
            @Override
            public void prepareSuccessView(AddIngredientOutputData fridge) {
                Assertions.assertTrue(fridge.getFridge().hasIngredient(ingredient));
                Assertions.assertTrue(userRepository.existsByIngredient(ingredient, user));
            }
            @Override
            public void prepareFailView(String error) {
                Assertions.fail("Use case failure is unexpected");}
        };

        AddIngredientInputBoundary interactor = new AddIngredientInteractor(userRepository, successPresenter, new CommonIngredientFactory());
        interactor.execute(inputData);
    }

    @Test
    void failTest() throws IOException {
        AddIngredientDataAccessInterface userRepository = new FileUserDataAccessObject(testFile.getPath());
        User user = userFactory.create("rosie", "pswrd");
        userRepository.save(user);
        Ingredient ingredient = ingredientFactory.create("flour", "tbsp", 1);
        AddIngredientInputData inputData = new AddIngredientInputData("flour", "tbsp", 1, user);
        userRepository.addIngredient(user, ingredient);

        AddIngredientOutputBoundary successPresenter = new AddIngredientOutputBoundary() {
            @Override
            public void prepareSuccessView(AddIngredientOutputData fridge) {
                Assertions.fail("Use case success is unexpected");}
            @Override
            public void prepareFailView(String error) {
                Assertions.assertEquals("this ingredient already exists", error);
            }
        };

        AddIngredientInputBoundary interactor = new AddIngredientInteractor(userRepository, successPresenter, new CommonIngredientFactory());
        interactor.execute(inputData);
    }
}
