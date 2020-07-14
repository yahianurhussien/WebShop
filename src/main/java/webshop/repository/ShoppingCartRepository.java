package webshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import webshop.domain.ShoppingCart;

/**
 * @author yahia
 * @created Jul 12, 2020 - 9:55:28 PM
 * @project WebShop
 */
public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String> {

}
