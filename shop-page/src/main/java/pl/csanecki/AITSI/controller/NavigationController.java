package pl.csanecki.AITSI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.csanecki.AITSI.service.ProductService;

@Controller
public class NavigationController {
	private ProductService productService;

	@Autowired
	public NavigationController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/")
	public String getWelcomePage() {
		return "welcomePage";
	}
	
	@GetMapping("/main")
	public String getMainPage(Model model) {
		model.addAttribute("categories", productService.getAllCategories());

		return "mainPage";
	}
}
