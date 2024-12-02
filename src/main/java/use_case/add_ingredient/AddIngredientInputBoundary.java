package use_case.add_ingredient;

public interface AddIngredientInputBoundary {

        /**
         * /* Execute Use Case of adding an Ingredient to the Fridge.
         * @param addIngredientInputData the input data for this use case
         */
        void execute(AddIngredientInputData addIngredientInputData);

    }
