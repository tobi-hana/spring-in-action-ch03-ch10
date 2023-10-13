package burgers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BurgersAuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BurgersAuthServerApplication.class, args);
    }

}
// http://localhost:9000/oauth2/authorize?response_type=code&client_id=burger-admin-client&redirect_uri=http://127.0.0.1:9090/login/oauth2/code/burger-admin-client&scope=writeIngredients+deleteIngredients

// with no client receive error