package webshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import webshop.domain.Order;

/**
 * @author yahia
 * @created Jul 19, 2020 - 7:17:49 AM
 * @project WebShop
 */
public interface OrderRepository extends MongoRepository<Order, String> {

}
