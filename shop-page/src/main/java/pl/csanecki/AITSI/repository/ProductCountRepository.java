package pl.csanecki.AITSI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.csanecki.AITSI.entity.ProductCount;

public interface ProductCountRepository extends JpaRepository<ProductCount, Long> {
}
