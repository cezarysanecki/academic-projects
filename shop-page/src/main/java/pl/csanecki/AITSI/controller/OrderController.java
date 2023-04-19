package pl.csanecki.AITSI.controller;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.csanecki.AITSI.entity.Order;
import pl.csanecki.AITSI.entity.OrderProduct;
import pl.csanecki.AITSI.entity.Product;
import pl.csanecki.AITSI.entity.embedded.Address;
import pl.csanecki.AITSI.service.OrderService;
import pl.csanecki.AITSI.service.ProductService;
import pl.csanecki.AITSI.util.RoleChecker;

@Controller
@RequestMapping("/order")
@SessionAttributes("order")
public class OrderController {
	private ProductService productService;
	private OrderService orderService;
	private Order order;
   
    @Autowired
	public OrderController(ProductService productService, OrderService orderService, Order order) {
		super();
		this.productService = productService;
		this.orderService = orderService;
		this.order = order;
	}

    @GetMapping("/cart")
    public String showCart(Model model) {
        model.addAttribute("order", order);

        return "order";
    }

	@PostMapping("/addToCart/{productId}")
    public String addProductToCart(@PathVariable("productId") long productId, 
    		@RequestParam(value="amount", required=false) int amount, Model model, RedirectAttributes redirectAttributes) {
		Product product = productService.getProductById(productId);
		
		int existingAmountOfProductInCart = order.getAmountOfProductInCart(product);
		
		if(existingAmountOfProductInCart + amount > product.getProductCount().getAvailableAmount()) {
			redirectAttributes.addFlashAttribute("errorAmount", "* Nie można dodać większej ilości " +
                    "niż jest na magazynie (zamówiono " + existingAmountOfProductInCart + "/" +
                    product.getProductCount().getAvailableAmount() + ")");
			
			return "redirect:/products/product?productId=" + productId;
		}
			
        order.addProductWithAmount(product, amount);

        model.addAttribute("cart", order);
        
        return "redirect:/order/cart";
    }

    @PostMapping("/addAddress")
    public String checkAmountOfProductsAndAskForAddress(Model model, RedirectAttributes redirectAttributes) {
    	try {
    		orderService.checkAmountOfProducts(order);
		} catch (RuntimeException exception) {
			redirectAttributes.addFlashAttribute("error",
					"* Większa ilość danego produktu w koszyku niż jest dostępna w sklepie");
			return "redirect:/order/cart";
		}

    	Address address = new Address();
    	    	
    	model.addAttribute("address", address);
    	
        return "address";
    }
    
    @PostMapping("/postToOrders")
    public String addOrder(@ModelAttribute("address") @Valid Address address, BindingResult bindingResult, 
    		HttpSession session, HttpServletRequest request) {
        if(bindingResult.hasErrors()) {
            return "address";
        }
    	
        Order copyOrder = getCopyOfSessionOrder(order);
        
        String userEmail = request.getUserPrincipal().getName();
        
        copyOrder.setAddress(address);
    	copyOrder.setUserEmail(userEmail);

		orderService.saveOrder(copyOrder);

    	session.invalidate();
    	order = new Order();

        return "redirect:/order/getOrders";
    }
    
    @GetMapping("/getOrders")
    public String getOrders(Model model, HttpServletRequest request) {
    	Set<Order> orders = null;

    	if(RoleChecker.checkIfUserHasRole("ADMIN"))
    		orders = orderService.getAllUniqueOrders();
    	else if(RoleChecker.checkIfUserHasRole("USER")) {
			String email = request.getUserPrincipal().getName();

			orders = orderService.getUniqueOrdersByUserEmail(email);
		}

    	model.addAttribute("orders", orders);

        return "orders";
    }
    
    private Order getCopyOfSessionOrder(Order order) {
    	Order copyOrder = new Order();
    	
    	copyOrder.setOrderId(order.getOrderId());

    	Set<OrderProduct> orderProducts = new LinkedHashSet<OrderProduct>();
    	
    	double sum = 0;
    	
    	for(OrderProduct orderProduct : order.getOrderProducts()) {
    		orderProducts.add(orderProduct);
    		sum += orderProduct.getAmount() * orderProduct.getProduct().getPrize();
    	}
    	
    	copyOrder.setOrderProducts(orderProducts);
    	copyOrder.setSum(sum);
    	copyOrder.setOrderDate(new Date());  	
    	
    	return copyOrder;
    }
}













