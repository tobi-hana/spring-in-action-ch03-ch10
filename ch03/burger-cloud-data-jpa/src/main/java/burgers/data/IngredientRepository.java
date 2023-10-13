package burgers.data;

import org.springframework.data.repository.CrudRepository;
import burgers.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}