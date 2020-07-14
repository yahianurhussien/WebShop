package webshop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webshop.domain.Product;
import webshop.domain.Stock;
import webshop.repository.ProductRepository;

/**
 * @author yahia
 * @created Jul 12, 2020 - 9:56:20 PM
 * @project WebShop
 */
@Service
public class ProductCatalogService {
	@Autowired
	ProductRepository productRepository;

	public void addProduct(String productnumber, String description, double price) {
		Product product = new Product(productnumber, description,  price);
		productRepository.save(product);
		
	}
	public Product getProduct(String productnumber) {
		Optional<Product> result = productRepository.findById(productnumber);
		if (result.isPresent())
		  return result.get();
		else
			return null;
	}
	public void setStock(String productnumber, int quantity, String locationcode) {
		Optional<Product> result = productRepository.findById(productnumber);
		if (result.isPresent()) {
			Product product = result.get();
			Stock stock = new Stock(quantity, locationcode);
			product.setStock(stock);
			productRepository.save(product);
		}		
	}
}
