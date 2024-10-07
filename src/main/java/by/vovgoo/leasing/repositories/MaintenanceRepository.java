package by.vovgoo.leasing.repositories;

import by.vovgoo.leasing.entity.Maintenance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance, Long>, QuerydslPredicateExecutor<Maintenance> {

    @Query("SELECT m FROM Maintenance m WHERE m.cars.id = ?1 ORDER BY m.id DESC")
    Page<Maintenance> findMaintenanceByCars(Long id, Pageable pageable);
}
