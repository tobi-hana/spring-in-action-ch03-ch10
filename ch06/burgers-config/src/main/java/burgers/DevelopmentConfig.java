package burgers;

import burgers.data.IngredientRepository;
import burgers.data.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

@Profile({"!prod", "!qa"})
@Configuration
public class DevelopmentConfig {
    @Bean
    public CommandLineRunner dataLoader(IngredientRepository ingredientRep,
                                        UserRepository userRep,
                                        PasswordEncoder encoder) {
        return args -> {
            ingredientRep.deleteAll();
            userRep.deleteAll();

            ingredientRep.save(new Ingredient("STBN", "Steamed Bun", Ingredient.Type.BUN));
            ingredientRep.save(new Ingredient("TOBN", "Toasted Bun", Ingredient.Type.BUN));
            ingredientRep.save(new Ingredient("SSBN", "Sesame Seed Bun", Ingredient.Type.BUN));
            ingredientRep.save(new Ingredient("BFPT", "Beef", Ingredient.Type.PATTY));
            ingredientRep.save(new Ingredient("CHPT", "Chicken", Ingredient.Type.PATTY));
            ingredientRep.save(new Ingredient("FHPT", "Fish", Ingredient.Type.PATTY));
            ingredientRep.save(new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES ));
            ingredientRep.save(new Ingredient("ONIN", "Onions", Ingredient.Type.VEGGIES ));
            ingredientRep.save(new Ingredient("PCKL", "Pickles", Ingredient.Type.VEGGIES ));
            ingredientRep.save(new Ingredient("TMTO", "Tomatoes", Ingredient.Type.VEGGIES ));
            ingredientRep.save(new Ingredient("AMRC", "American", Ingredient.Type.CHEESE));
            ingredientRep.save(new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE));
            ingredientRep.save(new Ingredient("GOUD", "Gouda", Ingredient.Type.CHEESE));
            ingredientRep.save(new Ingredient("MAYO", "Mayo", Ingredient.Type.SAUCE ));
            ingredientRep.save(new Ingredient("KECH", "Ketchup", Ingredient.Type.SAUCE ));
            ingredientRep.save(new Ingredient("MAST", "Mustard", Ingredient.Type.SAUCE ));

            userRep.save(new User("tasty", encoder.encode("password"),
                    "And That's It", "Elm Street", "Gotham", "123456",
                    "88005553535"));
        };

    }
}
