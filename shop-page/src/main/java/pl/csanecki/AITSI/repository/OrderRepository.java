package pl.csanecki.AITSI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pl.csanecki.AITSI.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM Order o JOIN FETCH o.orderProducts")
    List<Order> findAll();
    @Query("SELECT o FROM Order o JOIN FETCH o.orderProducts where o.userEmail = :userEmail")
    List<Order> findAllUserOrders(String userEmail);
}
