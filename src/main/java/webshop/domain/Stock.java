package webshop.domain;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author yahia
 * @created Jul 12, 2020 - 9:53:54 PM
 * @project WebShop
 */
@Document
public class Stock {
	int quantity;
	String locationcode;

	public Stock(int quantity, String locationcode) {
		super();
		this.quantity = quantity;
		this.locationcode = locationcode;
	}

	public Stock() {
		super();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getLocationcode() {
		return locationcode;
	}

	public void setLocationcode(String locationcode) {
		this.locationcode = locationcode;
	}

}
