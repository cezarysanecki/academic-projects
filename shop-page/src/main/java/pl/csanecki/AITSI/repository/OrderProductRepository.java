package pl.csanecki.AITSI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.csanecki.AITSI.entity.OrderProduct;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {
}
