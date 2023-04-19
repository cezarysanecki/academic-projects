package pl.csanecki.AITSI.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.csanecki.AITSI.entity.Product;
import pl.csanecki.AITSI.entity.ProductType;
import pl.csanecki.AITSI.repository.ProductCountRepository;
import pl.csanecki.AITSI.repository.ProductRepository;
import pl.csanecki.AITSI.repository.ProductTypeRepository;
import pl.csanecki.AITSI.service.ProductService;

import javax.transaction.Transactional;

@Transactional
@Service
public class ProductServiceImpl implements ProductService {
    private ProductTypeRepository productTypeRepository;
    private ProductRepository productRepository;
    private ProductCountRepository productCountRepository;

    @Autowired
    public ProductServiceImpl(ProductTypeRepository productTypeRepository, ProductRepository productRepository,
    		ProductCountRepository productCountRepository) {
        this.productTypeRepository = productTypeRepository;
        this.productRepository = productRepository;
        this.productCountRepository = productCountRepository;
    }

    @Override
    public List<ProductType> getAllCategories() {
        return productTypeRepository.findAll();
    }

    @Override
    public List<Product> getProductsByCategory(long categoryId) {
        ProductType productType = productTypeRepository.getByProductTypeId(categoryId);

        return productRepository.getProductByProductType(productType);
    }

    @Override
    public Product getProductById(long id) {
        return productRepository.getProductByProductId(id);
    }

    @Override
    public Product getProductByProducerAndModel(String producer, String model) {
        return productRepository.getProductByProducerAndModel(producer, model);
    }

    @Override
    public void saveProduct(Product product) {
        productCountRepository.save(product.getProductCount());
        productRepository.save(product);
    }
    
    @Override
    public void deleteProduct(Product product) {
    	productRepository.delete(product);
    }

    @Override
    public ProductType getProductTypeByName(String name) {
        return productTypeRepository.getByName(name);
    }
    
    @Override
    public ProductType getProductTypeById(long productTypeId) {
    	return productTypeRepository.getByProductTypeId(productTypeId);
    }

    @Override
    public void saveProductType(ProductType productType) {
        productTypeRepository.save(productType);
    }
}
