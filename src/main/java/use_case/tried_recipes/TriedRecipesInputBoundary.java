<<<<<<<< HEAD:src/main/java/use_case/triedRecipes/TriedRecipesInputBoundary.java
package use_case.triedRecipes;
========
package use_case.tried_recipes;
>>>>>>>> main:src/main/java/use_case/tried_recipes/TriedRecipesInputBoundary.java

import entity.Recipe;

public interface TriedRecipesInputBoundary {
    void addRecipeToTriedRecipes(String username, Recipe recipe);
    void getTriedRecipes(String username, TriedRecipesOutputBoundary presenter);
}
