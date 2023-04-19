package pl.csanecki.AITSI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.csanecki.AITSI.entity.ProductType;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
    ProductType getByProductTypeId(long id);
    ProductType getByName(String name);
}
