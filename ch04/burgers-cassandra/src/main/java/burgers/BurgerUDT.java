package burgers;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.util.List;

@Data
@UserDefinedType("burger")
public class BurgerUDT {
    private final String name;
    private final List<IngredientUDT> ingredients;
}
