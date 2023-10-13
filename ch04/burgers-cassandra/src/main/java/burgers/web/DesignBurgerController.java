package burgers.web;

import burgers.Burger;
import burgers.BurgerOrder;
import burgers.BurgerUDT;
import burgers.Ingredient;
import burgers.Ingredient.Type;
import burgers.data.IngredientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("burgerOrder")
public class DesignBurgerController {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public DesignBurgerController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(i -> ingredients.add(i));
        Type[] types = Type.values();
        for(Type type: types){
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name = "burgerOrder")
    public BurgerOrder order(){
        return new BurgerOrder();
    }

    @ModelAttribute(name = "burger")
    public Burger burger(){
        return new Burger();
    }

    @GetMapping
    public String designForm(){
        return "designForm";
    }

    @PostMapping
    public String processBurger(@Valid Burger burger,
                              Errors errors,
                              @ModelAttribute BurgerOrder burgerOrder) {
        if(errors.hasErrors()){
            return "designForm";
        }
        burgerOrder.addBurger(new BurgerUDT(burger.getName(), burger.getIngredients()));
        log.info("Processing burger: {}", burger);

        return "redirect:/orders/current";
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type){
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}

