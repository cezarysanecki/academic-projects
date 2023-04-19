package pl.csanecki.AITSI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.csanecki.AITSI.entity.Product;
import pl.csanecki.AITSI.entity.ProductType;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> getProductByProductType(ProductType productType);
    @Query("SELECT p FROM Product p JOIN FETCH p.productType JOIN FETCH p.productCount WHERE p.id = (:id)")
    Product getProductByProductId(@Param("id") long id);
    Product getProductByProducerAndModel(String producer, String model);
}
