package burgers.restClient;

import burgers.Ingredient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class BurgerClient {
    private RestTemplate restTemplate;
    @Autowired
    public BurgerClient(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

//    GETing resources
    public Ingredient getIngredientById(String ingredientId){
        return restTemplate.getForObject("http://localhost:8080/ingredients/{id}",
                Ingredient.class, ingredientId);
    }

//    public Ingredient getIngredientById(String ingredientId){
//        Map<String, String> urlVariables = new HashMap<>();
//        urlVariables.put("id", ingredientId);
//        return restTemplate.getForObject("http://localhost:8080/ingredients/{id}",
//                                        Ingredient.class,
//                                        urlVariables);
//    }

//    public Ingredient getIngredientById(String ingredientId){
//        Map<String, String> urlVariables = new HashMap<>();
//        urlVariables.put("id", ingredientId);
//        URI url = UriComponentsBuilder
//                .fromHttpUrl("http:://localhost:8080/ingredients/{id}")
//                .build(urlVariables);
//        return restTemplate.getForObject(url, Ingredient.class);
//    }


//    public Ingredient getIngredientById(String ingredientId){
//        ResponseEntity<Ingredient> responseEntity =
//                restTemplate.getForEntity("http://localhost:8080/ingredients/{id}",
//                                            Ingredient.class,
//                                            ingredientId);
//        log.info("Fetched time: {}",
//                responseEntity.getHeaders().getDate());
//        return responseEntity.getBody();
//    }


//    PUTing resources
    public void updateIngredient(Ingredient ingredient) {
        restTemplate.put("http://localhost:8080/ingredients/{id}",
                ingredient, ingredient.getId());
    }

//    DELETEing resources
    public void deleteIngredient(Ingredient ingredient){
        restTemplate.delete("http://localhost:8080/ingredients/{id}",
                ingredient.getId());
    }

//    POSTing resource data
    public Ingredient createIngredient(Ingredient ingredient) {
        return restTemplate.postForObject("http://localhost:8080/ingredients",
                ingredient, Ingredient.class);
    }

//    public URI createIngredient(Ingredient ingredient){
//        return restTemplate.postForLocation("http://localhost:8080/ingredients",
//                ingredient);
//    }

//    public Ingredient createIngredient(Ingredient ingredient){
//        ResponseEntity<Ingredient> responseEntity =
//                restTemplate.postForEntity("http://localhost:8080/ingredients",
//                        ingredient,
//                        Ingredient.class);
//        log.info("New resource created at {}",
//                responseEntity.getHeaders().getLocation());
//        return responseEntity.getBody();
//    }








}
