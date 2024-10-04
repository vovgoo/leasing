package by.vovgoo.leasing.repositories;

import by.vovgoo.leasing.entity.OrderPersonal;
import by.vovgoo.leasing.entity.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentsRepository extends JpaRepository<Payments, Long> {

    @Query("SELECT new by.vovgoo.leasing.entity.OrderPersonal(p) " +
            "FROM Payments p " +
            "JOIN FETCH p.rentals r " +
            "JOIN FETCH r.user u " +
            "JOIN FETCH r.cars c " +
            "WHERE r.id = ?1")
    Optional<OrderPersonal> getOrderPersonalById(Long id);
}
