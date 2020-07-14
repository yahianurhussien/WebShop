package webshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import webshop.domain.Product;

/**
 * @author yahia
 * @created Jul 12, 2020 - 9:54:55 PM
 * @project WebShop
 */

public interface ProductRepository extends MongoRepository<Product, String> {

}
