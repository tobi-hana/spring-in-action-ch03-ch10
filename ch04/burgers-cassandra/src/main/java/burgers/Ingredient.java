package burgers;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


@Data
@AllArgsConstructor
//@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@Table("ingredients")
public class Ingredient {
    @PrimaryKey
    private final String id;
    private final String name;
    private final Type type;
    public enum Type{
        BUN, PATTY, VEGGIES, CHEESE, SAUCE
    }

}