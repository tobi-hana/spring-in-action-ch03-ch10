package burgers;

import burgers.data.BurgerRepository;
import burgers.data.IngredientRepository;
import burgers.data.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@Profile({"!prod", "!qa"})
@Configuration
public class DevelopmentConfig {
    @Bean
    public CommandLineRunner dataLoader(IngredientRepository ingredientRep,
                                        UserRepository userRep,
                                        PasswordEncoder encoder,
                                        BurgerRepository burgerRep) {
        return args -> {
            ingredientRep.deleteAll();
            userRep.deleteAll();
            burgerRep.deleteAll();

            Ingredient steamedBun = new Ingredient("STBN", "Steamed Bun", Ingredient.Type.BUN);
            Ingredient toastedBun =new Ingredient("TOBN", "Toasted Bun", Ingredient.Type.BUN);
            Ingredient sesameSeedBun = new Ingredient("SSBN", "Sesame Seed Bun", Ingredient.Type.BUN);

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

            ingredientRep.save(steamedBun);
            ingredientRep.save(toastedBun);
            ingredientRep.save(sesameSeedBun);

            userRep.save(new User("tasty", encoder.encode("password"),
                    "And That's It", "Elm Street", "Gotham", "123456",
                    "88005553535"));

            Burger beefB = new Burger();
            beefB.setName("Beef Standard");
            beefB.setIngredients(Arrays.asList( toastedBun,
                    ingredientRep.findIngredientByName("Beef"),
                    ingredientRep.findIngredientByName("Lettuce"),
                    ingredientRep.findIngredientByName("Onions"),
                    ingredientRep.findIngredientByName("Pickles"),
                    ingredientRep.findIngredientByName("Tomatoes"),
                    ingredientRep.findIngredientByName("American"),
                    ingredientRep.findIngredientByName("Mayo"),
                    ingredientRep.findIngredientByName("Ketchup")));
            burgerRep.save(beefB);

            Burger chickenB = new Burger();
            chickenB.setName("Chicken Standard");
            chickenB.setIngredients(Arrays.asList(sesameSeedBun,
                    ingredientRep.findIngredientByName("Chicken"),
                    ingredientRep.findIngredientByName("Lettuce"),
                    ingredientRep.findIngredientByName("Onions"),
                    ingredientRep.findIngredientByName("Tomatoes"),
                    ingredientRep.findIngredientByName("Cheddar"),
                    ingredientRep.findIngredientByName("Mayo"),
                    ingredientRep.findIngredientByName("Mustard")));
            burgerRep.save(chickenB);

            Burger fishB = new Burger();
            fishB.setName("Fish Standard");
            fishB.setIngredients(Arrays.asList(steamedBun,
                    ingredientRep.findIngredientByName("Fish"),
                    ingredientRep.findIngredientByName("Lettuce"),
                    ingredientRep.findIngredientByName("Onions"),
                    ingredientRep.findIngredientByName("Pickles"),
                    ingredientRep.findIngredientByName("Gouda"),
                    ingredientRep.findIngredientByName("Mayo")));
            burgerRep.save(fishB);





        };

    }
}
