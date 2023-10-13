package burgers;

public class BurgerUDRUtils {

    public static IngredientUDT toIngredientUDT(Ingredient ingredient){
        return new IngredientUDT(ingredient.getName(), ingredient.getType());
    }
}
