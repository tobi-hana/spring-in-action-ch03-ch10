package burgers;

import burgers.data.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DevelopmentConfig {
    @Bean
    public ApplicationRunner dataLoader(UserRepository userRepository,
                                        PasswordEncoder passwordEncoder) {
        return args -> {
            userRepository.save(
                    new User("admin",
                            passwordEncoder.encode("admin"),
                            "ROLE_ADMIN"));
            userRepository.save(
                    new User("burgers",
                            passwordEncoder.encode("burgers"),
                            "ROLE_ADMIN"));
        };
    }
}
