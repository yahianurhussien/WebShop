package webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import webshop.domain.Product;
import webshop.service.ProductCatalogService;

/**
 * @author yahia
 * @created Jul 12, 2020 - 9:49:34 PM
 * @project WebShop
 */
@RestController
public class ProductController {
	@Autowired
	ProductCatalogService productCatalogService;

	@GetMapping("/product/{productnumber}")
	public ResponseEntity<?> getContact(@PathVariable String productnumber) {
		Product product = productCatalogService.getProduct(productnumber);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@PostMapping(value = "/product/{productnumber}/{description}/{price}")
	public ResponseEntity<?> addProduct(@PathVariable String productnumber, @PathVariable String description,
			@PathVariable double price) {
		productCatalogService.addProduct(productnumber, description, price);
		return new ResponseEntity<Product>(HttpStatus.OK);
	}

	@PostMapping(value = "/product/stock/{productnumber}/{quantity}/{locationcode}")
	public ResponseEntity<?> setStock(@PathVariable String productnumber, @PathVariable int quantity, @PathVariable String locationcode){
		productCatalogService.setStock(productnumber, quantity, locationcode);
		return new ResponseEntity<Product>(HttpStatus.OK);
	}
}
