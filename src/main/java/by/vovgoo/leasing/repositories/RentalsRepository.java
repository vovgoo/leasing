package by.vovgoo.leasing.repositories;

import by.vovgoo.leasing.entity.Rentals;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalsRepository extends JpaRepository<Rentals, Long>, QuerydslPredicateExecutor<Rentals> {

    @Query("SELECT r FROM Rentals r JOIN FETCH Cars c ON r.cars.id = c.id WHERE r.user.id = ?1 ORDER BY r.id DESC")
    Page<Rentals> findAllPersonalRentalsByUserId(Long userId, Pageable pageable);
}
