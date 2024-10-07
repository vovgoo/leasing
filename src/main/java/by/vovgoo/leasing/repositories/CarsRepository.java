package by.vovgoo.leasing.repositories;

import by.vovgoo.leasing.dto.pages.MainPage.PriceRange;
import by.vovgoo.leasing.entity.Cars;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarsRepository extends JpaRepository<Cars, Long>, QuerydslPredicateExecutor<Cars> {

    @Query("SELECT c FROM Cars c LEFT JOIN Rentals r ON r.cars.id = c.id WHERE c.carStatus = 'AVAILABLE' GROUP BY c.id ORDER BY COUNT(*) DESC LIMIT 5")
    List<Cars> getMostPopularCars();


    @Query(value = """
       SELECT MAX(price) AS max_price, MIN(price) AS min_price, price_group
       FROM (
                SELECT price,
                       CASE
                           WHEN ROW_NUMBER() OVER (ORDER BY price) <= (SELECT COUNT(DISTINCT price) / 3 FROM Cars)
                               THEN 'low'
                           WHEN ROW_NUMBER() OVER (ORDER BY price) > (SELECT COUNT(DISTINCT price) / 3 FROM Cars)
                               AND ROW_NUMBER() OVER (ORDER BY price) <= (SELECT COUNT(DISTINCT price) - (COUNT(DISTINCT price) / 3) FROM Cars)
                               THEN 'middle'
                           ELSE 'high'
                           END AS price_group
                FROM (SELECT DISTINCT price FROM Cars) AS unique_prices
            ) AS price_groups
       GROUP BY price_group
       ORDER BY
           CASE price_group
               WHEN 'low' THEN 1
               WHEN 'middle' THEN 2
               WHEN 'high' THEN 3
               END;
        """, nativeQuery = true)
    List<Tuple> getCarsBounds();
}
