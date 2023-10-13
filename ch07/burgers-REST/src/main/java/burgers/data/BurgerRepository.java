package burgers.data;

import burgers.Burger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

// No mentioning in the book that this repository
// should not be a CrudRepository but PagingAndSortingRepository instead
// problems arise in burgers.web.api.BurgerController
public interface BurgerRepository extends PagingAndSortingRepository<Burger, Long> {
}
