package it.sevenbits.courses.testing.practice.config;

import it.sevenbits.courses.testing.practice.core.model.Food;
import it.sevenbits.courses.testing.practice.core.model.Order;
import it.sevenbits.courses.testing.practice.core.repository.foodrepository.IFoodRepository;
import it.sevenbits.courses.testing.practice.core.repository.foodrepository.MapFoodRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Class describe configuration of repository.
 */
@Configuration
public class RepositoryConfig {

    /**
     * The method creates instance of food Map
     * @return instance of the food Map
     */
    @Bean
    public Map<Long, Food> foodMap() {
        return new HashMap<>();
    }


    /**
     * The method creates instance of order Map
     * @return instance of the order Map
     */
    @Bean
    public Map<Long, Order> orderMap() {
        return new HashMap<>();
    }

    /**
     * The method creates instance of books repository
     * @param foodMap instance of jdbcTemplate
     * @return instance of the books repository
     */
    @Bean
    public IFoodRepository foodRepository(final Map foodMap) {
        return new MapFoodRepository(foodMap);
    }

}