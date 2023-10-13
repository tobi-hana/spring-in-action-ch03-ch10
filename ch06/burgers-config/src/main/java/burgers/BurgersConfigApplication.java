package burgers;

import burgers.Ingredient.Type;
import burgers.data.IngredientRepository;
import burgers.data.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BurgersConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(BurgersConfigApplication.class, args);
    }
}