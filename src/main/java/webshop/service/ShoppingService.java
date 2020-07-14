package webshop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webshop.domain.Product;
import webshop.domain.ShoppingCart;
import webshop.repository.ShoppingCartRepository;

/**
 * @author yahia
 * @created Jul 12, 2020 - 9:56:57 PM
 * @project WebShop
 */
@Service
public class ShoppingService {
	@Autowired
	ProductCatalogService productCatalogService;
	@Autowired
	ShoppingCartRepository shoppingCartRepository;

	public void addToCart(String cartId, String productnumber, int quantity) {
		Product product = productCatalogService.getProduct(productnumber);
		Optional<ShoppingCart> cartOptional = shoppingCartRepository.findById(cartId);
		if (cartOptional.isPresent() && product != null) {
			ShoppingCart cart = cartOptional.get();
			cart.addToCart(product, quantity);
			shoppingCartRepository.save(cart);
		}
		else if (product != null) {
			ShoppingCart cart = new ShoppingCart();
			cart.setCartid(cartId);
			cart.addToCart(product, quantity);
			shoppingCartRepository.save(cart);
		}		
	}
	
	public ShoppingCart getCart(String cartId) {
		Optional<ShoppingCart> cart = shoppingCartRepository.findById(cartId);
		if (cart.isPresent())
		  return cart.get();
		else
			return null;
	}
}
