package webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import webshop.domain.ShoppingCart;
import webshop.service.ShoppingService;

/**
 * @author yahia
 * @created Jul 12, 2020 - 9:50:46 PM
 * @project WebShop
 */
@RestController
public class ShoppingController {
	@Autowired
	ShoppingService shoppingService;
	
	@PostMapping(value = "/cart/{cartId}/{productnumber}/{quantity}")
	public ResponseEntity<?> addToCart(@PathVariable String cartId, @PathVariable String productnumber, @PathVariable int quantity) {
		shoppingService.addToCart(cartId, productnumber, quantity);
		return new ResponseEntity<ShoppingCart>(HttpStatus.OK);		
	}
	
	@GetMapping("/cart/{cartId}")
	public ResponseEntity<?> getCart(@PathVariable String cartId) {
		ShoppingCart cart = shoppingService.getCart(cartId);
		cart.print();
		return new ResponseEntity<ShoppingCart>(cart, HttpStatus.OK);
	}
	
	@GetMapping("/checkout/{cartId}")
	public ResponseEntity<?> checkoutCart(@PathVariable String cartId) {
		shoppingService.checkout(cartId);
		return new ResponseEntity<String>("Order shipped Successfully", HttpStatus.OK);
	}
	
	
}
