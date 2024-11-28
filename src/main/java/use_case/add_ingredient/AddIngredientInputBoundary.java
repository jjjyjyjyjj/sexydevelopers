package use_case.add_ingredient;

import entity.Ingredient;
import entity.Recipe;
import use_case.remove_from_favrecipes.RemoveFavRecipeInputData;

    public interface AddIngredientInputBoundary {

        /**
         * /* Execute Use Case of adding an Ingredient to the Fridge.
         * @param addIngredientInputData the input data for this use case
         */
        void execute(AddIngredientInputData addIngredientInputData);

    }
