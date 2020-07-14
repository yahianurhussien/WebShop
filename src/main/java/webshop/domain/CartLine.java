package webshop.domain;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author yahia
 * @created Jul 12, 2020 - 9:52:23 PM
 * @project WebShop
 */
@Document
public class CartLine {
	int quantity;
	Product product;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
