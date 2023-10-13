package burgers;

import burgers.Ingredient.Type;
import burgers.data.IngredientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BurgersMongodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(BurgersMongodbApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(IngredientRepository repository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
//                repository.deleteAll();
                repository.save(new Ingredient("STBN", "Steamed Bun", Type.BUN));
                repository.save(new Ingredient("TOBN", "Toasted Bun", Type.BUN));
                repository.save(new Ingredient("SSBN", "Sesame Seed Bun", Type.BUN));
                repository.save(new Ingredient("BFPT", "Beef", Type.PATTY));
                repository.save(new Ingredient("CHPT", "Chicken", Type.PATTY));
                repository.save(new Ingredient("FHPT", "Fish", Type.PATTY));
                repository.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
                repository.save(new Ingredient("ONIN", "Onions", Type.VEGGIES));
                repository.save(new Ingredient("PCKL", "Pickles", Type.VEGGIES));
                repository.save(new Ingredient("TMTO", "Tomatoes", Type.VEGGIES));
                repository.save(new Ingredient("AMRC", "American", Type.CHEESE));
                repository.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
                repository.save(new Ingredient("GOUD", "Gouda", Type.CHEESE));
                repository.save(new Ingredient("MAYO", "Mayo", Type.SAUCE));
                repository.save(new Ingredient("KECH", "Ketchup", Type.SAUCE));
                repository.save(new Ingredient("MAST", "Mustard", Type.SAUCE));
            }
        };
    }
}