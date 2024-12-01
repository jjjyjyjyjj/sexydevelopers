<<<<<<<< HEAD:src/main/java/use_case/triedRecipes/TriedRecipesOutputBoundary.java
package use_case.triedRecipes;
========
package use_case.tried_recipes;
>>>>>>>> main:src/main/java/use_case/tried_recipes/TriedRecipesOutputBoundary.java

import entity.Recipe;

import java.util.List;

public interface TriedRecipesOutputBoundary {
    void presentTriedRecipes(List<Recipe> triedRecipes);
}
