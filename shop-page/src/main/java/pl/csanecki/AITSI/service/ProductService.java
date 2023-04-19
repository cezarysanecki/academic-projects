package pl.csanecki.AITSI.service;

import pl.csanecki.AITSI.entity.Product;
import pl.csanecki.AITSI.entity.ProductType;

import java.util.List;

public interface ProductService {
    List<ProductType> getAllCategories();
    List<Product> getProductsByCategory(long categoryId);
    Product getProductById(long id);
    Product getProductByProducerAndModel(String producer, String model);
    void saveProduct(Product product);
    void deleteProduct(Product product);
    ProductType getProductTypeByName(String name);
    ProductType getProductTypeById(long productTypeId);
    void saveProductType(ProductType productType);
}
