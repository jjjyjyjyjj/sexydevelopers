package use_case.reciperecommender;

import api.recipeFinder;
import data_access.FileUserDataAccessObject;
import entity.*;
import interface_adapter.recipeRecommendation.RecipeRecState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.recipe_recommender.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class RecipeRecommenderTest {
    private File testFile;
    private Recipe testRecipe;
    private List<Ingredient> omlette;
    private recipeFinder recipeFinder; // how to create mock api from here...
    private RecipeRecState state;
    UserFactory userFactory = new PantryPalUserFactory();
    RecipeFactory recipeFactory = new CommonRecipeFactory();
    IngredientFactory ingredientFactory = new CommonIngredientFactory();

    @BeforeEach
    void setUp() throws IOException {
        // Set up a test JSON file for the FileUserDataAccessObject
        testFile = new File("test_users.json");

        // Creates a new recipe
        this.omlette = new ArrayList<>();
        Ingredient bread = ingredientFactory.create("bread crumbs",  "", 1);
        Ingredient milk = ingredientFactory.create("milk",  "", 1);
        Ingredient egg = ingredientFactory.create("Eggs",  "", 1);
        omlette.add(egg);
        omlette.add(milk);
        omlette.add(bread);

        this.testRecipe = recipeFactory.create("Bread Omlette", 635964, omlette,
                "https://img.spoonacular.com/recipes/635964-312x231.jpg",
                "https://www.foodista.com/recipe/2M6MVKZT/bread-omlette");

        // Initialise the state of the software
        state = new RecipeRecState();
    }

//    @Test
//    void successRecRecipeTest() throws IOException {
//        // Create a new user repository to store a new user
//        RecipeRecUserDataAccessInterface userRepository = new FileUserDataAccessObject(testFile.getPath());
//        User user = userFactory.create("lala", "password");
//        ((FileUserDataAccessObject) userRepository).save(user);
//
//        //For a success test, we need to add ingredients to the user's fridge first.
//        RecipeRecInputData inputData = new RecipeRecInputData(user);
//        for (Ingredient ingdnt: omlette){
//            user.getFridge().addIngredient(ingdnt);}
//
//        // This creates a successPresenter that tests whether the test case is as we expect.
//        RecipeRecOutputBoundary successPresenter = new RecipeRecOutputBoundary() {
//            @Override
//            public void prepareSuccessView(Recipe recipe) {
//                // 1 thing to check: the output data is correct.
//                assertEquals(omlette, recipe);
//            }
//
//            @Override
//            public void prepareFailView(String error) {
//                fail("Use case failure is unexpected.");
//            }
//        };
//        RecipeRecInputBoundary interactor = new RecipeRecInteractor(userRepository, successPresenter, recipeFinder,
//                state);
//        interactor.fetchNextRecipe(inputData);
//    }
}
