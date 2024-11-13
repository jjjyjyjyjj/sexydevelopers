# sexydevelopers
Group Project for CSC207

**User Stories:**
Carolina -- I stumble across a recommended recipe that I am not in the mood for at the moment, but may want to cook later. 

Rosie -- As a cook, I would want to know what ingredients I have left in my inventory and what I should buy. 

Ciel -- As a user, I want to find recipes that fit my protein/calorie goals. 

Jiayun -- As a user, I would like to utilize all my existing ingredients so they don’t expire and go to waste. 

Ryan (Team) -- As a college student, I want to know what good dishes to cook with my ingredients.

**Notes**
- use issues
- from user stories, create use cases and then interactors:
    A use case is a description of a series of interactions the user has with the system, including how the system responds.
    _For each user story:_
    • create a set of use cases that together enable the user story
  
    _For each use case:_
    • figure out the sequence of interactions the user will do with the system to accomplish the goal (probably requires a sketch of a UI)
  
    _For each interaction:_
    • create an Interactor and all the supporting code



**CSC207 Project Deliverable 1 Tasks**
Main goal: to implement the team user story:
- “As a college student, I want to know what good dishes to cook with my ingredients”

Steps/Tasks:
1. Setting up the API handler interface
2. Creating the API class
3. Updating RecipeBank entity to fetch the recipes
4. Creating an interface in the getExistingIngredientRecipe use case
5. Creating a class in the getExistingIngredientRecipe use case to implement the interface. This class should interact with RecipeBank to retrieve recommended recipes
6. Creating a controller to bridge the UI and the recommended recipe classes/interface
7. Set up the view layer to display the recommended recipes
8. Creating a test to test the use case


