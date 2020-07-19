package webshop.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webshop.domain.Order;
import webshop.domain.OrderLine;
import webshop.domain.ShoppingCart;
import webshop.repository.OrderRepository;

/**
 * @author yahia
 * @created Jul 19, 2020 - 7:16:08 AM
 * @project WebShop
 */
@Service
public class OrderService {

	@Autowired
    private OrderRepository orderRepository;

    public void createOrder(String orderId, ShoppingCart shoppingCart){
        Order order = new Order();
        order.setOrderId(orderId);
        order.setDate(LocalDate.now().toString());
        order.setStatus("Shipped");
        shoppingCart.getCartlineList().forEach(c -> {
            OrderLine orderLine = new OrderLine();
            orderLine.setQuantity(c.getQuantity());
            orderLine.setProduct(c.getProduct());
            order.getOrderLineList().add(orderLine);
        });
        orderRepository.save(order);
    }
    
    public Order getOrder(String orderId) {
    	return orderRepository.findById(orderId).orElse(null);
    }
}
