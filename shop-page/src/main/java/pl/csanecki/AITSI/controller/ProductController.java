package pl.csanecki.AITSI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.csanecki.AITSI.entity.Product;
import pl.csanecki.AITSI.entity.ProductType;
import pl.csanecki.AITSI.service.ProductService;
import pl.csanecki.AITSI.util.NameFormatter;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
		this.productService = productService;
	}
    
    @GetMapping()
    public String getProductsOfCategoryName(@RequestParam("categoryId") long categoryId, Model model) {
        ProductType productType = productService.getProductTypeById(categoryId);
        List<Product> listOfProducts = productService.getProductsByCategory(categoryId);
        String productTypeName = NameFormatter.getNameWithFirstCapitalLetter(productType.getName());

        model.addAttribute("category", productType);
        model.addAttribute("categoryName", productTypeName);
        model.addAttribute("products", listOfProducts);

        return "category";
    }

	@GetMapping("/product")
    public String getProductById(@RequestParam("productId") long productId, Model model) {
        Product product = productService.getProductById(productId);

        model.addAttribute("product", product);

        return "product";
    }
}
