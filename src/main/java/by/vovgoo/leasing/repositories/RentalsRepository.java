package by.vovgoo.leasing.repositories;

import by.vovgoo.leasing.entity.RentalsPersonal;
import by.vovgoo.leasing.entity.Rentals;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalsRepository extends JpaRepository<Rentals, Long>, QuerydslPredicateExecutor<Rentals> {

    @Query("SELECT new by.vovgoo.leasing.entity.RentalsPersonal(r.id, c, r.startDate, r.endDate, r.rentalsStatus) FROM Rentals r JOIN FETCH Cars c ON r.cars.id = c.id WHERE r.user.id = ?1 ORDER BY r.id DESC")
    Page<RentalsPersonal> findAllPersonalRentalsByUserId(Long userId, Pageable pageable);
}
