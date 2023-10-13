package burgers;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import burgers.data.IngredientRepository;
import burgers.Ingredient.Type;

@SpringBootApplication
public class BurgerCloudDataJPA {

    public static void main(String[] args) {
        SpringApplication.run(BurgerCloudDataJPA.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(IngredientRepository repository) {
        return args -> {
            repository.deleteAll();
            repository.save(new Ingredient("STBN", "Steamed Bun", Type.BUN));
            repository.save(new Ingredient("TOBN", "Toasted Bun", Type.BUN));
            repository.save(new Ingredient("SSBN", "Sesame Seed Bun", Type.BUN));
            repository.save(new Ingredient("BFPT", "Beef", Type.PATTY));
            repository.save(new Ingredient("CHPT", "Chicken", Type.PATTY));
            repository.save(new Ingredient("FHPT", "Fish", Type.PATTY));
            repository.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES ));
            repository.save(new Ingredient("ONIN", "Onions", Type.VEGGIES ));
            repository.save(new Ingredient("PCKL", "Pickles", Type.VEGGIES ));
            repository.save(new Ingredient("TMTO", "Tomatoes", Type.VEGGIES ));
            repository.save(new Ingredient("AMRC", "American", Type.CHEESE));
            repository.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
            repository.save(new Ingredient("GOUD", "Gouda", Type.CHEESE));
            repository.save(new Ingredient("MAYO", "Mayo", Type.SAUCE ));
            repository.save(new Ingredient("KECH", "Ketchup", Type.SAUCE ));
            repository.save(new Ingredient("MAST", "Mustard", Type.SAUCE ));
        };

    }
}