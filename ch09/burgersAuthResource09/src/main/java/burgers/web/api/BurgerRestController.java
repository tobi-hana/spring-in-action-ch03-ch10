package burgers.web.api;/*
* with REST dependency in POM
* there is no need in RestControllers
* */
//
//
//
// package burgers.web.api;
//
//import burgers.Burger;
//import burgers.data.BurgerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping(path="/api/burgers",
//                produces={"application/json", "text/xml"})
////                produces="application/json")
//@CrossOrigin(origins={"http://burgercloud:8080", "http://burgercloud.com"})
////@CrossOrigin(origins="http://burgercloud:8080")
////should not it be 9090 port instead cause it is set in YAML
//public class BurgerRestController {
//    private BurgerRepository burgerRepository;
//
//    @Autowired
//    public BurgerRestController(BurgerRepository burgerRepository){
//        this.burgerRepository = burgerRepository;
//    }
//
//    @GetMapping(params="recent")
//    public Iterable<Burger> recentBurgers() {
//        PageRequest pageRequest = PageRequest.of(
//                0, 12, Sort.by("createdAt").descending()
//        );
//        return burgerRepository.findAll(pageRequest).getContent();
//    }
//    @GetMapping("/{id}")
//    public ResponseEntity<Burger> burgerById(@PathVariable("id") Long id) {
//        Optional<Burger> optionalBurger = burgerRepository.findById(id);
//        if(optionalBurger.isPresent()) {
//            return new ResponseEntity<>(optionalBurger.get(), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//    }
//    @PostMapping(consumes="application/json")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Burger postBurger(@RequestBody Burger burger) {
//        return burgerRepository.save(burger);
//    }
//}
