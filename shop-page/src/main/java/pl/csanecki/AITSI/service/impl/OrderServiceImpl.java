package pl.csanecki.AITSI.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.csanecki.AITSI.entity.Order;
import pl.csanecki.AITSI.entity.OrderProduct;
import pl.csanecki.AITSI.entity.Product;
import pl.csanecki.AITSI.entity.ProductCount;
import pl.csanecki.AITSI.repository.OrderRepository;
import pl.csanecki.AITSI.repository.ProductCountRepository;
import pl.csanecki.AITSI.repository.ProductRepository;
import pl.csanecki.AITSI.service.OrderService;

import javax.transaction.Transactional;

@Transactional
@Service
public class OrderServiceImpl implements OrderService {
	private OrderRepository orderRepository;
	private ProductCountRepository productCountRepository;
	
	@Autowired
	public OrderServiceImpl(OrderRepository orderRepository, ProductCountRepository productCountRepository) {
		this.orderRepository = orderRepository;
		this.productCountRepository = productCountRepository;
	}
	
	@Override
	public void saveOrder(Order order) throws RuntimeException {
		for(OrderProduct orderProduct : order.getOrderProducts()) {
			ProductCount productCount = orderProduct.getProduct().getProductCount();

			productCount.subtractAmountOfProduct(orderProduct.getAmount());
			productCount.increaseSoldRating(orderProduct.getAmount());

			productCountRepository.save(productCount);

			orderProduct.setOrder(order);
		}
		
		orderRepository.save(order);
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}
	
	@Override
	public Set<Order> getAllUniqueOrders() {
		return new HashSet<>(orderRepository.findAll());
	}

	@Override
	public Set<Order> getUniqueOrdersByUserEmail(String email) {
		List<Order> orders = orderRepository.findAllUserOrders(email);

		return new HashSet<>(orders);
	}

	@Override
	public void checkAmountOfProducts(Order order) throws RuntimeException {
		for(OrderProduct orderProduct : order.getOrderProducts()) {
			Product product = orderProduct.getProduct();

			if(product.getProductCount().getAvailableAmount() < orderProduct.getAmount())
				throw new RuntimeException("Ilość produktu w koszyku nie może być większa niż dostępna w sklepie");

			orderProduct.setOrder(order);
		}
	}
}











