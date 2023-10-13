package burgers;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
public class Ingredient {
    @Id
    private final String id;
    private final String name;
    private final Type type;
    public enum Type{
        BUN, PATTY, VEGGIES, CHEESE, SAUCE
    }

}