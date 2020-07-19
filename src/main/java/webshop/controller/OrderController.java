package webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import webshop.domain.Order;
import webshop.service.OrderService;

/**
 * @author yahia
 * @created Jul 19, 2020 - 7:30:26 AM
 * @project WebShop
 */
@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	
	@GetMapping("/order/{orderId}")
    public Order getOrder(@PathVariable String orderId) {
		return orderService.getOrder(orderId);
	}
}
