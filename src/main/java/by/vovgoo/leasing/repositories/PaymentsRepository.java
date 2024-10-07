package by.vovgoo.leasing.repositories;

import by.vovgoo.leasing.entity.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentsRepository extends JpaRepository<Payments, Long> {

    @Query("SELECT p " +
            "FROM Payments p " +
            "JOIN FETCH p.rentals r " +
            "JOIN FETCH r.user u " +
            "JOIN FETCH r.cars c " +
            "WHERE r.id = ?1")
    Optional<Payments> getOrderPersonalById(Long id);
}
