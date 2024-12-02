package api;

import java.io.IOException;

public class GetRecipeURLTest {

    public static void main(String[] args) {
        // Create an instance of the `getRecipeInformation` class
        getRecipeInformation recipeInfoFetcher = new getRecipeInformation();

        // Define test parameters
        int recipeId = 635964; // Replace with a valid recipe ID for testing

        // Test the `getRecipeURL` method
        try {
            String recipeURL = recipeInfoFetcher.getRecipeURL(recipeId);
            System.out.println("Recipe URL: " + recipeURL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}