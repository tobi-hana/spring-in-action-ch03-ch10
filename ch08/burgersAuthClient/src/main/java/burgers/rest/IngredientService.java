package burgers.rest;
//no mention of this in the book!!!

import burgers.Ingredient;

public interface IngredientService {
    Iterable<Ingredient> findAll();
    Ingredient addIngredient(Ingredient ingredient);

}
