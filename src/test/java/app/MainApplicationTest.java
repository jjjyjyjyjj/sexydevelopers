//package app;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class MainApplicationIntegrationTest {
//
//    private MainApplication app;
//
//    @BeforeEach
//    public void setup() {
//        app = new MainApplication();
//    }
//
//    @Test
//    public void testFridgeUpdateTriggersRecipeDisplay() {
//        // Initially, the fridge should be empty
//        assertTrue(app.getFridgeContents().isEmpty());
//
//        // Add an ingredient to the fridge
//        app.addIngredientToFridge("Tomato");
//
//        // Now, check if the fridge contains the ingredient
//        assertTrue(app.getFridgeContents().contains("Tomato"));
//
//        // Trigger the recipe display (simulate this action)
//        app.updateRecipeDisplay();
//
//        // Check if recipes are displayed based on the fridge content
//        assertTrue(app.getDisplayedRecipes().size() > 0);
//    }
//}